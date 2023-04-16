<template>
  <div id="app">
    <the-header />
    
    <router-view />
    <!-- <theFooter /> -->
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue';

export default {
  name: 'App',
  components: {
    TheHeader,
  },
}
</script>

<style >
body {
  background: #3a5268;
  font-size: 14px;
}

</style>
