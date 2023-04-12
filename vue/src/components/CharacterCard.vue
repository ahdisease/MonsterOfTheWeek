<template>
  <article class='character-card'  v-bind:key="character.id">
      <!-- <div > -->
          <div>{{character.name}}</div>
          <div>{{character.charClass}}</div>
          <div>{{character.race}}</div>
          <div>{{character.description}}</div>
          <div>Strength: {{character.strength}}</div>
          <div>Dexterity: {{character.dexterity}}</div>
          <div>Constitution: {{character.constitution}}</div>
          <div>Intelligence: {{character.intelligence}}</div>
          <div>Wisdom: {{character.wisdom}}</div>
          <div>Charisma: {{character.charisma}}</div>
          
      <!-- </div> -->
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
        background-color: slategray;
        color: snow;
        padding: 10px;
        border: 2px solid black;

    }
</style>