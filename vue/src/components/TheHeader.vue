<template>
  <div>
    <div id="title-block">
      <!-- <link rel="preload" as="font" href="FletcherGothic-pwy.ttf" type="font/ttf" crossorigin="anonymous"> -->
      <div>
        <h2>
          <img
            id="motw-logo"
            src="https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681840313/LogoMotW_dyafdk.png"
            alt="MotW Logo"
          />
          <router-link class="nav-options" v-bind:to="{ name: 'home' }"
            >Monster of the Week
          </router-link>
        </h2>

        <nav id="nav">
          <router-link class="nav-options" v-bind:to="{ name: 'home' }"
            >Home</router-link
          >
          <router-link
            class="nav-options"
            v-bind:to="{ name: 'character-view' }"
            >Character</router-link
          >
          <router-link class="nav-options" v-bind:to="{ name: 'party' }"
            >Party</router-link
          >
          <router-link
            class="nav-options"
            v-bind:to="{ name: 'moderator' }"
            v-if="confirmModeratorPermissions"
            >Moderation</router-link
          >
          <router-link
            class="nav-options"
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token == ''"
            >Login</router-link
          >
          <router-link
            class="nav-options"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-header",
  computed: {
    confirmModeratorPermissions() {
      let allowed = false;
      if (this.$store.state.user.authorities) {
        this.$store.state.user.authorities.forEach((authority) => {
          if (authority.name === "ROLE_MOD") {
            allowed = true;
          }
        });
      }

      return allowed;
    },
  },
};
</script>

<style scoped>
/* @font-face {
    font-family: FletcherGothic;
    src: url(FletcherGothic-pwy.ttf);
} */

#title-block {
  z-index: 2;
  background-color: #00201e;

  /* width: 100%; */
  border: 8px ridge #3a5268;
  display: block;
  width: 100%;

  position: fixed;

}

#title-block > div {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: baseline;
}

h2 {
  font-family: FletcherGothic, "Franklin Gothic Medium", "Arial Narrow", Arial,
    sans-serif;
  font-size: 2em;
  text-align: center;
  color: #00e88a;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 10px 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
  margin: 0 auto;
  flex: 50%;
}
h2 a {
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
  color: #15b771;
}

nav a {
  color: whitesmoke;
  text-decoration: none;
  font-size: 1.1em;
}
nav a:hover {
  color: #00e88a;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}

#motw-logo {
  width: 60px;
  margin: 0 0 15px 0;
  /* text-shadow: 2px 2px 6px rgb(54, 2, 2); */
}

@media screen and (max-width: 768px) {
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
    margin: 0 auto;
  }
}
</style>