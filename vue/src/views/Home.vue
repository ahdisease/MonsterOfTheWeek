<template>
  <div class="home">

      <monster-splash />
    <party-component/>
  </div>
</template>

<script>
import MonsterSplash from '../components/MonsterSplash.vue'
import PartyComponent from '../components/PartyComponent.vue';



export default {
  name: "home",
  components: {
    MonsterSplash,
    PartyComponent

  }
};
</script>
