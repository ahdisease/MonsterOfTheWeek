<template>
  <div class="home">
    <div class="monster-space">
      <monster-splash />
    </div>
    <div class="versus">VS</div>
    <div class="party-space">
      <party-component />
    </div>
  </div>
</template>

<script>
import MonsterSplash from '../components/MonsterSplash.vue'
import PartyComponent from '../components/PartyComponent.vue'



export default {
  name: "home",
  components: {
    MonsterSplash,
    PartyComponent

  }
};
</script>

<style scoped>

.home {
  display: flex;
  justify-content: space-between;
  align-items: center;
  
  
}

.monster-space {
  max-width: 60%;
}

.versus {
  border: 1px solid blue;
  font-size: 2.5rem;
  text-align: center;
  color: rgb(218, 31, 6);
  -webkit-text-stroke-width: 0.5px;
  -webkit-text-stroke-color: black;
  padding: 2rem 0 0 0;
  text-shadow: 2px 2px 6px rgb(54, 2, 2);
}

.party-space {
  background-color: black;
  width: 100px;
  height: 600px;
}
</style>
