<template>
  <div class="character-card" v-bind:key="character.id">
    <div id="char-name">{{ character.name }}</div>
    <div id="race-class">{{ character.charClass }}</div>
    <div id="race-class">{{ character.race }}</div>
    <div id="description">{{ character.description }}</div>
    <div id="attributes">Strength: {{ character.strength }}</div>
    <div id="attributes">Dexterity: {{ character.dexterity }}</div>
    <div id="attributes">Constitution: {{ character.constitution }}</div>
    <div id="attributes">Intelligence: {{ character.intelligence }}</div>
    <div id="attributes">Wisdom: {{ character.wisdom }}</div>
    <div id="attributes">Charisma: {{ character.charisma }}</div>
  </div>
</template>

<script>
export default {
  name: "character-card",
  props: ["character"],
  data() {
    return {};
  },
};
</script>

<style scoped>
.character-card {
  display: flex;
  height: 280px;
  width: 200px;
  margin: 10px 0;
  background-color: slategray;
  color: black;
  padding: 10px;
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.character-card img {
  width: 35%;
  height: auto;
}
/* On mouse-over, add a deeper shadow */
.character-card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}
/* Add some padding inside the card container */
.container {
  padding: 2px 10px;
  margin: 5%;
}
</style>