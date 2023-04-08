<template>
  <div id="addHomeform">
    <!-- <p class="status-message error" v-show="errorMessage != ''">{{errorMessage}}</p> -->
    <form class="homeForm" v-on:submit.prevent="submitForm">
      <div class="form-group">
        <label for="name">Name:</label>
        <input
          id="name"
          type="text"
          class="form-control"
          v-model="newCharacter.name"
        />
      </div>
      <div class="form-group">
        <label for="charClass">Class</label>
        <input
          id="charClass"
          type="text"
          class="form-control"
          v-model="newCharacter.charClass"
        />
      </div>
      <div class="form-group">
        <label for="race">City:</label>
        <input
          id="race"
          type="text"
          class="form-control"
          v-model="newCharacter.race"
        />
      </div>
      <div class="form-group">
        <label for="description">State:</label>
        <input
          id="description"
          type="text"
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
    name: 'character-creation-form',
    data() {
        return {
            newCharacter: {
                name: '',
                charClass: '',
                race: '',
                description: '',
                stats: {
                    str: 1,
                    dex: 1,
                    con: 1,
                    int: 1,
                    wis: 1,
                    cha: 1
                }
            }
        }
    },
    methods: {
        resetCharacter() {
            this.newCharacter =
            {
                name: '',
                race: '',
                class: '',
                description: '',
                stats: {
                    str: 1,
                    dex: 1,
                    con: 1,
                    int: 1,
                    wis: 1,
                    cha: 1
                }
            }
        },
        submitForm() {

        }
    }
};
</script>

<style scoped>
    #addHomeform {
  margin-left: auto;
  margin-right: auto;
  width: 500px;
}
form input {
  width: 100%;
}
.homeForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
.form-control {
  display: flex;
  align-items: flex-start;
  width: 100%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #CED4DA;
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
}
.btn-submit {
  color: #fff;
  padding: 10px 24px;
  background-color: #38B412;
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
  background-color: #65F307;
  box-shadow: 0 12px 26px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
}
.btn-cancel:hover {
  padding: 10px 24px;
  background-color: #65F307;
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
  background-color: #90EE90;
}
.status-message.error {
  background-color: #F08080;
}
</style>