<template>
  <div class="home">
    <div class="monster-space">
      <monster-splash />
    </div>
    <div class="versus">VS</div>
    <div class="party-space">
      <party-component />
    </div>
    <div id="winner-space">
      <party-winner />
    </div>
  </div>
</template>

<script>
import MonsterSplash from '../components/MonsterSplash.vue'
import PartyComponent from '../components/PartyComponent.vue'
import PartyWinner from '../components/PartyWinner.vue';



export default {
  name: "home",
  components: {
    MonsterSplash,
    PartyComponent,
    PartyWinner

  }
};
</script>

<style scoped>

body {
    display: grid;
    grid-template-areas: "home"
                         "monster-space"
                         "party-space"
                         "winner-space";
    margin: 0;
    padding: 0;
    grid-template-rows: 1fr 1fr 3fr 1fr;
    width: 100%;
    height: auto;
}

.home {
  grid-area: home;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  
}

.monster-space {
  width: auto;
  grid-area: monster-space;
}

.versus {
  font-size: 3rem;
  text-align: center;
  color: rgb(218, 31, 6);
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




@media screen and (max-width: 1000px) {
  
/* putting this in so it's a remind and so it's not empty  */

#winner-space {
  width: 75%;
  margin: 10px 0;
}





}


</style>
