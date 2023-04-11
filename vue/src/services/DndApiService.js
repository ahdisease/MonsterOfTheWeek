import axios from 'axios';

export default {

    getAllMonsters() {
        return axios.get('https://www.dnd5eapi.co/api/monsters')
    },

    getMonstersByIndexName(indexName) {
        return axios.get(`https://www.dnd5eapi.co/api/monsters/${indexName}`)
    },


}