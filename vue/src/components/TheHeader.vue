<template>
  <div id="title-block">
    <h2>Monster of the Week MotW</h2>
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
  width: 100%;
  border: 8px ridge #3A5268;
}
h2 {
  font-size: 2.5em;
  text-align: center;
  color: #00E88A;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 10px 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
}

nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 5px 20px;
   color: whitesmoke;
   margin: 0 auto;
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


@media screen and (max-width:1000px) {
 
h2 {
  font-size: 2em;
  text-align: center;
  color: #00E88A;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 10px 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
  color: #15B771;
}
nav {
   /* background-color: rgb(218, 124, 36); */
   text-align: center;
   padding: 5px 10px;
   margin: 0 auto;
   color: whitesmoke;
   /* width: 50%;
   display: flex;
   flex-direction: row; */
}

.nav-options {
  font-size: 1.2em;
  padding: 5px 12px;
  margin:0 auto;

}





}

@media screen and (max-width:768px) {

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