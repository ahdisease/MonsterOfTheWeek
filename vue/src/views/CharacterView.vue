<template>
  <div class="completed-char">
    <div role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <div v-if="!showError">
      <character-creator v-if="!characterCreated" />
      <character-view-detailed v-if="characterCreated" />
    </div>
  </div>
</template>

<script>
import CharacterViewDetailed from "../components/CharacterViewDetailed.vue";
import CharacterCreator from "./CharacterCreator.vue";

export default {
  name: "character-view",

  data() {
    return {
      showError: false,
      errorMessage: "Sorry, You have been banned.",
    };
  },

  components: {
    CharacterViewDetailed,
    CharacterCreator,
  },
  computed: {
    characterCreated() {
      let created = Object.keys(this.$store.state.userCharacter).length !== 0;
      if (created) {
        created = this.$store.state.userCharacter.name !== "";
      }

      return created;
    },
  },

  methods: {
    showBanMessage() {
      if (this.$store.state.user.authorities[0].name === "ROLE_BAN") {
        this.showError = true;
      }
    },
  },

  created() {
    this.showBanMessage();
  },
};
</script>

<style scoped>
.completed-char {
  background-color: #3a5268;
}

#addHomeform {
  display: grid;
  grid-template-areas:
    "title"
    "homeForm";
  grid-template-columns: 2fr;
  justify-content: center;
  align-items: center;

  background: #3a5268;
  margin: auto;
  padding-top: 10px;
  width: 90%;
  background-color: #607f9b;
  /* padding: 1% 2%; */
}

#title {
  grid-area: title;
  color: #00e88a;
  background: #00201e;
}

#title h1 {
  text-align: center;
  font-size: 4em;
  color: #00e88a;
  background: #00201e;
}

.homeForm {
  grid-area: homeForm;
  width: 100%;
  margin: 0;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "race   name-box   class"
    "lcol     picture   rcol"
    "lcol     picture   rcol"
    "desc     desc      desc"
    ".        buttons   .";
  gap: 10px;
  justify-content: center;
  align-content: center;
}

.form-control {
  width: auto;
  height: auto;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;

  /* border: 1px solid #ced4da; */
  border-radius: 0.25rem;
}

#name-box {
  margin: 10px auto;
  grid-area: name-box;
  justify-content: center;
  align-content: center;
  text-align: center;
  color: #00e88a;
  font-size: 2rem;
}

#race-class {
  text-align: center;
}

#race {
  grid-area: race;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #00e88a;
  font-size: 2rem;
}

#race-selection {
  width: 150px;
  margin: 5px auto;
  height: 40px;

  /* this is the dropdown area for race */
}

#picture {
  grid-area: picture;
  justify-content: center;
  align-content: center;
  height: 20%;
}

.cloud {
  grid-area: cloud;
  justify-self: center;
  align-self: center;
}

#char-pic {
  width: 100%;
  height: auto;
  align-content: center;
  justify-content: center;
}

#class {
  grid-area: class;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #00e88a;
  font-size: 2rem;
}

#class-selection {
  width: 150px;
  margin: 3px auto;
  height: 40px;
  /* this is the drop down for class */
}

#lcol {
  grid-area: lcol;
  justify-content: center;
  align-content: center;
  background-color: #00201e;
}

#rcol {
  grid-area: rcol;
  justify-content: stretch;
  align-content: center;
  background-color: #00201e;
}

#desc {
  grid-area: desc;
  margin: 10px 0;
  text-align: center;
  justify-content: center;
  align-self: center;
  color: #00e88a;
  font-size: 2rem;
}

#description {
  width: 90%;
  margin-left: 5%;
}

#buttons {
  grid-area: buttons;
  margin: auto;
}

textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}

select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}

.stats-column {
  background-color: #00201e;
  border-radius: 3px;
  padding: 0.1em;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  color: #00e88a;
}

.stats-box {
  text-align: center;
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

button {
  border-radius: 6px;
  margin: 0 10px 0 0;
}

#cloud-btn {
  color: #fff;
  padding: 7px;
  background-color: #00e88a;
  border-radius: 6px;
}

.btn-submit {
  color: #fff;
  padding: 10px 24px;
  background-color: #00e88a;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-cancel {
  padding: 10px 24px;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-submit:hover {
  color: #fff;
  padding: 10px 24px;
  background-color: #00e88a;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-cancel:hover {
  padding: 10px 24px;
  background-color: #00e88a;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}

@media screen and (max-width: 768px) {
  #addHomeform {
    margin: 0 auto;
    width: 95%;
    background-color: lightgray;
    padding: 1% 2%;
  }

  .homeForm {
    padding: 10px;
    margin-bottom: 10px;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
      "name-box name-box"
      "race class"
      "picture picture"
      "lcol rcol"
      "desc desc"
      "buttons buttons";
    gap: 2px;
  }
  #title h1 {
    text-align: center;
    font-size: 3em;
  }
  #picture {
    margin: 0 auto;
  }
  #picture img {
    width: 60%;
    margin: 0 auto;
  }
}
</style>
