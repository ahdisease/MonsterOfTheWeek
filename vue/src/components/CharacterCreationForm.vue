<template>
  <div id="addHomeform">
    <div id="title">
      <h1>Character Creator</h1>
    </div>
    <!-- TODO ********* this error message needs to display correctly? -->
    <!-- <p class="status-message error" v-show="errorMessage != ''">{{errorMessage}}</p> -->
    <form class="homeForm" v-on:submit.prevent="submitForm">
      <div class="name-group" id="name-box">
        <label for="name">Name</label>
        <input
          id="name"
          type="text"
          class="form-control"
          v-model="newCharacter.name"
        />
      </div>

      <!-- <div id="race-class"> -->
      <div class="race-class-group" id="race">
        <label for="race">Race</label>
        <select
          id="race-selection"
          class="form-control"
          v-model="newCharacter.race"
        >
          <option
            v-for="race in dropdownRace"
            v-bind:key="race.id"
            v-bind:value="race.name"
          >
            {{ race.name }}
          </option>
        </select>

        <!-- v-model="newCharacter.race" -->
      </div>

      <div class="race-class-group" id="class">
        <label for="charClass">Class</label>
        <select
          id="class-selection"
          class="form-control"
          v-model="newCharacter.charClass"
          v-on:change="changeDescription"
        >
          <option
            v-for="charClass in dropdownClass"
            v-bind:key="charClass.id"
            v-bind:value="charClass.name"
          >
            {{ charClass.name }}
          </option>
        </select>
      </div>
      <!-- </div> -->

      <!-- <div class="stats-picture"> -->
      <div class="stats-column" id="lcol">
        <div class="stats-box">
          <div class="stats-name">STRENGTH</div>
          <div class="stats-value" id="str-value">?</div>
        </div>
        <div class="stats-box">
          <div class="stats-name">DEXTERITY</div>
          <div class="stats-value" id="dex-value">?</div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CONSTITUTION</div>
          <div class="stats-value" id="con-value">?</div>
        </div>
      </div>

      <div id="picture">
        <img
          src="https://cdna.artstation.com/p/assets/images/images/010/077/400/large/maja-weber-sun-wukong-colour.jpg?1522433552"
          class="char-pic"
          id="char-pic"
        />
      </div>

      <div class="stats-column" id="rcol">
        <div class="stats-box">
          <div class="stats-name">INTELLIGENCE</div>
          <div class="stats-value" id="int-value">?</div>
        </div>
        <div class="stats-box">
          <div class="stats-name">WISDOM</div>
          <div class="stats-value" id="wis-value">?</div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CHARISMA</div>
          <div class="stats-value" id="cha-value">?</div>
        </div>
      </div>
      <!-- </div> -->

      <div id="desc">
        <label for="description">Description</label>
        <input
          id="description"
          type="textarea"
          class="form-control"
          v-model="newCharacter.description"
        />
      </div>
      <div class="buttons" id="buttons">
        <button class="btn btn-submit">Submit</button>
        <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm">
          Cancel
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import CharacterService from "../services/CharacterService.js";
import DnDApiService from "../services/DndApiService.js";
import MonsterService from "../services/MonsterService.js";

export default {
  name: "character-creation-form",
  data() {
    return {
      newCharacter: {
        id: -1,
        name: "",
        charClass: "",
        race: "",
        description: "",

        strength: 3,
        dexterity: 3,
        constitution: 3,
        intelligence: 3,
        wisdom: 3,
        charisma: 3,

        monsterId: 1,
        userId: 1,
      },
      dropdownRace: [
        {
          name: "Dwarf",
        },
        {
          name: "Elf",
        },
        {
          name: "Halfling",
        },
      ],
      dropdownClass: [
        {
          name: "Barbarian",
        },
        {
          name: "Bard",
        },
      ],
    };
  },

  created() {
    DnDApiService.getAllRaces().then(response => {
      this.dropdownRace = response.data.results
    });
    DnDApiService.getAllClasses().then(response => {
      this.dropdownClass = response.data.results
    });
    this.setMonsterId();
  },
  methods: {
    setMonsterId() {
      MonsterService.getMonsterByDate(new Date().toJSON().slice(0, 10))
      .then(response => {
        this.newCharacter.monsterId = response.data.id;
      });
    },
    resetCharacter() {
      this.newCharacter = {
        name: "",
        race: "",
        class: "",
        description: "",
        stats: {
          str: 1,
          dex: 1,
          con: 1,
          int: 1,
          wis: 1,
          cha: 1,
        },
        monsterId: 1,
        userId: 1,
      };
      this.setMonsterId();
    },
    submitForm() {

      CharacterService.addNewCharacter(this.newCharacter)
        .then((response) => {
          if (response.status === 201) {
            /* TODO ******** set this to go to the party screen probably */
            this.$router.push({name: 'party' });
          }
        })
        .catch((error) => {
          // TODO ********* check this
          // this.handleErrorResponse(error);
          console.log(error);
        });
    },
    cancelForm() {
      this.$router.push({name: "character-creator"});
    },
  },
};
</script>

<style scoped>


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

/* .name-group {
  margin: 10px 0;
  text-align: center;
  color: #38b412;
  font-size: 2rem;
  
} */

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
  /* margin: 10px 0; */
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

#race-selection {
  width: 150px;
  margin: 5px auto;
  height: 40px;

  /* this is the dropdown area for race */
}

#picture {
  grid-area: picture;
}

#char-pic {
  background-color: aliceblue;
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

#class-selection {
  width: 150px;
  margin: 3px auto;
  height: 40px;
  /* this is the drop down for class */
}

#lcol {
  grid-area: lcol;
}

#rcol {
  grid-area: rcol;
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
  background-color: bisque;
  border-radius: 3px;
  padding: 0.1em;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  /* width: 90%; */
}

.stats-box {
  text-align: center;
  /*TODO ******** check this one again */
  /* margin: 0.5em; */
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
.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
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
  /* #race {
  font: ;
} */
}
</style>