<template>
  <main>
    <div>
      <!-- The code below this works **** -->
      <div id="container">
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
              <div class="stats-name">Strength</div>
              <div class="stats-value" id="str-value">
                {{ monster.strength }}
              </div>
            </div>
            <div class="stats-box">
              <div class="stats-name">Intelligence</div>
              <div class="stats-value" id="int-value">
                {{ monster.intelligence }}
              </div>
            </div>

            <div class="stats-box">
              <div class="stats-name">Dexterity</div>
              <div class="stats-value" id="dex-value">
                {{ monster.dexterity }}
              </div>
            </div>
            <div class="stats-box">
              <div class="stats-name">Wisdom</div>
              <div class="stats-value" id="wis-value">{{ monster.wisdom }}</div>
            </div>

            <div class="stats-box">
              <div class="stats-name">Constitution</div>
              <div class="stats-value" id="con-value">
                {{ monster.constitution }}
              </div>
            </div>

            <div class="stats-box">
              <div class="stats-name">Charisma</div>
              <div class="stats-value" id="cha-value">
                {{ monster.charisma }}
              </div>
            </div>
          </div>
        </div>
        <!-- This is the end of the div that works *** -->
      </div>
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
/* body {
  background: #096660;
} */

h3 {
  text-align: center;
}
#container {
  border-radius: 6px;
  background-color: #00201e;
  border: 4px solid #00201e;
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
}
/* main {
  margin: 5%;
} */
#monsterName {
  font-size: 3em;
  text-align: center;
  color: #00e88a;
}

.monster-card-front {
  width: 100%;
  /* height: auto; */
  border-radius: 10px;
  background-color: #00201e;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  max-width: 512px;
  height: 512px;
  user-select: none;
}
.monster-card-front:hover{
  cursor: pointer;
}
.monster-card-back {
  width: 100%;
  border-radius: 10px;
  background-color: #00201e;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  max-width: 512px;
  height: 512px;
  user-select: none;
}
.monster-card-back:hover{
  cursor: pointer;
}

.monster-card-back h3 {
  padding: 10px;
  font-size: 2.5em;
}
.hit-points {
  font-weight: bold;
  font-size: 1.6em;
  color: #00e88a;
  margin-top: 50px;

  /* padding: 5px; */
}
.all-stats {
  display: flex;
  flex-wrap: wrap;
  width: 70%;
  padding: 30px 20px;
  gap: 20px;
  /* justify-content:space-around; */
  align-content: space-around;
  color: #00e88a;
}

.stats-box {
  text-align: center;

  flex: 30%;
}

.stats-name {
  font-size: 1.4em;
  font-weight: 500;
}

.stats-value {
  font-size: 1.4em;
  /* background-color: #FFFFFF; */
  background-color: lightgray;

  width: 50%;
  margin: 0 auto;
  border-radius: 6px;
  padding: 10px;
  color: black;
}

.monster-card-front img {
  max-width: 100%;
  max-height: auto;
  border-radius: 10px;
}


@media screen and (max-width: 1200px) {
  
.all-stats {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 90%;
  padding: 10px 5px;
  gap: 10px;
  /* justify-content:space-around; */
  align-content: space-around;
  color: #00e88a;
}
.stats-value {
  font-size: 1.1em;
  /* background-color: #FFFFFF; */
  background-color: lightgray;

  margin: 0 auto;
  border-radius: 6px;
  padding: 10px;
  color: black;
}
.stats-box {
  text-align: center;

  flex: 40%;
}


} 
</style>