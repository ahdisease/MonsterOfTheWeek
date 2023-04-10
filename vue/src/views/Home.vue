<template>
  <div class="home">
    <h1>Home</h1>
    <character-card/>
    
  </div>
</template>

<script>
import CharacterCard from '../components/CharacterCard.vue';


export default {
  name: "home",
  components: {

    CharacterCard,

  }
};
</script>
