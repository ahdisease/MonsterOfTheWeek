<template>
  <div class ="">
      <h1>Select Your Party Members</h1>
      <character-list ></character-list>
  </div>
</template>

<script>
import CharacterList from '../components/CharacterList.vue'

export default {
name: "party-view",
  components: {
    CharacterList
  },

}
</script>

<style scoped>
h1 { 
  text-align: center;
}
</style>