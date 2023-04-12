<template>
  <main>
    <div
      class="monster-card-front"
      v-show="!showDetails"
      v-on:click="turnMonsterCard"
    >
      <img
        v-bind:src="'https://www.dnd5eapi.co' + monster.image"
        alt="image of monster"
      />
    </div>
    <div
      class="monster-card-back"
      v-show="showDetails"
      v-on:click="turnMonsterCard"
    >
      <h3>{{ monster.name }}</h3>
      <div>HP: {{ monster.hit_points }}</div>
      <div>
        <div class="stats-box">
          <div class="stats-name">STRENGTH</div>
          <div class="stats-value" id="str-value"> {{monster.strength}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">DEXTERITY</div>
          <div class="stats-value" id="dex-value"> {{monster.dexterity}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CONSTITUTION</div>
          <div class="stats-value" id="con-value"> {{monster.constitution}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">INTELLIGENCE</div>
          <div class="stats-value" id="int-value"> {{monster.intelligence}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">WISDOM</div>
          <div class="stats-value" id="wis-value"> {{monster.wisdom}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CHARISMA</div>
          <div class="stats-value" id="cha-value"> {{monster.charisma}} </div>
        </div>
      </div>
    </div>

    <party-component/>

  </main>
</template>

<script>
import DndApiService from "../services/DndApiService.js";
import MonsterService from "../services/MonsterService.js";
import PartyComponent from '../components/PartyComponent.vue';

export default {
  name: "monster-splash",
  data() {
    PartyComponent
    return {
      monster: {},
      showDetails: false,
    };
  },
  created() {
    MonsterService.getCurrentMonster().then((response) => {
      if (response.data) {
        DndApiService.getMonstersByIndexName(response.data.nameIndex).then(
          (response) => {
            this.monster = response.data;
          }
        );
      }
    });
  },
  methods: {
    turnMonsterCard() {
      this.showDetails = !this.showDetails;
    },
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
}

main {
  margin: 5%;
}

.monster-card-front,
.monster-card-back {
  text-align: center;
  width: 85vw;
  height: 90vh;
  border-radius: 10px;
  background-color: grey;
  
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.stats-box {
  text-align: center;
  /*TODO ******** check this one again */
  /* margin: 0.5em; */
}

.stats-name {
  font-size: 1.2rem;
  font-weight: 700;
}

.stats-value {
  font-size: 2em;
  background-color: rgb(252, 247, 240);
  width: 50%;
  margin: 0 auto;
  border-radius: 6px;
}

.monster-card-front img {
  max-width: 90%;
  max-height: 90%;
}
</style>