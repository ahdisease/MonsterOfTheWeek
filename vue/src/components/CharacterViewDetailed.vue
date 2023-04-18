<template>
  <div id="addHomeform">
    <div id="title">
      <h1>This Week's Character</h1>
    </div>
    <form class="homeForm">
      <div class="name-group" id="name-box">
        <label id="name-text" for="name"><strong>Name: </strong></label>
         <div class="character-details">
              {{character.name}} 
         </div>
      </div>

      <div class="race-class-group" id="race">
        <label id="race-text" for="race"><strong>Race: </strong></label>
         <div class="character-details">
              {{character.race}} 
         </div>
      </div>

      <div class="race-class-group" id="class">
        <label id="class-text" for="charClass"><strong>Class: </strong></label>
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
        <label id="description" for="description"><strong>Description:</strong></label>
        <p class="description-box">
             {{character.description}} 
        </p>
      </div>
      <!-- <div class="buttons" id="buttons">
        <button class="btn btn-submit">Update</button>
        <button class="btn btn-cancel" type="cancel">
          Delete
        </button>
      </div> -->
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
  display: grid;
  grid-template-areas: "title"
                        "homeForm";
  grid-template-columns: 2fr;
  justify-content: center;
  align-items: center;
  
  background: #3a5268;
  margin: auto;
  padding-top: 10px;
  width: 90%;
  height: 100%;
  background-color: #607f9b;
  padding-bottom: 37px;
  
}

#title {
  grid-area: title;
}

#title h1 {
  text-align: center;
  font-size: 4em;
  color: #00E88A;
  background: #00201E
  

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
  color: goldenrod;
  font-size: 2rem;
}

#name-text {
  color: white;
}

#race-class {
  text-align: center;
}

#race {
  grid-area: race;
  display: flex;
  flex-direction: column;
  align-items: center;
  color: goldenrod;
  font-size: 2rem;
}

#race-text {
  color: white;
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
  border: 4px solid goldenrod;
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
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
  color: goldenrod;
  font-size: 2rem;
}

#class-text {
  color: white;
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
  
}

#rcol {
  grid-area: rcol;
  justify-content: stretch;
  align-content: center;
  
}

#desc {
  grid-area: desc;
  margin: 10px 0;
  text-align: center;
  justify-content: center;
  align-self: center;
  color: goldenrod;
  font-size: 2rem;
}

#description {
  color: white;
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
  background-color: #00201E;
  border-radius: 3px;
  padding: 0.1em;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  color: #00E88A;

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
  color: goldenrod;
  background-color: rgb(252, 247, 240);
  width: 50%;
  margin: 0 auto;
  border-radius: 6px;
}

#int-value {
  border-color: 4px solid goldenrod;
  box-shadow: 4px 4px 8px rgba(0, 0, 0, 0.4);
}

button {
  border-radius: 6px;
  margin: 0 10px 0 0;
}

.btn-submit {
  color: #fff;
  padding: 10px 24px;
  background-color: #00E88A;
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
  background-color: #00E88A;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-cancel:hover {
  padding: 10px 24px;
  background-color: #00E88A;
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