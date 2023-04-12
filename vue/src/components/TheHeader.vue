<template>
  <div id="title-block">
    <h2>Monster of the Week MotW</h2>
    <nav id="nav">
      <router-link class="nav-options" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'character-creator' }">Character Creator</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'party' }">Party Creator</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
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
  background-color: rgb(243, 200, 176);
  margin-top: 0;
  width: 100%;
  border: 8px ridge darkred;
}
h2 {
  font-size: 2.5rem;
  text-align: center;
  color: rgb(218, 31, 6);
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 2rem 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
}

nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 10px 0 20px;
   color: whitesmoke;
}

.nav-options {
  font-size: 1.2rem;
  margin: 15px 20px;
  color: rgb(138, 91, 3);
}

nav a {
  color: whitesmoke;
  text-decoration: none;
  font-size: 1.1em;
  
}
nav a:hover {
  color: rgb(180, 131, 39);
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}


</style>