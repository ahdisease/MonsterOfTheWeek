<template>
  <div>
    <h2>Monster of the Week LOGOHERE</h2>
    <nav id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
       <router-link v-bind:to="{ name: 'character-creator' }">Character Creator</router-link>&nbsp;|&nbsp;

      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </nav>
  </div>
</template>

<script>
export default {
    name: 'the-header',


};
</script>

<style scoped>
nav {
   background-color: burlywood;
}
</style>