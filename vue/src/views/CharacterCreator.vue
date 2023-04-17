<template>
  <div class="char-view">
    <character-creation-form />

    <div>
        <!-- <div class="ban-message" v-show="errorMessage != ''">
            {{errorMessage}}
        </div> -->
    </div>
  </div>
</template>

<script>
import CharacterCreationForm from "../components/CharacterCreationForm.vue";

export default {
  name: "character-creator",

  data() {
      return {
          showError: false,
      }
  },

  components: {
    CharacterCreationForm,
  },

  methods: {
    //   showBanMessage() {
    //       if(this.$store.state.user.role === "ROLE_BAN"){
    //           this.showError = !this.showError
    //       }
    //   },
  }

};
</script>

<style scoped>
.char-view {
  background-color: #3a5268;
}
</style>
