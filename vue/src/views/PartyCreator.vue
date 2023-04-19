<template>
  <div class="party-view">
    <div id="ban-message" role="alert" v-if="showError">
      {{ errorMessage }}
    </div>

    <character-list v-if="!showError"></character-list>
  </div>
</template>

<script>
import CharacterList from "../components/CharacterList.vue";

export default {
  name: "party-view",

  data() {
    return {
      showError: false,
      errorMessage: "Sorry, You have been banned.",
    };
  },

  components: {
    CharacterList,
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
.party-view {
  background-color: #3a5268;
}

#intro > p {
  color: #00e88a;
}

#ban-message {
  height: 100%;
  text-align: center;
  font-size: 50px;
  font-weight: bold;
  color: #00e88a;
  background: #00201e;
}

h1 {
  text-align: center;
}
#intro {
  text-align: center;
  margin: 0 auto;
}
</style>
