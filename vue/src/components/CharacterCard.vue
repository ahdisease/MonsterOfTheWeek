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
        <div class="left-stats">
          <div class="attributes">
            <div class="back-attribute">Strength</div>
            <div class="attribute-value left-column">{{ character.strength }}</div>
          </div>
          <div class="attributes">
            <div class="back-attribute">Dexterity</div>
            <div class="attribute-value left-column">{{ character.dexterity }}</div>
          </div>
          <div class="attributes">
            <div class="back-attribute">Constitution</div>
            <div class="attribute-value left-column">{{ character.constitution }}</div>
          </div>
        </div>
        <div class="right-stats">
          <div class="attributes">
            <div class="back-attribute">Intelligence</div>
            <div class="attribute-value right-column">{{ character.intelligence }}</div>
          </div>
          <div class="attributes">
            <div class="back-attribute">Wisdom</div>
            <div class="attribute-value right-column">{{ character.wisdom }}</div>
          </div>
          <div class="attributes">
            <div class="back-attribute">Charisma</div>
            <div class="attribute-value right-column">{{ character.charisma }}</div>
          </div>
        </div>
      </div>
    </div>
    <div id="button-group">
      <button
        id="flag"
        v-on:click.prevent="markFlagged" 
        v-bind:class="isFlagged"
        v-show="isFlaggable"
      >
        &#128681;
      </button>
      <button class="delete" v-on:click.prevent="deleteCharacterMod" v-if="confirmModeratorPermissions">
        &#128465;
      </button>
    </div>
    
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
        return "is-flagged";
      }
      return "";
    },
    confirmModeratorPermissions() {
      let allowed = false;

      this.$store.state.user.authorities.forEach(authority => {
        if(authority.name === 'ROLE_MOD') {
          allowed = this.character.flaggedInappropriate === "flagged";
        }
      })

      return allowed;
    }
  },
  methods: {
    turnCharacterCard() {
      this.showDetails = !this.showDetails;
    },
    markFlagged() {
      CharacterService.flaggedInappropriate(this.character.id).then(() => {
        this.$emit('newFlag')
      });
    },
    deleteCharacterMod() {
      CharacterService.deleteCharacterMod(this.character.id).then(() => {
        this.$emit('newFlag')
      });
    }
  },
};
</script>

<style scoped>
.card {
  height: 280px;
  width: 220px;
  margin: 10px;
  background-color: #00E88A;
  color: black;
  padding: 10px;
  /* Add shadows to create the "card" effect */
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
  border: 4px double #007F5F;
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

.left-stats {
  justify-content: center;

}

.right-stats {
  justify-content: center;

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
  align-content: center;
}

.left-column {
  margin: 0 0 0 20px;
}

.right-column {
  margin: 0 0 0 20px;
}
/* .int-align {
  margin-right: 11px;
} */

#flag:hover {
  background-color: rgba(255, 80, 80, 0.1);
  box-shadow: 0 0 6px 6px rgba(255, 80, 80, 0.1);
  border-radius: 50%;
}

#flag {
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid rgba(0, 0, 0, 0);
}

.delete {
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid rgba(0, 0, 0, 0);
  padding: 0;
}

#button-group {
  display: flex;
  justify-content: space-between;
}

#flag.is-flagged {
  background-color: rgb(146, 28, 28, 0.2);
  border-radius: 50%;
  padding: 0;
}

.card img {
  width: 35%;
  height: auto;
}
/* On mouse-over, add a deeper shadow */
.card:hover {
  border: 3px darkgreen solid;
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