<template>
  <div class="">
    <div id="intro">
      <h1>Party</h1>
      <p>
        View Your Party or create one with four (4) Characters. You are able to make one Party per week.
      </p>
    </div>
    <character-list></character-list>
  </div>
</template>

<script>
import CharacterList from "../components/CharacterList.vue";

export default {
  name: "party-view",
  components: {
    CharacterList,
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
}
#intro {
  text-align: center;
  margin: 0 auto;

}








</style>