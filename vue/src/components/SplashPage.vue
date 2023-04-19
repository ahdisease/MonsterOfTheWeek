<template>
  <div id="wrapper">
    <div id="bg-image"></div>
    <main id="main-splash">
      <h1>Battle the Monster of the Week!</h1>
      <p>Create your own character and form a party to face the monster!</p>
      <!-- <h2>Create your own character to adventure with!</h2> -->
      <div id="buttons">
        <b-button class="cta"
          ><router-link
            class="nav-options"
            v-bind:to="{ name: 'character-view' }"
            >CREATE YOUR CHARACTER</router-link
          ></b-button
        >
        <!-- <h2>Join with other characters and form a party to face the monster!</h2> -->
        <b-button class="cta"
          ><router-link class="nav-options" v-bind:to="{ name: 'party' }"
            >ASSEMBLE YOUR PARTY</router-link
          ></b-button
        >
      </div>
      <!-- <p>
        The combination of characters that gets picked the most is the winning
        party!
      </p> -->
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
  /* background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681865026/SCAG_1920x1080_Wallpaper_cmmsj8.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 600px;
  background-position-x: center;
  background-position-y: top; */
}
#bg-image {
  width: 100%;
  background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681865026/SCAG_1920x1080_Wallpaper_cmmsj8.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 600px;
  background-position-x: center;
  background-position-y: top;
  opacity: 0.75;

}

h1 {
  font-size: 4em;
  /* background-color: #ffffff15; */
}
#main-splash p{
    /* background-color: #ffffff20; */
    text-align: center;
    width: 80%;
    margin: 0 auto;
    font-size: 1.12em;
}


#main-splash {
  border-radius: 6px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  /* Good under this */
  width: 80%;
  margin: 0 auto;
  padding: 30px;
  /* color: #00e88a; */
  color: white;
  background-color: #00000023;
  text-shadow: 1px 1px black;
}
#buttons {
  width: 90%;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin: 20px auto;
}
.cta {
  margin: 0 auto;
  background-color: #00201e;


}
/* .nav-options {
  text-decoration: none;
  color: #00e88a;
  
} */
.cta:hover {
    background-color: #00201e;

}

.nav-options {
  background-color: #00201e;

  background-image: linear-gradient(to right, #00e88a, #00e88a 50%, white 50%);
  background-size: 200% 100%;
  background-position: -100%;
  display: inline-block;
  padding: 5px 0;
  position: relative;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  transition: all 0.2s ease-in-out;
}

.nav-options:before {
  content: "";
  background: #00e88a;
  display: block;
  position: absolute;
  bottom: -3px;
  left: 0;
  width: 0;
  height: 3px;
  transition: all 0.2s ease-in-out;
}

.nav-options:hover {
  background-position: 0;

}

.nav-options:hover::before {
  width: 100%;

}

/* .nav-options {
  background-image: linear-gradient(to right, #00e88a, #00e88a 50%, white 50%);
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
  content: "";
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
  width: 100%;
} */

@media screen and (max-width: 1000px) {
  h1 {
    font-size: 3.5em;
  }

  #main-splash {
    width: 90%;
    padding: 5px;
    text-align: center;
  }
  #bg-image {
    background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681910644/SCAG_iPad_Wallpaper_ivrrtn.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    min-height: 450px;
    background-position-x: center;
    background-position-y: top;
  }
  .cta {
    padding: 5px;
    margin: 0 10px;
  }
  #buttons {
    justify-content: space-between;
  }
  #wrapper {
    background-color: #3a5268;

    /* background-position-x: center;
    background-position-y: top;
    background-image: url("https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681910644/SCAG_iPad_Wallpaper_ivrrtn.jpg"); */
  }
}
</style>