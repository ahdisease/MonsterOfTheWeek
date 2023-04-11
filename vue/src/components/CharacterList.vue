<template>
  <div>
      <h3>This is the Character List, Character Lovers!!!</h3>
      <p>the character cards will show up here:</p>
      <character-card  v-for="character in currentCharacters" 
      v-bind:key="character.id" v-bind:character="character" />
      <div></div>
  </div>
</template>

<script>
import CharacterCard from './CharacterCard.vue'
import CharacterService from '../services/CharacterService.js'


export default {
    name: "character-list", 

    components: { 
        CharacterCard 
    },

    data () {
        return {
            currentCharacters: [

            ]
        };
    },
    

    created() {
        this.currentCharacters = CharacterService.getAllCharacters()
            .then(response => {
                this.characters = response.data;
            })
    }


}
</script>

<style scoped>

</style>