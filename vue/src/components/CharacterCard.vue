<template>
  <div class="card">
    <div class="character-card-front" v-bind:key="character.id123"
      v-show="!showDetails" v-on:click="turnCharacterCard">
      <div id="char-name">{{ character.name }}</div>
      <div class="race-class" id="race">{{ character.race }}</div>
      <div class="race-class" id="class">{{ character.charClass }}</div>
      <div id="description">{{ character.description }}</div>
      
    </div>
    <div class="character-card-back" v-bind:key="character.id124"
      v-show="showDetails" v-on:click="turnCharacterCard">
      <div class="race-class">{{ character.race }} {{ character.charClass }}</div>
      <div class="attributes" id="str">Strength: {{ character.strength }}</div>
      <div class="attributes" id="dex">Dexterity: {{ character.dexterity }}</div>
      <div class="attributes" id="con">Constitution: {{ character.constitution }}</div>
      <div class="attributes" id="int">Intelligence: {{ character.intelligence }}</div>
      <div class="attributes" id="wis">Wisdom: {{ character.wisdom }}</div>
      <div class="attributes" id="cha">Charisma: {{ character.charisma }}</div>
    </div>
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
  display: grid;
  grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas:  ".    name    ."
                        "race .    class"
                        "desc desc desc"
                        "desc desc desc"
                        "desc desc desc"
                        "desc desc desc";
}

.character-card-back {
  display: grid;
  justify-content: center;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas:  
                        "race-class race-class race-class"
                        ". . ."
                        "str str str"
                        "dex dex dex"
                        "con con con"
                        "int int int"
                        "wis wis wis"
                        "cha cha cha";
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
  grid-area: name;
}

.race-class {
  grid-area: race-class;
}

#description {
  grid-area: desc;
}

.attributes {
  grid-area: attr;
}

#str {
  grid-area: str;
}

#dex {
  grid-area: dex;
}

#con {
  grid-area: con;
}

#int {
  grid-area: int;
}

#wis {
  grid-area: wis;
}

#cha {
  grid-area: cha;
}

</style>