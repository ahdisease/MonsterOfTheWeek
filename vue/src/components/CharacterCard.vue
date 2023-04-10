<template>
  <article>
      <div class='character-card' v-for="character in characters" v-bind:key="character.id">
          <div>{{character.name}}</div>
          <div>{{character.charClass}}</div>
          <div>{{character.race}}</div>
          <div>{{character.description}}</div>
      </div>
  </article>
</template>

<script>
import characterService from '../services/CharacterService.js';

export default {
    name: 'character-card',
    data() {
        return {
            characters: []
        }
    },
    
    created() {
        characterService.getAllCharacters()
            .then(response => {
                this.characters = response.data;
            })
    }
}
</script>

<style scoped>
    .character-card{
        margin: 10px 0;
    }
</style>