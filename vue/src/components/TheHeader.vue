<template>
  <div id="title-block">
    <h2>Monster of the Week LOGOHERE</h2>
    <nav id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'character-creator' }">Character Creator</router-link>&nbsp;
      <router-link v-bind:to="{ name: 'party' }">Party Creator</router-link>&nbsp;

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

#title-block {
  background-color: rgb(41, 40, 40);
  margin-top: -25px;
  width: 100%;
}
h2 {
  font-size: 2em;
  text-align: center;
  color: gold;
  padding: 15px 0 0 0;
}

nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 10px 0;
   color: whitesmoke;
}

nav a {
  color: whitesmoke;
  text-decoration: none;
  font-size: 1.1em;
  
}
nav a:hover {
  color: rgb(235, 238, 67);
}


</style>