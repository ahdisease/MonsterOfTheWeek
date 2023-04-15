<template>
  <div class="home">
    <p id="intro">
      Welcome to Monster of the Week, where you pick your party to battle
      against a monster every week. Start by
      <b-btn class="callToAction">          <router-link class="nav-options" v-bind:to="{ name: 'character-view' }">Creating a Character</router-link>
 </b-btn>
      or go straight to <b-btn class="callToAction">      <router-link class="nav-options" v-bind:to="{ name: 'party' }">Forming a Party</router-link>
 </b-btn>
    </p>
    <div id="main-battle">
      <div class="monster-space">
        <monster-splash />
      </div>
      <div class="versus"><h1>VS</h1></div>
      <div class="party-space">
        <party-component />
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

export default {
  name: "home",
  components: {
    MonsterSplash,
    PartyComponent,
    PartyWinner,
  },
};
</script>

<style scoped>
/* body {
  display: grid;
  background: #096660;
  grid-template-areas:
    "home"
    "monster-space"
    "versus"
    "party-space"
    "winner-space";
  margin: 0;
  padding: 0;
  grid-template-rows: 1fr 1fr 4fr 4fr 1fr;
} */

.home {
  grid-area: home;
  display: flex;
  flex-direction: column;
  /* justify-content: space-between; */
  align-items: center;
}
#intro{
  text-align: center;
  font-weight: 500;
  padding: 10px 20px;
}
.callToAction {
  padding: 0px 4px;
}
.nav-options {
  color: white;
  text-decoration: none;
}
.nav-options a:hover {
  /* color: rgb(180, 131, 39); */
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
}
#main-battle {
  display: flex;
  flex-direction: row;
}



.monster-space {
  flex: 60%;
  grid-area: monster-space;
}

.versus {
  /* align-self: center; */
  grid-area: versus;
  /* font-size: 3rem;
  text-align: center;
  color: #00e88a;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  text-shadow: 2px 2px 6px rgb(54, 2, 2); */
}
.versus h1 {

  font-size: 5em;
  text-align: center;
  color: #00e88a;
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);

}

.party-space {
  /* added this because it was empty */
  background-color: rgb(243, 200, 176);
  grid-area: party-space;
}

#winner-space {
  margin: 10px 0;
  grid-area: winner-space;
}

@media screen and (max-width: 768px) {
  /* putting this in so it's a remind and so it's not empty  */

  #main-battle {
    flex-direction: column;
  }

  #winner-space {
    width: 75%;
    margin: 10px 0;
  }
}
</style>
