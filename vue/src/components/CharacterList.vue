<template>
  <div>
    <h3>This is the Character List, Character Lovers!!!</h3>
    
      <div class="newPartyMember card" v-bind:key="character.id3" v-for="character in party">
        <character-card v-bind:character="character"></character-card>

      </div>
      <div class="buttons" id="buttons" >
            <button class="btn btn-submit" v-on:click="submitForm">Submit</button>
            <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm">
              Cancel
            </button>
          </div>
    <p>the character cards will show up here:</p>
    <div class="card" v-for="character in currentCharacters" v-bind:key="character.id4" @click="addPartyMember(character)">
      <character-card v-bind:character="character"></character-card>
    </div>
    

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
      currentCharacters: {},
      newPartyMember: {},
      party: [],
      checked: true,
      


      // showModal: false,
    };
  },

  created() {
    CharacterService.getAllCharacters("2020-01-01").then((response) => {
      this.currentCharacters = response.data;
    });
  },

  methods: {
    submitForm() {    
      let submitParty = this.party.map((character) => {
        
          return character.id;
        

      })
      let submitPartyObject = {
        characterOne: submitParty[0],
        characterTwo: submitParty[1],
        characterThree: submitParty[2],
        characterFour: submitParty[3]
        }



      CharacterService.addNewParty(submitPartyObject)
        .then((response) => {

          
          
          if (response.status === 201) {
            this.$router.push({name: 'home'});
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
      
    }
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




    // filteredCharacters() {
    //   let newPartyMember = this.currentCharacters;
    //   if(this.newPartyMember.)
    // }



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
.row {
  width: 50%;
  margin: auto;
  display: flex;
}
.inner-row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.column1 {
  flex: 45%;
  background-color: bisque;
  /* height: 90vh; */
}
.column2 {
  flex: 45%;
  background-color: rgb(238, 194, 141);
  /* height: 90vh; */
}
.card {
  /* Add shadows to create the "card" effect */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  height: 300px;
  width: 17%;
  margin: 1%;
  display: inline-block;
}
.card img {
  width: 35%;
  height: auto;
}
/* On mouse-over, add a deeper shadow */
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
/* Add some padding inside the card container */
.container {
  padding: 2px 10px;
  margin: 5%;
}
.button {
  margin: 10px;
  border-radius: 3px;
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.unselectable {
  background-color: gray;
}
</style>