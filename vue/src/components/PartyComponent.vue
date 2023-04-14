<template>
  <div>
    <div class="party-cards">
      <button class="your-party" v-on:click="createYourParty">Create Your Party</button>
      <div 
      v-for="character in currentParty"
        v-bind:key="character.id">
      <character-card
        v-bind:character="character"
        v-if="character.active"
      />
      </div>
    </div>
  </div>
</template>

<script>
import CharacterCard from "../components/CharacterCard.vue";
import CharacterService from "../services/CharacterService.js";

export default {
  name: "party-component",
  components: {
    CharacterCard,
  },
  data() {
    return {
      currentParty: [],
    };
  },
  created() {
    CharacterService.getPartyByUsername(this.$store.state.user.username).then(
      (response) => {
        
        if (response.data) {
          
          const partyObject = response.data;
          CharacterService.getCharacterById(partyObject.characterOne).then(
            (response) => {
              this.currentParty.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterTwo).then(
            (response) => {
              this.currentParty.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterThree).then(
            (response) => {
              this.currentParty.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterFour).then(
            (response) => {
              this.currentParty.push(response.data);
            }
          );
        }
      }
    );
  },
  methods: {
    createYourParty() {
      this.$router.push({name: "party"});
    }
  }
};
</script>

<style scoped>

.party-cards {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.your-party {
  background-color: #00E88A;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}


</style>