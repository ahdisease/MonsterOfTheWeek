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
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  
  
}

.monster-space {
  width: 90%;
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
  
}
</style>
