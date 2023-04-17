
<template>
  <img v-bind:src="url" />
</template>

<script>
export default {

  data() {
    return {
      url: 'https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/characters/tolbixi7uxskvstyof0o.jpg'
    }
  },
  
}
</script>


<style scoped>

img {
    width: 220px;
}
</style>