<template>
  <div>
    <div class="party-container">
      <div class="current-party">
      <div
      v-bind:key="character.id3"
      v-for="character in party"
      @dblclick.prevent="removePartyMember(character)"
        style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;"
      >
      <character-card v-bind:character="character"></character-card>
      </div>
    </div>
    </div>
    
    <div class="button-container">
      <div class="buttons">
      <button class="btn btn-submit" v-on:click="submitForm">Submit</button>
      <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm">
        Cancel
      </button>
      </div>
    </div>
    

    <!-- These are the filtered buttons -->
    <div class="race-class-group">
        <div class="att-group" id="race">
          <label class="label" for="race">Race</label>
          <select id="race-selection" class="form-control" v-model="filter.race">
            <option value>Any</option>
            <option value="Dragonborn">Dragonborn</option>
            <option value="Dwarf">Dwarf</option>
            <option value="Elf">Elf</option>
            <option value="Gnome">Gnome</option>
            <option value="Half-Elf">Half-Elf</option>
            <option value="Half-Orc">Half-Orc</option>
            <option value="Halfling">Halfling</option>
            <option value="Human">Human</option>
            <option value="Tiefling">Tiefling</option>
          </select>
        </div>
    
      <div class="att-group" id="charClass">
        <label class="label" for="charClass">Class</label>
        <select
          id="charClass-selection"
          class="form-control"
          v-model="filter.charClass">
          <option value>Any</option>
          <option value='Barbarian'>Barbarian</option>
          <option value='Bard'>Bard</option>
          <option value='Cleric'>Cleric</option>
          <option value='Druid'>Druid</option>
          <option value='Fighter'>Fighter</option>
          <option value='Monk'>Monk</option>
          <option value='Paladin'>Paladin</option>
          <option value='Ranger'>Ranger</option>
          <option value='Rogue'>Rogue</option>
          <option value='Sorceror'>Sorceror</option>
          <option value='Warlock'>Warlock</option>
          <option value='Wizard'>Wizard</option>
        </select>
      </div>
    </div>

    <div id="attGroupWrapper">
      <div class="att-group" id="strength">
        <label class="label" for="strength">Strength</label>
        <select
          id="strength-selection"
          class="form-control"
          v-model="filter.strength"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>

      <div class="att-group" id="dexterity">
        <label class="label" for="dexterity">Dexterity</label>
        <select
          id="dexterity-selection"
          class="form-control"
          v-model="filter.dexterity"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>

      <div class="att-group" id="constitution">
        <label class="label" for="constitution">Constitution</label>
        <select
          id="constitution-selection"
          class="form-control"
          v-model="filter.constitution"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>

      <div class="att-group" id="intelligence">
        <label class="label" for="intelligence">Intelligence</label>
        <select
          id="intelligence-selection"
          class="form-control"
          v-model="filter.intelligence"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>

      <div class="att-group" id="wisdom">
        <label class="label" for="wisdom">Wisdom</label>
        <select
          id="wisdom-selection"
          class="form-control"
          v-model="filter.wisdom"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>

      <div class="att-group" id="charisma">
        <label class="label" for="charisma">Charisma</label>
        <select
          id="charisma-selection"
          class="form-control"
          v-model="filter.charisma"
        >
          <option value>Any</option>
          <option value="12">12 or higher</option>
          <option value="13">13 or higher</option>
          <option value="14">14 or higher</option>
          <option value="15">15 or higher</option>
          <option value="16">16 or higher</option>
          <option value="17">17 or higher</option>
          <option value="18">18 or higher</option>
          <option value="19">19 or higher</option>
          <option value="20">20 or higher</option>
        </select>
      </div>
    </div>

    <div class="character-list">
      <div v-for="character in filteredList"
        v-bind:key="character.id4"
        @dblclick.prevent="addPartyMember(character)"
        style="-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;"
        >
        <character-card v-bind:character="character">
          {{ character.race }}
          {{ character.charClass }}
          {{ character.strength }}
          {{ character.dexterity }}
          {{ character.constitution }}
          {{ character.intelligence }}
          {{ character.wisdom }}
          {{ character.charisma }}
        </character-card>
      </div>
    </div>
    
    <!-- This is the Drag and Drop  -->

    <!-- <div class="center-panel"> -->
    <!-- <h1>Drag and Drop example</h1>
      <div class="row">
        <div
          class="column1"
          @drop="onDrop($event, 1)"
          @dragover.prevent
          @dragenter.prevent
        >
          <div class="inner-row">
            <div
              class="card"
              v-for="item in listOne"
              :key="item.id"
              draggable
              @dragstart="startDrag($event, item)"
            >
              <img v-bind:src="item.avatar" />
              <div class="container">
                <h4>
                  <b>{{ item.name }}</b>
                </h4>
                <p>{{ item.occupation }}</p>
              </div>
            </div>
          </div>
        </div>
        <div
          class="column2"
          @drop="onDrop($event, 2)"
          @dragover.prevent
          @dragenter.prevent
        >
          <div class="inner-row">
            <div
              class="card"
              v-for="item in listTwo"
              :key="item.id"
              draggable
              @dragstart="startDrag($event, item)"
            >
              <div class="container">
                <h4>
                  <b>{{ item.name }}</b>
                </h4>
                <p>{{ item.occupation }}</p>
              </div>
            </div>
          </div>
        </div>
      </div> -->
    <!-- </div> -->
  </div>
</template>

<script>
import CharacterCard from "./CharacterCard.vue";
import CharacterService from "../services/CharacterService.js";
import DnDApiService from "../services/DndApiService.js";

export default {
  name: "character-list",

  components: {
    CharacterCard,
  },

  data() {
    return {
      charClass: "",
      race: "",
      newCharacter: {
        race: "",
        class: "",
      },

      currentCharacters: [],
      newPartyMember: {},
      party: [],

      checked: true,
      filter: {
        race: "",
        charClass: "",
        strength: "",
        dexterity: "",
        constitution: "",
        intelligence: "",
        wisdom: "",
        charisma: "",
      },

      // showModal: false,
    };
  },

  created() {
    // This is the working method
    CharacterService.getAllCharacters(new Date().toJSON().slice(0, 10)).then(
      (response) => {
        this.currentCharacters = response.data;
        //  console.log(this.currentCharacters)
      }
    );

    // this was the method being tested ***************
    //  CharacterService.getAllCharacters(new Date().toJSON().slice(0, 10)).then((response) => {
    //   this.retrievedCharacters = response.data;
    // });

    DnDApiService.getAllRaces().then((response) => {
      this.dropdownRace = response.data.results;
    });
    DnDApiService.getAllClasses().then((response) => {
      this.dropdownClass = response.data.results;
    });
  },

  methods: {
    submitForm() {
      let submitParty = this.party.map((character) => {
        return character.id;
      });
      let submitPartyObject = {
        characterOne: submitParty[0],
        characterTwo: submitParty[1],
        characterThree: submitParty[2],
        characterFour: submitParty[3],
      };

    CharacterService.addNewParty(submitPartyObject)
      .then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "home" });
        }
      })
        // TODO ********* THIS ERROR needs work
        .catch((error) => {
          this.handleErrorResponse(error);
        });
    },
    cancelForm() {
      this.party = [];
    },
    addPartyMember(character) {
      if (this.party.length < 4 && !this.party.includes(character)) {
        this.party.push(character);
      }
    },
    removePartyMember(character) {
      this.party.pop(character);
    }

    //  This is the Drag and Drop methods
    // startDrag(evt, item) {
    //   console.log("inside start drag" + item.name);
    //   evt.dataTransfer.dropEffect = "move";
    //   evt.dataTransfer.effectAllowed = "move";
    //   evt.dataTransfer.setData("itemID", item.id);
    // },
    // onDrop(evt, list) {
    //   console.log("inside on drop" + list);
    //   const itemID = evt.dataTransfer.getData("itemID");
    //   const item = this.items.find((item) => item.id == itemID);
    //   item.list = list;
    // },
  },

  computed: {
    filteredList() {
      let filteredCharacters = this.currentCharacters;
      // console.log(filteredCharacters)
      if (this.filter.race != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.race === this.filter.race
        );
      }
      if (this.filter.charClass != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.charClass === this.filter.charClass
        );
      }
      if (this.filter.strength != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.strength >= this.filter.strength
        );
      }
      if (this.filter.constitution != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.dexterity >= this.filter.dexterity
        );
      }
      if (this.filter.constitution != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.constitution >= this.filter.constitution
        );
      }
      if (this.filter.intelligence != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.intelligence >= this.filter.intelligence
        );
      }
      if (this.filter.wisdom != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.wisdom >= this.filter.wisdom
        );
      }
      if (this.filter.charisma != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) => character.charisma >= this.filter.charisma
        );
      }

      return filteredCharacters;
    },

    // filteredCharacters() {
    //   let filteredCharacters = this.currentCharacters;
    //   if(this.newPartyMember.)
    // }

    // This is the Drag and Drop Computed
    // listOne() {
    //   console.log("inside listOne");
    //   return this.items.filter((item) => item.list === 1);
    // },
    // listTwo() {
    //   console.log("inside listOne");
    //   return this.items.filter((item) => item.list === 2);
    // },
  },
};
</script>

<style scoped>

.party-container {
  display: flex;
  flex-wrap: wrap;
  min-height: 300px;
}

.current-party {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin: auto;
}

.character-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.race-class-group {
  display: flex;
  justify-content: space-around;
  margin: 2rem auto;
  gap: 7rem;
}

.label {
  font-weight: 700;
}

.form-control {
  width: 7rem;
  text-align: center;
}

.att-group {
  text-align: center;
}

#attGroupWrapper {
  padding: 15px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

.button-container {
  display: flex;
  justify-content: center;
}

.buttons {
  border-radius: 3px;
  border: none;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: flex;
  gap: 20px;
  font-size: 16px;
}

.btn-submit {
  background-color: lightgreen;
}

.btn-submit:hover {
  background-color: lightgreen;
  border: 1px solid black;
}

.btn-cancel {
  background-color: lightpink;
}

.btn-cancel:hover {
  background-color: lightpink;
  border: 1px solid black;
}

.unselectable {
  background-color: gray;
}

@media screen and (max-width: 1000px) {
  #raceClassDropdown {
    padding: 15px;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
  }
  .race-class-group {
    width: 30%;
  }
  #attGroupWrapper {
    /* margin: 15px; */
    padding: 15px;
    display: flex;
    /* flex-direction: row; */
    flex-wrap: wrap;
    justify-content: center;
    align-content: space-between;
  }
  .att-group {
    margin: 5px;
  }
}
</style>