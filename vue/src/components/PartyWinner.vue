<template>
  <div id="wrapper">
    <div id="winner-title">
      <h3>Last Week's Winning Party</h3>
    </div>

    <div class="party-display">
      <div class="the-cards" v-for="character in winningParty" v-bind:key="character.id700">
        <character-card v-bind:character="character">
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

  created() {
    CharacterService.getWinningParty("2023-04-09").then(
      (response) => {
        this.winningParty = response.data;
      }
    );
  },
};
</script>

<style scoped>
#wrapper {
  border: solid linear-gradient( rgb(0, 0, 0), rgba(255,0,0,0));
  border-width: 10px 1px 1px 0;
  border-radius: 6px;
  width: 100%;
  background-image: linear-gradient( rgba(0, 60, 255, 0.945), rgba(255,0,0,0));

}
#winner-title {
    padding: 10px;
    height: 50px;
  /* background-image: linear-gradient( rgba(255,0,0,1), rgba(255,0,0,0)); */
    /* This is a temporary color to see where it is */
}
#winner-title h3 {
    color: whitesmoke;
    text-align: center;
}
.party-display{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
    
}










</style>