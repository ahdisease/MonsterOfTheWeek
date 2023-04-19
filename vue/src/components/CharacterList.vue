<template>
  <div id="whole-page">
    <div class="party-container">
      <div class="current-party">
        <div id="party-name">
          <h1>Your Party</h1>
        </div>
        <div id="party-cards"
          v-bind:key="character.id3"
          v-for="character in party"
          @dblclick.prevent="removePartyMember(character)"
          style="
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
          "
        >
          <character-card v-bind:character="character"></character-card>
        </div>
      </div>
    </div>

    <div id="submit-cancel-update">
      <div class="update-button-container" v-if="checkUserParty">
        <div class="buttons">
          <button class="btn btn-update" v-on:click.prevent="updateParty">
            Update
          </button>
        </div>
      </div>

      <div class="button-container" v-if="!checkUserParty">
        <div class="buttons">
          <button
            class="btn btn-submit"
            
            v-on:click.prevent="submitForm"
          >
            Submit
          </button>
          <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm">
            Cancel
          </button>
        </div>
      </div>
    </div>
    <!--  This is the on successful submit modal -->
    <div>
      <b-modal v-model="modalShow" hide-footer>
        <div class="d-block text-center">
          <h3>Your party has been created!</h3>
        </div>
      </b-modal>
    </div>
    <!-- This is the on successful update modal -->
    <div>
      <b-modal v-model="modalUpdate" hide-footer>
        <div class="d-block text-center">
          <h3>Your party has been updated!</h3>
        </div>
      </b-modal>
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

      <div id="clear-filters" v-on:click="clearFilters">
        <b-button id="reset-button">Reset Filters</b-button>
      </div>

      <div class="att-group" id="charClass">
        <label class="label" for="charClass">Class</label>
        <select
          id="charClass-selection"
          class="form-control"
          v-model="filter.charClass"
        >
          <option value>Any</option>
          <option value="Barbarian">Barbarian</option>
          <option value="Bard">Bard</option>
          <option value="Cleric">Cleric</option>
          <option value="Druid">Druid</option>
          <option value="Fighter">Fighter</option>
          <option value="Monk">Monk</option>
          <option value="Paladin">Paladin</option>
          <option value="Ranger">Ranger</option>
          <option value="Rogue">Rogue</option>
          <option value="Sorceror">Sorceror</option>
          <option value="Warlock">Warlock</option>
          <option value="Wizard">Wizard</option>
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

      <div class="att-group" id="content" v-if="confirmModeratorPermissions">
        <label class="label" for="flaggedInappropriate">Content</label>
        <select
          id="content-selection"
          class="form-control"
          v-model="filter.flaggedInappropriate"
        >
          <option value>Any</option>
          <option value="flagged">Flagged Content</option>
          <option value="not_flagged">Unflagged Content</option>
          <option value="reviewed">Reviewed Content</option>
        </select>
      </div>
    </div>
    <div id="instruction">
      <h2>Available Characters</h2>
      <p>Click to see other side of card. Double-Click to add to party.</p>
    </div>

    <div class="character-list">
      <div
        v-for="character in filteredList"
        v-bind:key="character.id4"
        @dblclick.prevent="addPartyMember(character)"
        style="
          -webkit-user-select: none;
          -moz-user-select: none;
          -ms-user-select: none;
          user-select: none;
        "
      >
        <character-card
          v-bind:isFlaggable="true"
          v-bind:character="character"
          @newFlag="generateCharacterList"
          v-if="character.active"
        >
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
      showPartyComp: false,
      currentCharacters: [],
      newPartyMember: {},
      party: [],
      currentParty: [],
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
        flaggedInappropriate: "",
      },
      filterParty: {
        characterOne: "",
        characterTwo: "",
        characterThree: "",
        characterFour: "",
      },
      modalUpdate: false,
      modalShow: false,
    };
  },

  created() {
    // This is the working method
    this.generateCharacterList();
    //  console.log(this.currentCharacters)

    CharacterService.getPartyByUsername(this.$store.state.user.username).then(
      (response) => {
        if (response.data) {
          const partyObject = response.data;
          CharacterService.getCharacterById(partyObject.characterOne).then(
            (response) => {
              this.party.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterTwo).then(
            (response) => {
              this.party.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterThree).then(
            (response) => {
              this.party.push(response.data);
            }
          );
          CharacterService.getCharacterById(partyObject.characterFour).then(
            (response) => {
              this.party.push(response.data);
              console.log(this.party)
            }
          );
        }
      }
    );
    // this.checkUserParty();
    // console.log(this.created)
  },

  methods: {
    updateParty() {
      let submitParty = this.party.map((character) => {
        return character.id;
      });
      let submitPartyObject = {
        characterOne: submitParty[0],
        characterTwo: submitParty[1],
        characterThree: submitParty[2],
        characterFour: submitParty[3],
      };
      // if(this.checkUserParty){

      // }
      // else {
      CharacterService.updateParty(submitPartyObject)
        .then((response) => {
          if (response.status === 200) {
            this.modalUpdate = true;
            this.showPartyComp = true;
            this.$store.commit("SET_USER_PARTY", this.party);
            // this.$router.push({ name: "home" });
          }
        })
        // TODO ********* THIS ERROR needs work
        .catch((error) => {
          this.handleErrorResponse(error);
        });
      // }
      //  this.$store.state.userParty = {};
    },
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
      // if(this.checkUserParty){

      // }
      // else {
      CharacterService.addNewParty(submitPartyObject)
        .then((response) => {
          if (response.status === 201) {
            this.modalShow = true;
            this.showPartyComp = true;
            this.$store.commit("SET_USER_PARTY", this.party);
            // this.$router.push({ name: "home" });
          }
        })
        // TODO ********* THIS ERROR needs work
        .catch((error) => {
          this.handleErrorResponse(error);
        });
      // }
    },
    cancelForm() {
      this.party = [];
    },
    addPartyMember(character) {
      if (this.party.length < 4) {
        let partyDoesNotContain = true;
        this.party.forEach(partyMember => {
          
          if(partyMember.id == character.id){
            partyDoesNotContain = false;

           

          }
        }); if (partyDoesNotContain == true) {
           this.party.push(character);

        }
      } 
    },
    removePartyMember(character) {
      let indexNumber = this.party.indexOf(character);
      this.party.splice(indexNumber, 1);
      // indexOf() to find index of character in party; remove element of party at that index;
    },
    generateCharacterList() {
      CharacterService.getAllCharacters(new Date().toJSON().slice(0, 10)).then(
        (response) => {
          this.currentCharacters = response.data;
        }
      );
    },
    clearFilters() {
      (this.filter.race = ""),
        (this.filter.charClass = ""),
        (this.filter.strength = ""),
        (this.filter.dexterity = ""),
        (this.filter.constitution = ""),
        (this.filter.intelligence = ""),
        (this.filter.wisdom = ""),
        (this.filter.charisma = "");
    },

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
    // filterPartyObject(){
    //   let filteredPartyList = this.checkUserParty
    //   if (this.filterParty.characterOne != '') {
    //     filteredPartyList = filteredPartyList.filterParty(
    //       character => character.characterOne === this.filterParty.characterOne
    //     );
    //   }
    //
    //   return filteredPartyList;
    // },
    checkUserParty() {
       
      // This is the old method that doesn't really work *******
      let created = Object.keys(this.$store.state.userParty).length != 0;
      console.log(this.$store.state.userParty);
      console.log(created);
      return created;
    },

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
      if (this.filter.flaggedInappropriate != "") {
        filteredCharacters = filteredCharacters.filter(
          (character) =>
            character.flaggedInappropriate === this.filter.flaggedInappropriate
        );
      }

      return filteredCharacters;
    },
    confirmModeratorPermissions() {
      let allowed = false;

      this.$store.state.user.authorities.forEach((authority) => {
        if (authority.name === "ROLE_MOD") {
          allowed = true;
        }
      });

      return allowed;
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

#whole-page {
  display: flex;
  flex-direction: column;
}

.character-list {
  display:flex;
  justify-content: center;
  align-content: space-between;
  flex-wrap: wrap;
}

#party-name {
  text-align: center;
  margin: 0 auto;
  width: 100%;
}

h1 {
  color: #00e88a;
  font-size: 3em;
}

#party-comp {
  width: 100%;
}

.party-container {
  display: flex; 
  flex-wrap: wrap;
  flex-direction: column;
  min-height: 310px;
  background-color: #00201e;
  border: 5px outset goldenrod;
  border-radius: 6px;
  width: 80%;
  margin: 0 auto;
  position: sticky;
  top: 100px;
  z-index: 2;
}

.current-party {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin: auto;
}
#party-cards {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}

.race-class-group {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin: 30px auto 0 auto;
  gap: 7rem;
}
.label {
  font-weight: 700;
  color: #00e88a;
}

.form-control {
  text-align: center;
  background-color: rgb(169, 252, 169);
  color: black;
  width: 120px;
}
.form-control option {
  text-align: left;
}

.att-group {
  text-align: center;
  /* margin: 0 auto; */
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

#clear-filters {
  height: auto;
}

#reset-button {
  color: #00e88a;
  background-color: #00201e;
  border: none;
}
#reset-button:hover {
  color: #00201e;
  background-color: #00e88a;
}

#submit-cancel-update {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.btn-submit {
  background-color: lightgreen;
}

.btn-submit:hover {
  background-color: lightgreen;
  border: 1px solid black;
}

.btn-cancel {
  background-color: lightseagreen;
}

.btn-cancel:hover {
  background-color: lightseagreen;
  border: 1px solid black;
}

.btn-update {
  background-color: lightgreen;
}

.btn-update:hover {
  background-color: lightgreen;
  border: 1px solid black;
}

#instruction {
  margin: 0 auto;
  width: 90%;
  text-align: center;
  color: #00e88a;
  background-color: #00201e;
  border: 5px outset goldenrod;
  border-radius: 6px;
  margin-bottom: 20px;

}

@media screen and (max-width: 1000px) {
  .party-container{
    width: 100%;
  }
  #raceClassDropdown {
    padding: 15px;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
  }
  .race-class-group {
    width: 80%;
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