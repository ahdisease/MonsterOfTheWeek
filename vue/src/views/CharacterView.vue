<template>
  <div class="completed-char">
    <div id="ban-message" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>
    <div v-if="!showError">
      
      <character-creator v-if="!characterCreated" />
      <character-view-detailed v-if="characterCreated" />
    </div>
  </div>
</template>

<script>
import CharacterViewDetailed from "../components/CharacterViewDetailed.vue";
import CharacterCreator from "./CharacterCreator.vue";

export default {
  name: "character-view",

  data() {
    return {
      showError: false,
      errorMessage: "Sorry, You have been banned.",
    };
  },

  components: {
    CharacterViewDetailed,
    CharacterCreator,
  },
  computed: {
    characterCreated() {
      let created = Object.keys(this.$store.state.userCharacter).length !== 0;
      if (created) {
        created = this.$store.state.userCharacter.name !== "";
      }

      return created;
    },
  },

  methods: {
    showBanMessage() {
      if (this.$store.state.user.authorities[0].name === "ROLE_BAN") {
        this.showError = true;
      }
    },
  },

  created() {
    this.showBanMessage();
  },
};
</script>

<style scoped>
.completed-char {
  background-color: #3a5268;
  margin: 0;
    padding: 0;
}

</style>
