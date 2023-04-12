<template>
    <div class="">
        <character-card v-bind:character="character"/>
    </div>
</template>

<script>
import CharacterCard from '../components/CharacterCard.vue'
import CharacterService from '../services/CharacterService.js'
export default {
  name: "character-view",
  
  components: { 
        CharacterCard 
    },

    data() {
        return {
            character: {}
        }
    },

    created() {
        CharacterService.getCharacterByUsername(this.$store.state.currentUser)
            .then(response => {
                this.character = response.data;
            });
    }

}
</script>

<style>

</style>