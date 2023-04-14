<template>
  <div class="card">
    <div class="character-card-front" v-bind:key="character.id123"
      v-show="!showDetails" v-on:click="turnCharacterCard">
      <div id="char-name">{{ character.name }}</div>
      <div class="race-class">{{ character.race }} {{ character.charClass }}</div>
      <div id="description">{{ character.description }}</div>
      
    </div>
    <div class="character-card-back" v-bind:key="character.id124"
      v-show="showDetails" v-on:click="turnCharacterCard">
      <div class="race-class" id="race-class-back">{{ character.race }} {{ character.charClass }}</div>
      <div class="attributes" id="str">Strength: {{ character.strength }}</div>
      <div class="attributes" id="dex">Dexterity: {{ character.dexterity }}</div>
      <div class="attributes" id="con">Constitution: {{ character.constitution }}</div>
      <div class="attributes" id="int">Intelligence: {{ character.intelligence }}</div>
      <div class="attributes" id="wis">Wisdom: {{ character.wisdom }}</div>
      <div class="attributes" id="cha">Charisma: {{ character.charisma }}</div>
    </div>
    <button>flag</button>
  </div>
</template>

<script>
export default {
  name: "character-card",
  props: ["character"],
  data() {
    return {
      showDetails: true,
    };
  },
  methods: {
    turnCharacterCard() {
      this.showDetails = !this.showDetails;
    },
  }
};
</script>

<style scoped>
.card {
  height: 280px;
  width: 200px;
  margin: 10px;
  background-color: rgb(185, 199, 212);
  color: black;
  padding: 10px;
  /* Add shadows to create the "card" effect */
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
}

.character-card-front {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
}

.character-card-back {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;

}

#race-class-back {
  margin-top: 10px;
}

.card img {
  width: 35%;
  height: auto;
}
/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.4);
  border: 3px solid rgb(25, 55, 65);
}

#char-name {
  margin-top: 10px;
  font-size: 1.2rem;
  font-weight: 800;
}

#description {
  align-self: flex-start;
  font-style: italic;
}

.race-class {
  margin-bottom: 30px;
  font-weight: 500;
  font-style: oblique;
}

.attributes {
  align-self: flex-start;
}



</style>