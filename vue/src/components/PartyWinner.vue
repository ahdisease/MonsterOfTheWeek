<template>
  <div id="wrapper">
    <div id="winner-title">
      <h3>Last Week's Winning Party</h3>
    </div>

    <div class="party-display">
      <div
        v-for="character in winningParty"
        v-bind:key="character.id700"
      >
        <character-card v-bind:character="character" v-if="character.active">
          {{ character.race }}
          {{ character.charClass }}
          {{ character.strength }}
          {{ character.dexterity }}
          {{ character.constitution }}
          {{ character.intelligence }}
          {{ character.wisdom }}
          {{ character.charisma }}
        </character-card>
      </div>
    </div>
  </div>
</template>

<script>
import CharacterCard from "./CharacterCard.vue";
import CharacterService from "../services/CharacterService.js";

export default {
  components: { CharacterCard },
  name: "party-winner",
  data() {
    return {
      winningParty: [],
    };
  },

  // change hard coded date

  created() {
    let lastWeek = new Date();  //date object instantiates to today
    lastWeek.setDate(lastWeek.getDate()-7);

    CharacterService.getWinningParty(lastWeek.toJSON().slice(0, 10)).then((response) => {
      
      if (response.data) {
        const partyObject = response.data;
        CharacterService.getCharacterById(partyObject.characterOne).then(
          (response) => {
            this.winningParty.push(response.data);
          }
        );
        CharacterService.getCharacterById(partyObject.characterTwo).then(
          (response) => {
            this.winningParty.push(response.data);
          }
        );
        CharacterService.getCharacterById(partyObject.characterThree).then(
          (response) => {
            this.winningParty.push(response.data);
          }
        );
        CharacterService.getCharacterById(partyObject.characterFour).then(
          (response) => {
            this.winningParty.push(response.data);
          }
        );
      }
    });
  },
};
</script>

<style scoped>
#wrapper {
  border: 4px solid #00E88A;
  padding: 10px;
  /* border-width: 10px 1px 1px 0; */
  border-radius: 6px;
  width: 100%;
  background-color: #00201E;
  /* background-image: linear-gradient(#15867f, #035a54); */
}
#winner-title {
  padding: 10px;
  /* height: 50px; */
  /* background-image: linear-gradient( rgba(255,0,0,1), rgba(255,0,0,0)); */
  /* This is a temporary color to see where it is */
}
#winner-title h3 {
  background-image: linear-gradient(
    to right,
    #462523 0,
    #cb9b51 22%,
    #f6e27a 45%,
    #f6f2c0 50%,
    #f6e27a 55%,
    #cb9b51 78%,
    #462523 100%
  );
  color: transparent;
  -webkit-background-clip: text;
  background-clip: text;
  font-size: 2em;
  text-align: center;
}
.party-display {
  display: flex;
  /* flex-direction: row; */
  flex-wrap: wrap;
  justify-content: space-evenly;
}

@media screen and (max-width: 768px) {
  /* #wrapper {
    width: 50%;
  } */
}
</style>
