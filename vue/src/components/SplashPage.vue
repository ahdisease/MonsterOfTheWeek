<template>
  <div id="wrapper">
    <main id="main-splash">
      <h1>Battle the Monster of the Week!</h1>
      <p></p>
      <h2>Create your very own character to adventure with!</h2>
      <b-button class="cta"><router-link class="nav-options" v-bind:to="{ name: 'character-view' }"
          >CREATE YOUR CHARACTER</router-link></b-button>
      <h2>Join with other characters and form a party to face the monster!</h2>
      <b-button class="cta"><router-link class="nav-options" v-bind:to="{ name: 'party' }"
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
  background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681865026/SCAG_1920x1080_Wallpaper_cmmsj8.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 700px;
  background-position-x: center;
  background-position-y:top;

}

h1 {
  font-size: 4em;
}

#main-splash {
  width: 70%;
  margin: 0 auto;
  padding: 30px; 
  /* color: #00e88a; */
  color: white;
  background-color: #ffffff15;
  text-shadow: 1px 1px black;
;
}
.cta {
margin: 0 auto;
}
/* .nav-options {
  text-decoration: none;
  color: #00e88a;
  
} */

.nav-options {
  background-image: linear-gradient(
    to right,
    #00e88a,
    #00e88a 50%,
    white 50%
  );
  background-size: 200% 100%;
  background-position: -100%;
  display: inline-block;
  padding: 5px 0;
  position: relative;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  transition: all 0.3s ease-in-out;
}

.nav-options:before {
  content: '';
  background: #00e88a;
  display: block;
  position: absolute;
  bottom: -3px;
  left: 0;
  width: 0;
  height: 3px;
  transition: all 0.3s ease-in-out;
}

.nav-options:hover {
 background-position: 0;
}

.nav-options:hover::before {
  width:100%;
}

@media screen and (max-width: 1000px) {
  h1 {
  font-size: 3em;
  }

  #main-splash{
    width: 90%;
    padding: 5px;
  }
  #wrapper {
    background-position-x: center;
    background-position-y:top;
    background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681910644/SCAG_iPad_Wallpaper_ivrrtn.jpg");
  }  
}








</style>