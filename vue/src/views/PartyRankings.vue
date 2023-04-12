<template>
  <div>    <!-- method below needs finished-->
      <party-component v-bind:parties="parties"/>
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