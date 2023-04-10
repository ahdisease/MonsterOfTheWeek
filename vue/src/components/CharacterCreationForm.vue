<template>
  <div id="addHomeform">
    <h1>Character Creator</h1>
    <!-- <p class="status-message error" v-show="errorMessage != ''">{{errorMessage}}</p> -->
    <form class="homeForm" v-on:submit.prevent="submitForm">
      <div class="form-group">
        <label for="name" >Name</label>
        <input
          id="name"
          type="text"
          class="form-control"
          v-model="newCharacter.name"
        />
      </div>
      <div id="race-class">
      <div class="form-group">
        <label for="race" >Race</label>
        <input
          id="race"
          type="text"
          class="form-control"
          v-model="newCharacter.race"
        />
      </div>
      
      <div class="form-group">
        <label for="charClass"  >Class</label>
        <input
          id="charClass"
          type="text"
          class="form-control"
          v-model="newCharacter.charClass"
        />
      </div>
      </div>

      <div id="stats-picture">
        <div id="stats-left">
          <div id="str"><p>STRENGTH</p>5</div>
          <div id="dex"><p>DEXTERITY</p>5</div>
          <div id="con"><p>CONSTITUTION</p>5</div>

        </div>

        <div id="char-pic">
         PICTURE PLACEHOLDER
        </div>

        <div id="stats-right">
          <div id="int"><p>INTELLIGENCE</p>5</div>
          <div id="wis"><p>WISDOM</p>5</div>
          <div id="cha"><p>CHARISMA</p>5</div>
        </div>
      </div>

      <div class="form-group">
        <label for="description">Description:</label>
        <input
          id="description"
          type="textarea"
          class="form-control"
          v-model="newCharacter.description"
        />
      </div>

      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="cancel" v-on:click="cancelForm">
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "character-creation-form",
  data() {
    return {
      newCharacter: {
        name: "",
        charClass: "",
        race: "",
        description: "",
        stats: {
          str: 1,
          dex: 1,
          con: 1,
          int: 1,
          wis: 1,
          cha: 1,
        },
      },
    };
  },
  methods: {
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
      };
    },
    submitForm() {},
    cancelForm() {},
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
}
#name {
  width: 50%;
  text-align: center;
  margin: 0 auto;
  
}

#race-class {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  text-align: center;
}

#addHomeform {
  margin-left: auto;
  margin-right: auto;
  width: 80%;
  background-color: lightgray;
  
}
form input {
  width: 100%;
}
.homeForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin: 10px 0;
  text-align: center;
  color: #38b412;

}
.form-control {
  display: flex;
  align-items: flex-start;
  /* justify-self: center; */
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
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
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
#stats-picture {
  display:flex;
  flex-direction: row;
  justify-content: space-between;

}



</style>