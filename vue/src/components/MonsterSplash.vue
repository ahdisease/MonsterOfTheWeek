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
    MonsterService.getMonsterByDate("2020-01-02").then((response) => {
      if ((response.status == 200)) {
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
.monster-card-front,
.monster-card-back {
  text-align: center;
  width: 70vw;
  height: 70vh;
  border-radius: 10px;
  background-color: grey;
}
</style>