<template>
  <div id="wrapper" class="bg-image">
    <main id="main-splash">
      <h1>Battle the Monster of the Week!</h1>
      <p></p>
      <h2>Create your very own character to adventure with!</h2>
      <b-button><router-link class="nav-options" v-bind:to="{ name: 'character-view' }"
          >CREATE YOUR CHARACTER</router-link></b-button>
      <h2>Join with other characters and form a party to face the monster!</h2>
      <b-button><router-link class="nav-options" v-bind:to="{ name: 'party' }"
          >ASSEMBLE YOUR PARTY</router-link></b-button>
      <p>
        The combination of characters that gets picked the most is the winning
        party!
      </p>
      
    </main>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#wrapper {
  background-color: #3a5268;
  width: 100%;

}
.bg-image {
    background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681865026/SCAG_1920x1080_Wallpaper_cmmsj8.jpg");
  width: 100%;
}
#main-splash {
  width: 80%;
  margin: 0 auto;
}
.nav-options {
  text-decoration: none;
}








</style>