<template>
  <div>
    <div id="title-block">
      <!-- <link rel="preload" as="font" href="FletcherGothic-pwy.ttf" type="font/ttf" crossorigin="anonymous"> -->
      
        <h2>
          <img
            id="motw-logo"
            src="https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681929227/LogoMotW_kjroas.png"
            alt="MotW Logo"
          />
          <router-link class="nav-options" v-bind:to="{ name: 'home' }"
            >Monster of the Week
          </router-link>
        </h2>

        <nav id="nav">
          <router-link class="nav-options" v-bind:to="{ name: 'home' }">Home</router-link>

          <router-link class="nav-options" v-bind:to="{ name: 'character-view' }">Character</router-link>

          <router-link class="nav-options" v-bind:to="{ name: 'party' }">Party</router-link>

          <router-link class="nav-options" v-bind:to="{ name: 'moderator' }" v-if="confirmModeratorPermissions">Moderation</router-link>

          <router-link class="nav-options" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>

          <router-link class="nav-options" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </nav>

        <div id="drop-nav">
          <b-nav>
            <b-nav-item-dropdown id="my-nav-dropdown" text="Menu"
              toggle-class="nav-link-custom"
              right>
              <b-dropdown-item>
                <router-link class="nav-options" v-bind:to="{ name: 'home' }">Home</router-link>
              </b-dropdown-item>
              <b-dropdown-item>
                <router-link class="nav-options" v-bind:to="{ name: 'character-view' }">Character</router-link>
              </b-dropdown-item>
              <b-dropdown-item>
                <router-link class="nav-options" v-bind:to="{ name: 'party' }">Party</router-link>
                </b-dropdown-item>
              <b-dropdown-item>
                <router-link class="nav-options" v-bind:to="{ name: 'moderator' }" v-if="confirmModeratorPermissions">Moderation</router-link>
              </b-dropdown-item>
              <b-dropdown-item>
                 <router-link class="nav-options" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
              </b-dropdown-item>
              <b-dropdown-item>
                <router-link class="nav-options" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
              </b-dropdown-item>
            </b-nav-item-dropdown>
          </b-nav>
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

/* herein */

#title-block {
  z-index: 3;
  background-color: #00201e;

  /* width: 100%; */
  border: 8px ridge #3a5268;
  display: flex;
  height: 100px;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  position: fixed;
}

h2 {
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 2em;
  color: #00e88a;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 8px 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
  margin: auto 0 auto 15px;
  
}
h2 a {
  text-decoration: none;
}

nav {
  /* background-color: rgb(218, 124, 36); */
  text-align: center;
  color: whitesmoke;
  margin: auto;
  flex: 50%;
}

.nav-options {
  font-size: 1.2em;
  margin: auto 15px;
  color: #00e88a;
}

nav a {
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

nav a:before {
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

nav a:hover {
  background-position: 0;
}

nav a:hover::before {
  width: 100%;
}

/* nav a {
  color: whitesmoke;
  text-decoration: none;
  font-size: 1.1em;
}
nav a:hover {
  color: #00e88a;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
} */

#motw-logo {
  width: 60px;
  margin: 0 0 15px 0;
}
#motw-logo:hover {
  box-shadow: 4px 4px 4px #00e88a, -4px -4px 4px #00e88a, -4px 4px 4px #00e88a,
    4px -4px 4px #00e88a;
  border-radius: 50%;
}

#drop-nav {
  display: none;
}

@media screen and (max-width: 950px) {
  h2 {
    font-size: 1.5em;
  }

  .nav-options {
  font-size: 1.2em;
  margin: auto 10px;
  }
}

@media screen and (max-width: 768px) {
  h2 {
    font-size: 1em;
  }

  #title-block {
  height: 75px;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: baseline;
}

  #motw-logo {
  width: 40px;
  margin: 0 0 15px 0;
}

  nav {
    text-align: center;
    padding: 1px 10px;
    color: whitesmoke;
    width: 100%;
    display: none;
    flex-direction: row;
  }

  #drop-nav {
    display: block;
    border-radius: 4px;
    margin: auto 10px;
    text-align: center;
    
    }

  #my-nav-dropdown {
    width: 100%;
    background-color: #00e88a;
    padding: 1px 2px;
    border-radius: 10px;
    list-style: none;
    text-decoration: none;
  }

  .nav-options {
    font-size: 1.2em;
    padding: 1px 12px;
    margin: 0 auto;
    
  }
}
</style>
