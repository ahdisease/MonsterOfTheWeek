
<template>
  <AdvancedImage v-bind:cldImg="myImg" />
</template>

<script>
import { AdvancedImage } from '@cloudinary/vue'
import { Cloudinary } from '@cloudinary/url-gen'
export default {
  components: {
    AdvancedImage
  },
  data() {
    return {
      cloud: {},
      myImg: {}
    }
  },
  created() {
    this.cloud = new Cloudinary({
      cloud: {
        cloudName: 'c19-lima-monster-of-the-week',
        apiKey: '965275756759159'
      }
    })

    this.myImg = this.cloud.image('sample')
  }
}
</script>


<style scoped>

img {
    width: 220px;
}
</style>