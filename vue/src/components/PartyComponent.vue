<template>
  <div>
    <h1>This is the Party Area, PARTY PEOPLE!!!!!!</h1>
    <p>the form starts under this:</p>
      <div id="party-cards">

        <character-card  v-for='character in filteredParty'
          v-bind:key="character.id" v-bind:character='character'/>
      

        <div id="firstChar">This is the first Character</div>
        <div id="secondChar">This is the second Character</div>
        <div id="thirdChar">This is the third Character</div>
        <div id="fourthChar">This is the fourth Character</div>
      </div>
  </div>
</template>

<script>

import CharacterCard from '../components/CharacterCard.vue'

export default {
    name: "party-page",
    components: {
      CharacterCard
    },
    data(){
        return {
          
        };

    },
    computed: {
      filteredParty() {
        return [];
      },
    },
    methods: {
      cancelForm() {
        
      }
    }

    
}
</script>

<style scoped>
h1 {
  text-align: center;
}

#party-cards {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 100%;
  background-color: aqua;

}
#firstChar {
  background-color: blueviolet;
}
#secondChar {
  background-color: blueviolet;
}
#thirdChar {
  background-color: blueviolet;
}
#fourthChar {
  background-color: blueviolet;
}


</style>