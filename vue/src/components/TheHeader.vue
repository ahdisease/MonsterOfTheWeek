<template>
  <div id="title-block">
    <h2><router-link class="nav-options" v-bind:to="{ name: 'home' }">Monster of the Week MotW</router-link></h2>
    <nav id="nav">
      <router-link class="nav-options" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'character-view' }">Character</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'party' }">Party</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="nav-options" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
  background-color: #00201E;
  margin-top: 0;
  /* width: 100%; */
  border: 8px ridge #3A5268;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: baseline;
}
h2 {
  font-size: 2em;
  text-align: center;
  color: #00E88A;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 10px 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
  margin: 0 auto;
  flex: 50%;
}
h2 a{
  text-decoration: none;
}

nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 5px 20px;
   color: whitesmoke;
   margin: 0 auto;
   flex: 50%;

}


.nav-options {
  font-size: 1.2em;
  margin: 15px 20px;
  color: #15B771;
}

nav a {
  color: whitesmoke;
  text-decoration: none;
  font-size: 1.1em;
  
}
nav a:hover {
  color: #00E88A;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}



@media screen and (max-width:768px) {
  h2 {
  font-size: 1.5em;
}

nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 1px 10px;
   color: whitesmoke;
   width: 100%;
   display: flex;
   flex-direction: row;
}

.nav-options {
  font-size: 1.2em;
  padding: 1px 12px;
  margin:0 auto;

}


}

</style>