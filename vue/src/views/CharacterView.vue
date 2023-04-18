<template>
  <div class="completed-char">
    <div id="ban-message" role="alert" v-if="showError">
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
  margin: 100px auto 0 auto;
  width: 90%;
  background-color: lightgray;
  /* padding: 1% 2%; */
}

/* #title {
 grid-area: h1; 
} */
#title h1 {
  text-align: center;
  font-size: 4em;
  
}

.homeForm {
  width: 100%;
  /* TODO ******* THE GRID IS STILL OFF CENTER */
  /* padding: 10px; */
  margin: 0 auto;
  margin-left: 0px;
  margin-right: 0px;
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:  
    /* "title    title     title" */
    ".        name-box      ."
    "race     picture   class"
    "lcol     picture   rcol"
    "desc     desc      desc"
    ".        buttons   .";
  gap: 10px;
  justify-content: center;
  align-content: center;
}

.form-control {
  width: 90%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}

#name-box {
  margin: 10px auto;
  grid-area: name-box;
  text-align: center;
  color: #38b412;
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
  color: #38b412;
  font-size: 2rem;
}


#picture {
  grid-area: picture;
}

#char-pic {
  background-color: #3a5268;
  width: 100%;
  /* max-width: 100%; */
  height: auto;
  margin: 50px 0 0 0;
  align-content: center;
  justify-content: center;
}

#class {
  grid-area: class;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #38b412;
  font-size: 2rem;
}


#lcol {
  grid-area: lcol;
  background-color: #00201e;
}

#rcol {
  grid-area: rcol;
  background-color: #00201e;
}

#desc {
  grid-area: desc;
  margin: 10px 0;
  text-align: center;
  color: #38b412;
  font-size: 2rem;
  
}

#buttons {
  grid-area: buttons;
  margin: auto;
}


.stats-column {
  background-color: #00201e;
  border-radius: 3px;
  padding: 0.1em;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
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
  background-color: #00201e;
  width: 50%;
  margin: 0 auto;
  border-radius: 6px;
}

button {
  border-radius: 6px;
  margin: 0 10px 0 0;
}

.btn-submit {
  color: #fff;
  padding: 10px 24px;
  background-color: #38b412;
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
  background-color: #65f307;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-cancel:hover {
  padding: 10px 24px;
  background-color: #65f307;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}

.character-details {
    color: black
}

.description-box {
    color: black;
    font-size: .5em;
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
