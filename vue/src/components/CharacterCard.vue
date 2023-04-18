<template>
  <div class="card">
    <div
      class="character-card-front"
      v-bind:key="character.id123"
      v-show="cardSide == 1"
      v-on:click="turnCharacterCard"
    >
      <div id="char-name">{{ character.name }}</div>
      <div class="race"><strong>Race:</strong> {{ character.race }}</div>
      <div class="class"><strong>Class:</strong> {{ character.charClass }}</div>
      <div id="description" class="overflow-auto">
        {{ character.description }}
      </div>
    </div>
    <div
      class="character-card-back"
      v-bind:key="character.id124"
      v-show="cardSide == 2"
      v-on:click="turnCharacterCard"
    >
      <div id="char-name">{{ character.name }}</div>
      <div class="race"><strong>Race:</strong> {{ character.race }}</div>
      <div class="class"><strong>Class:</strong> {{ character.charClass }}</div>

      <div class="character-card-back">
        <div id="all-stats">
          <div class="left-stats">
            <div class="attributes">
              <div class="back-attribute">Strength</div>
              <div class="attribute-value left-column">
                {{ character.strength }}
              </div>
            </div>
            <div class="attributes">
              <div class="back-attribute">Dexterity</div>
              <div class="attribute-value left-column">
                {{ character.dexterity }}
              </div>
            </div>
            <div class="attributes">
              <div class="back-attribute">Constitution</div>
              <div class="attribute-value left-column">
                {{ character.constitution }}
              </div>
            </div>
          </div>
          <div class="right-stats">
            <div class="attributes">
              <div class="back-attribute">Intelligence</div>
              <div class="attribute-value right-column">
                {{ character.intelligence }}
              </div>
            </div>
            <div class="attributes">
              <div class="back-attribute">Wisdom</div>
              <div class="attribute-value right-column">
                {{ character.wisdom }}
              </div>
            </div>
            <div class="attributes">
              <div class="back-attribute">Charisma</div>
              <div class="attribute-value right-column">
                {{ character.charisma }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div
      class="character-card-front"
      v-bind:key="character.id123"
      v-show="cardSide == 3"
      v-on:click="turnCharacterCard"
    >
      <div id="char-name">{{ character.name }}</div>
      <div class="race"><strong>Race:</strong> {{ character.race }}</div>
      <div class="class"><strong>Class:</strong> {{ character.charClass }}</div>
      <img id="char-image" v-show="imageIsApproved" v-bind:src="imageUrl" v-bind:alt="'Image of' + character.name" />
      <div v-show="!imageIsApproved">Users did not supply an image or it hasn't been approved.</div>
    </div>
    <div id="button-group">
      <div id="flag-check">
        <b-button
          variant="danger"
          id="flag"
          v-on:click.prevent="markFlagged"
          v-bind:class="isFlagged"
          v-if="isFlaggable && character.flaggedInappropriate != 'flagged'"
        >
          Flag
        </b-button>
        <b-button
          id="approved-btn"
          v-if="confirmModeratorPermissions"
          v-on:click.prevent="markApproved"
          >Approve?</b-button
        >

        <div
          id="checkmark"
          v-bind:class="isApproved"
          v-if="approved && confirmModeratorPermissions"
        >
          Approved
        </div>
      </div>
      <button
        class="delete"
        v-on:click.prevent="deleteCharacterMod"
        v-if="confirmModeratorPermissions"
      >
        &#128465;
      </button>
    </div>
  </div>
</template>

<script>
import CharacterService from "../services/CharacterService.js";
import ModService from "../services/ModService.js";

export default {
  name: "character-card",
  props: ["character", "isFlaggable"],

  data() {
    return {
      showDetails: true,
      approved: false,
      cardSide: 1,
    };
  },
  computed: {
    isFlagged() {
      if (this.character.flaggedInappropriate == "flagged") {
        return "is-flagged";
      }
      return "";
    },
    isApproved() {
      if (this.character.flaggedInappropriate == "reviewed") {
        return "is-reviewed";
      }
      return "";
    },

    confirmModeratorPermissions() {
      let allowed = false;

      this.$store.state.user.authorities.forEach((authority) => {
        if (authority.name === "ROLE_MOD") {
          allowed = this.character.flaggedInappropriate === "flagged";
        }
      });

      return allowed;
    },

    imageUrl() {
      if (this.character.image) {
        return this.character.image.url;
      }
      return "";
    },
    imageIsApproved() {
      if (this.imageUrl) {
        return this.character.image.approved == true;
      }
      return false;
    }
  },
  methods: {
    turnCharacterCard() {
      if (this.cardSide >= 3) {
        this.cardSide = 1;
      } else {
        this.cardSide += 1;
      }
    },
    markFlagged() {
      CharacterService.flaggedInappropriate(this.character.id).then(() => {
        this.$emit("newFlag");
      });
    },
    markApproved() {
      ModService.markedApproved(this.character.id).then(() => {
        this.$emit("newFlag");
      });
    },
    deleteCharacterMod() {
      CharacterService.deleteCharacterMod(this.character.id).then(() => {
        this.$emit("newFlag");
      });
    },
  },
};
</script>

<style scoped>
/* .card {
  height: 280px;
  width: 220px;
  margin: 10px;
  background-color: #00e88a;
  color: black;
  padding: 10px;
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
  border: 4px double #007f5f;
} */

.card {
  height: 280px;
  width: 190px;
  margin: 2px;
  background-color: #00e88a;
  color: black;
  padding: 10px;
  /* Add shadows to create the "card" effect */
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
  border: 4px double #007f5f;
}

.character-card-front {
  display: grid;
  grid-template-areas:
    "char-name char-name"
    "race race"
    "class class"
    "description description"
    "flag delete";

  margin: 0;
  padding: 0;
  row-gap: 2px;
  column-gap: 2px;
  /* grid-template-columns: 1fr 1fr; */
  grid-template-rows: 25px 15px 15px 130px 30px;
  align-items: center;
  /* height: 100%; */
}
#char-name {
  text-align: center;
  grid-area: char-name;
}
.race {
  text-align: center;
  grid-area: race;
}
.class {
  text-align: center;
  grid-area: class;
}
.character-card-back {
  display: grid;
  grid-template-areas:
    "char-name char-name"
    "race race"
    "class class"
    "all-stats all-stats"
    "button-group button-group";
  margin: 0;
  padding: 0;
  /* the grid template columns was making it off-center */
  /* grid-template-columns: 50px 50px; */
  grid-template-rows: 25px 15px 15px 130px 30px;
  row-gap: 2px;
  column-gap: 2px;
  justify-content: space-evenly;
  align-items: center;
  /* height: 100%; */
}
#all-stats {
  justify-content: center;
  display: grid;
  grid-area: all-stats;
  grid-template-areas: "left-stats right-stats";
  grid-template-columns: 80px 80px;
}

.left-stats {
  grid-area: left-stats;
  /* justify-content: center; */
  /* align-items: center; */
}

.right-stats {
  grid-area: right-stats;
  /* justify-content: center; */
}

.race-class {
  /* margin: 1rem; */
  font-weight: 500;
  font-style: oblique;
  background-color: rgba(23, 64, 119, 0.1);
  box-shadow: 0 0 15px 15px rgba(23, 64, 119, 0.1);
  border-radius: 50%;
}

.attributes {
  text-align: center;
  /* margin: 0 auto; */
}

.back-attribute {
  font-size: 0.8rem;
  font-weight: 500;
}

.attribute-value {
  color: rgb(69, 70, 7);
  font-weight: 600;
  background-color: rgb(214, 233, 245);
  border-radius: 20%;
  width: 30px;
  align-content: center;
}
.left-column {
  margin: 0 auto;
}
.right-column {
  margin: 0 auto;
}
/* .int-align {
  margin-right: 11px;
} */
#button-group {
  grid-area: button-group;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
#flag {
  /* background-color: rgba(0, 0, 0); */
  border: 1px solid black;
  padding: 2px;
}
#checkmark {
  background: black;
  height: 100px;

  /* \F26E */
}
#checkmark.is-reviewed {
  height: 100px;
  background-color: blue;
}
#flag:hover {
  background-color: rgb(252, 10, 10);
  box-shadow: 0 0 6px 6px rgba(255, 80, 80, 0.1);
  border-radius: 6px;
}
.delete {
  grid-area: delete;
  position: relative;
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid rgba(0, 0, 0, 0);
  padding: 0;
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
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.9);
  border: 4px double #03ad83;
}
#char-name {
  margin-top: 10px 0 5px 0;
  font-size: 1.2rem;
  font-weight: 800;
}
#description {
  grid-area: description;
  width: 162px;
  height: 130px;
  /* align-self: flex-start; */
  font-style: italic;
  font-size: 0.9rem;
  overflow: auto;

  -webkit-mask-image: linear-gradient(180deg, #000 88%, transparent);
}

#description::-webkit-scrollbar {
  display: none;
}
#char-image {
  width: 100px;
  max-height: 150px;
  margin: auto 25%;
  border-radius: 5px;
}
</style>