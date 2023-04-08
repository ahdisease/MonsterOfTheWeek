<template>
  <div class="home">
    <h1>Home</h1>
    <character-card/>
    <character-creation-form/>
  </div>
</template>

<script>
import CharacterCard from '../components/CharacterCard.vue';

import CharacterCreationForm from '../components/CharacterCreationForm.vue';

export default {
  name: "home",
  components: {

    CharacterCreationForm,
    CharacterCard,

  }
};
</script>
