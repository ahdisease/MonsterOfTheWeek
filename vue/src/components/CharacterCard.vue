<template>
  <article>
      <div class='character-card'  v-bind:key="character.id">
          <div>{{character.name}}</div>
          <div>{{character.charClass}}</div>
          <div>{{character.race}}</div>
          <div>{{character.description}}</div>
          
      </div>
  </article>
</template>

<script>

export default {
    name: 'character-card',
    props: ["character"],
    data() {
        return {
            

        }
    },
    

}
</script>

<style scoped>
    .character-card{
        margin: 10px 0;
    }
</style>