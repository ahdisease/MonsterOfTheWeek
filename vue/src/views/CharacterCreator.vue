<template>
  
    <div class="char-view" v-bind="showBanMessage">
        <div role="alert" v-if="showError">
            {{errorMessage}}
        </div>>
    
    <character-creation-form />

    
  </div>
</template>

<script>
import CharacterCreationForm from "../components/CharacterCreationForm.vue";

export default {
  name: "character-creator",

  data() {
      return {
          showError: false,
          errorMessage: 'Sorry, You have been banned.',
      }
  },

  components: {
    CharacterCreationForm,
  },

  methods: {
          
    showBanMessage() {
          if(this.$store.state.user.role === "ROLE_BAN"){
              this.showError = true;
              this.errorMessage;
          }
      },
  }

};
</script>

<style scoped>
.char-view {
  background-color: #3a5268;
}
</style>
