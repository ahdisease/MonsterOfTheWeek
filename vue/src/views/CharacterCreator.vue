<template>
  
    <div class="char-view">
        
    
    <character-creation-form  />

    
  </div>
</template>

<script>
import CharacterCreationForm from "../components/CharacterCreationForm.vue";

export default {
  name: "character-creator",

  

  components: {
    CharacterCreationForm,
  },
}
</script>

<style scoped>
.char-view {
  background-color: #3a5268;
}
</style>
