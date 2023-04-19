<template>
  <div id="home">
    <splash-page />
    <!-- <p id="intro">
      Welcome to Monster of the Week, where you pick your party to battle
      against a monster every week. Start by
      <b-btn class="callToAction">
        <router-link class="nav-options" v-bind:to="{ name: 'character-view' }"
          >Creating a Character</router-link
        >
      </b-btn>
      or go straight to
      <b-btn class="callToAction">
        <router-link class="nav-options" v-bind:to="{ name: 'party' }"
          >Forming a Party</router-link
        >
      </b-btn>
    </p> -->
    <div id="main-battle">
      <div class="monster-space">
        <monster-splash />
      </div>
      <div class="versus"><h1>VS</h1></div>
      <div class="party-space">
         <party-component v-if="!banContent" /><!-- // ban here  -->
      </div>
    </div>
    <div id="winner-space">
      <party-winner />
    </div>
  </div>
</template>

<script>
import MonsterSplash from "../components/MonsterSplash.vue";
import PartyComponent from "../components/PartyComponent.vue";
import PartyWinner from "../components/PartyWinner.vue";
import SplashPage from '../components/SplashPage.vue';
import CharacterService from '../services/CharacterService';

export default {
  name: "home",

  data () {
    return {
      banContent: false,
    }
  },
  
  components: {
    MonsterSplash,
    PartyComponent,
    PartyWinner,
    SplashPage,
  },

  methods: {
    hideContent() {
      if (this.$store.state.user.authorities[0].name === "ROLE_BAN") {
        this.banContent = true;
      }
    },
  },

  created() {
    this.hideContent();


//check for SET_VIEW_CHARAC in the future
    CharacterService.getCharacterByUsername(
      this.$store.state.user.username
    ).then((response) => {
      if (response.status == 200) {
        this.$store.commit("SET_USER_CHARACTER", response.data)
      }
    });
    CharacterService.getPartyByUsername(
      this.$store.state.user.username
    ).then((response) => {
      if (response.status == 200) {
        this.$store.commit("SET_USER_PARTY", response.data)
      }
    })
  }
}
</script>

<style scoped>

#home {
 /* display: grid;
 background: #096660;
 grid-template-areas:
    "intro intro intro"
    "monster-space versus party-space"
    "monster-space versus party-space"
    "winner-space winner-space winner-space"; 
 margin: 0;
 padding: 0;
 height: 100%;
 width: auto;
 grid-template-rows: .2fr 1fr .5fr;
  justify-content: center;
  align-items: center;
  background-color: #3a5268;
  grid-area: home; */
  display: flex;
  flex-direction: column;
  justify-content: space-between; 
  align-items: center;
  background-color: #3a5268;
}
#intro {
  grid-area: intro;
  text-align: center;
  font-weight: 500;
  padding: 10px 20px;
  color: #15b771;
}
.callToAction {
  padding: 0px 4px;
  color: #15b771;
  background-color: #00201e;
  border: none;
}
.callToAction .nav-options a {
  color: #15b771;
}
.callToAction:hover {
  background-color: #007f5f;
  /* color: #00e88a; */
}
.callToAction a:hover {
  color: #00e88a;
}
.callToAction .nav-options {
  color: #15b771;
  text-decoration: none;
}
#intro .nav-options a:hover {
  /* color: rgb(180, 131, 39); */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.9);
  /* transition: 0.3s; */
}
#main-battle {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  height: auto;
  width: 100%;
}
.monster-space {
  /* flex: 50%; */
  grid-area: monster-space;
  border-radius: 6px;
  /* background-color: #00201e; */
  margin: 10px;
}
.versus {
  /* align-self: center; */
  grid-area: versus;
  display: flex;
  flex-direction: column;
  align-self: center;
  /* font-size: 3rem; */
  text-align: center;
  /*color: #00e88a;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  text-shadow: 2px 2px 6px rgb(54, 2, 2); */
}
.versus h1 {
  font-size: 5em;
  text-align: center;
  justify-self: center;
  align-self: center;
  color: #007f5f;
  -webkit-text-stroke-width: 4px;
  -webkit-text-stroke-color: #00e88a;
  font-weight: 900;
  font-style: italic;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
}

.party-space {
  border-radius: 6px;
  margin: 0 10px;
  /* added this because it was empty */
  /* background-color: rgb(243, 200, 176); */
  grid-area: party-space;
  display: flex;
  flex-direction: column;
  align-self: center;
  /* flex: 40%; */
  /* justify-self: flex-end; */
  /* flex-shrink: 1; */
}

#winner-space {
  background-color: #00201E;
  width: 100%;
  margin: 10px 0;
  padding: 15px;
  grid-area: winner-space;
}
@media screen and (max-width: 1000px) {
  #main-battle {
    flex-direction: column;
    align-items: center;
  }
  .party-space {
    /* flex: 100%; */
    justify-self: center;
  }
}

@media screen and (max-width: 768px) {
  /* putting this in so it's a remind and so it's not empty  */

  #main-battle {
    flex-direction: column;
  }

  #winner-space {
    /* width: 75%; */
    margin: 10px 0;
  }
}
</style>
