<template>
  <div>
    <div class="party-cards">
      <div class="your-party">Your Party</div>
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
};
</script>

<style scoped>

.party-cards {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

/* .your-party {
  
} */

</style>