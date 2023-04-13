<template>
  <div class="">
    <character-creator v-if="!characterCreated" />
    <character-view-detailed v-if="characterCreated" />
  </div>
</template>

<script>
import CharacterViewDetailed from "../components/CharacterViewDetailed.vue";
import CharacterCreator from "./CharacterCreator.vue";
import CharacterService from "../services/CharacterService.js";

export default {
  name: "character-view",

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
  created() {
    if (!this.characterCreated) {
      CharacterService.getCharacterByUsername(
        this.$store.state.user.username
      ).then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_USER_CHARACTER", response.data);
        }
      });
    }
  },
};
</script>

<style scoped>
</style>