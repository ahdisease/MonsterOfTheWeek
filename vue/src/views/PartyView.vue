<template>
  <div class ="">
      <h1>Pick Your Party</h1>
      <party-component></party-component>
      <character-list ></character-list>
  </div>
</template>

<script>
import PartyComponent from '../components/PartyComponent.vue'
import CharacterList from '../components/CharacterList.vue'

export default {
name: "party-view",
  components: {
    PartyComponent,
    CharacterList
  },

}
</script>

<style scoped>
h1 { 
  text-align: center;
}
</style>