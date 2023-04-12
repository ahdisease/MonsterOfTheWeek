<template>
  <div class="home">
    <monster-splash class="monster-space" />
    <div class="versus">VS</div>
    <party-component class="party-space" />
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
  
}

.monster-space {
  
}

.versus {

}

.party-space {
  background-color: black;
  width: 20px;
}
</style>
