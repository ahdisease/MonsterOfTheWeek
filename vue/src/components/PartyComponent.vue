<template>
  <div id="wrapper">
    <h1 id="partyName">Your Party</h1>
    <div class="party-cards">
      <b-button
        class="your-party"
        v-if="currentParty.length == 0"
        v-on:click="createYourParty"
      >
        Create Your Party
      </b-button>
      <div v-for="character in currentParty" v-bind:key="character.id">
        <character-card v-bind:character="character" v-if="character.active" />
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
#wrapper {
  background-color: #506579;
  width:550px;
  border-radius: 6px;
  padding-bottom: 10px;
  border: 4px solid #00201E;
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
}
#partyName {
    background-color: #00201E;

  font-size: 3em;
  text-align: center;
  color: #00e88a;
}

.party-cards {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.your-party {
  background-color: #00e88a;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  color:#00201e;
}

.your-party:hover {
  background-color: #007f5f;
  color: #00e88a;
}

@media screen and (max-width: 1000px) {
  #wrapper {
  background-color: #00201E;
  width: 100%;
  border-radius: 6px;
  padding-bottom: 10px;
}
}

@media screen and (max-width: 768px) {
  #wrapper {
    /* width: 400px; */
  }
}
</style>