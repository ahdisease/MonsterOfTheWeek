<template>
  <div class="card">
    <div
      class="character-card-front"
      v-bind:key="character.id123"
      v-show="!showDetails"
      v-on:click="turnCharacterCard"
    >
      <div id="char-name">{{ character.name }}</div>
      <div class="race-class">
        {{ character.race }} {{ character.charClass }}
      </div>
      <div id="description">{{ character.description }}</div>
    </div>
    <div
      class="character-card-back"
      v-bind:key="character.id124"
      v-show="showDetails"
      v-on:click="turnCharacterCard"
    >
      <div class="race-class">
        {{ character.race }} {{ character.charClass }}
      </div>

      <div class="character-card-back">
        <div class="attributes">
          <div class="back-attribute">Strength</div>
          <div class="attribute-value left-column">{{ character.strength }}</div>
        </div>
        <div class="attributes">
          <div class="back-attribute">Dexterity</div>
          <div class="attribute-value right-column">{{ character.dexterity }}</div>
        </div>
        <div class="attributes">
          <div class="back-attribute">Constitution</div>
          <div class="attribute-value left-column">{{ character.constitution }}</div>
        </div>
        <div class="attributes">
          <div class="back-attribute">Intelligence</div>
          <div class="attribute-value right-column">{{ character.intelligence }}</div>
        </div>
        <div class="attributes">
          <div class="back-attribute">Wisdom</div>
          <div class="attribute-value left-column">{{ character.wisdom }}</div>
        </div>
        <div class="attributes">
          <div class="back-attribute">Charisma</div>
          <div class="attribute-value right-column">{{ character.charisma }}</div>
        </div>
      </div>
    </div>
    <button
      id="flag"
      v-on:click.prevent="markFlagged"
      v-bind:class="isFlagged"
      v-show="isFlaggable"
    >
      &#128681;
    </button>
  </div>
</template>

<script>
import CharacterService from "../services/CharacterService.js";

export default {
  name: "character-card",
  props: ["character", "isFlaggable"],

  data() {
    return {
      showDetails: true,
    };
  },
  computed: {
    isFlagged() {
      if (this.character.flaggedInappropriate == "flagged") {
        return "flag-button";
      }
      return "";
    },
  },
  methods: {
    turnCharacterCard() {
      this.showDetails = !this.showDetails;
    },
    markFlagged() {
      CharacterService.flaggedInappropriate(this.character.id).then();
    },
  },
};
</script>

<style scoped>
.card {
  height: 280px;
  width: 200px;
  margin: 10px;
  background-color: rgb(207, 225, 243);
  color: black;
  padding: 10px;
  /* Add shadows to create the "card" effect */
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
  border: 4px double darkblue;
}

.character-card-front {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
}

.character-card-back {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 10px;
  margin-bottom: 6px;
}

.race-class {
  margin: 1rem;
  font-weight: 500;
  font-style: oblique;
  background-color: rgba(23, 64, 119, 0.1);
  box-shadow: 0 0 15px 15px rgba(23, 64, 119, 0.1);
  border-radius: 50%;
}

.attributes {
  text-align: center;
}

.back-attribute {
  font-size: 0.8rem;
  font-weight: 500;
}

.attribute-value {
  color:rgb(69, 70, 7);
  font-weight: 600;
  background-color: rgb(214, 233, 245);
  border-radius: 20%;
  width: 30px;
}

.left-column {

}

.right-column {

}
/* .int-align {
  margin-right: 11px;
} */

#flag:hover {
  background-color: rgba(146, 28, 28, 0.3);
  box-shadow: 0 0 6px 6px rgba(146, 28, 28, 0.3);
  border-radius: 50%;
}

#flag {
  position: relative;
  margin: 0 0 0 auto;
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid rgba(0, 0, 0, 0);
  padding: 0;
}

.flag-button {
  background-color: rgb(146, 28, 28);
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
  font-size: 0.9rem;
}

</style>