<template>
  <main>
    <!-- The code below this works **** -->
    <div class="container">
      <h1 id="monsterName">{{ monster.name }}</h1>

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
      <!-- The code above this works ***** -->

      <!-- Below this is what works -->
      <div
        class="monster-card-back"
        v-show="showDetails"
        v-on:click="turnMonsterCard"
      >
        <!-- <h3>{{ monster.name }}</h3> -->
        <div class="hit-points">HP: {{ monster.hit_points }}</div>
        <div class="all-stats">
          <div class="stats-box">
            <div class="stats-name">STRENGTH</div>
            <div class="stats-value" id="str-value">{{ monster.strength }}</div>
          </div>
          <div class="stats-box">
            <div class="stats-name">DEXTERITY</div>
            <div class="stats-value" id="dex-value">
              {{ monster.dexterity }}
            </div>
          </div>
          <div class="stats-box">
            <div class="stats-name">CONSTITUTION</div>
            <div class="stats-value" id="con-value">
              {{ monster.constitution }}
            </div>
          </div>
          <div class="stats-box">
            <div class="stats-name">INTELLIGENCE</div>
            <div class="stats-value" id="int-value">
              {{ monster.intelligence }}
            </div>
          </div>
          <div class="stats-box">
            <div class="stats-name">WISDOM</div>
            <div class="stats-value" id="wis-value">{{ monster.wisdom }}</div>
          </div>
          <div class="stats-box">
            <div class="stats-name">CHARISMA</div>
            <div class="stats-value" id="cha-value">{{ monster.charisma }}</div>
          </div>
        </div>
      </div>
      <!-- This is the end of the div that works *** -->
    </div>
  </main>
</template>

<script>
import DndApiService from "../services/DndApiService.js";
import MonsterService from "../services/MonsterService.js";

export default {
  name: "monster-splash",
  data() {
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
    //This method is the working one
    turnMonsterCard() {
      this.showDetails = !this.showDetails;
    },

  },
};
</script>

<style scoped>
body {
  background: #096660;
}

h3 {
  text-align: center;
}

/* main {
  margin: 5%;
} */
#monsterName {
  font-size: 3em;
  text-align: center;
}

.monster-card-front,
.monster-card-back {
  width: 100%;
  height: auto;
  border-radius: 10px;
  background-color: #c52b1e;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.monster-card-back h3 {
  padding: 10px;
  font-size: 2.5em;
}
.hit-points {
  font-weight: bold;
  font-size: 1.25em;
  /* padding: 5px; */
}
.all-stats {
  display: flex;
  flex-wrap: wrap;
  padding: 10px;
  gap: 10px;
  /* justify-content:space-around; */
  align-content: space-around;
}

.stats-box {
  text-align: center;
  flex: 30%;
}

.stats-name {
  font-size: 1em;
  font-weight: 500;
}

.stats-value {
  font-size: 1em;
  background-color: rgb(252, 247, 240);
  width: 50%;
  margin: 0 auto;
  border-radius: 6px;
}

.monster-card-front img {
  max-width: 100%;
  max-height: auto;
  border-radius: 10px;
}

/* 
@media screen and (max-width: 1000px) {
  

  .stats-name {
  font-size: .9em;
  font-weight: 500;
}



} */
</style>