<template>
  <div class="footer">
      <countdown-timer/>
      Copyright MotW, All Rights Re-severed
  </div>
</template>

<script>
import CountdownTimer from './CountdownTimer.vue'
export default {
  components: { CountdownTimer },
    name: "the-footer"
}
</script>

<style>
    .footer {
        height: 1%;
        color: white;
        background-color: black;
        text-align: center;
    }
</style>