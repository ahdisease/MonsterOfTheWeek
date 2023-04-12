<template>
  <div>
      
    </div>
</template>

<script>
import PartyComponent from "../components/PartyComponent.vue"
import CharacterService from "../services/CharacterService.js";

export default {
    name: 'party-rankings',
    parties: [],

    components: {
        PartyComponent
    },

    created() {
        CharacterService.getAllParties().then((response) => {
            this.parties.push(response);
        })
    },


}
</script>

<style scoped>

</style>