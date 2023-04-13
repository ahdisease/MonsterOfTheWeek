<template>
  <div>
    <div id="party-cards">
      <character-card
        v-for="character in currentParty"
        v-bind:key="character.id"
        v-bind:character="character"
      />
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
h1 {
  text-align: center;
}

#party-cards {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
  width: 100%;
}

#firstChar {
  background-color: blueviolet;
}
#secondChar {
  background-color: rgb(145, 59, 224);
}
#thirdChar {
  background-color: blueviolet;
}
#fourthChar {
  background-color: rgb(145, 59, 224);
}
</style>