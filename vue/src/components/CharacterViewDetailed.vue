<template>
  <div id="addHomeform">
    <div id="title">
      <h1>This Week's Character</h1>
    </div>
    <form class="homeForm">
      <div class="name-group" id="name-box">
        <label for="name">Name</label>
         <div class="character-details">
              {{character.name}} 
         </div>
      </div>

      <div class="race-class-group" id="race">
        <label for="race">Race</label>
         <div class="character-details">
              {{character.race}} 
         </div>
      </div>

      <div class="race-class-group" id="class">
        <label for="charClass">Class</label>
         <div class="character-details">
              {{character.charClass}} 
         </div>
      </div>

      <div class="stats-column" id="lcol">
        <div class="stats-box">
          <div class="stats-name">STRENGTH</div>
          <div class="stats-value" id="str-value"> {{character.strength}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">DEXTERITY</div>
          <div class="stats-value" id="dex-value"> {{character.dexterity}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CONSTITUTION</div>
          <div class="stats-value" id="con-value"> {{character.constitution}} </div>
        </div>
      </div>

      <div id="picture">
        <img
          
          v-bind:src="imageUrl"
          class="char-pic"
          id="char-pic"
        />
      </div>

      <div class="stats-column" id="rcol">
        <div class="stats-box">
          <div class="stats-name">INTELLIGENCE</div>
          <div class="stats-value" id="int-value"> {{character.intelligence}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">WISDOM</div>
          <div class="stats-value" id="wis-value"> {{character.wisdom}} </div>
        </div>
        <div class="stats-box">
          <div class="stats-name">CHARISMA</div>
          <div class="stats-value" id="cha-value"> {{character.charisma}} </div>
        </div>
      </div>

      <div id="desc">
        <label for="description">Description</label>
        <p class="description-box">
             {{character.description}} 
        </p>
      </div>
      <div class="buttons" id="buttons">
        <button class="btn btn-submit">Update</button>
        <button class="btn btn-cancel" type="cancel">
          Delete
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import CharacterService from "../services/CharacterService.js";

export default {
    
name: "character-view-detailed",
  data() {
    return {
      character: {},

    };
  },

  created() {
    this.setCharacter();
  },
  methods: {
    setCharacter() {
      CharacterService.getCharacterByUsername(this.$store.state.user.username)
        .then(response => {
            this.character = response.data[0];
        });
    },
  },
  computed: {
    imageUrl() {
      if(this.character.image) {
        return this.character.image.url
      }
      return '';
    }
  }
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


.stats-column {
  background-color: bisque;
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