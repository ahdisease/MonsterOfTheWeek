<template>
  <div id="app">
    <the-header />
    <div id="spacer"></div>
    <router-view />
    <the-footer />
  </div>
</template>

<script>
import TheFooter from './components/TheFooter.vue';
import TheHeader from './components/TheHeader.vue';

export default {
  name: 'App',
  components: {
    TheHeader,
    TheFooter,
  },
}
</script>

<style >
#spacer {
  height: 100px;
  background-color: #3a5268;
}

body {
  background-color: #3a5268;
  font-size: 14px;
}

</style>
