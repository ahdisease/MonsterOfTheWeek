<template>
  <div id="app">
    <the-header />
    
    <router-view />
    <theFooter />
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

<style>
body {
  font-size: 14px;
  background-color: firebrick;
}
/* These don't do anything 
#app {
  width: 100%;
}
#the-header {
  width: 100%;
} */
</style>
