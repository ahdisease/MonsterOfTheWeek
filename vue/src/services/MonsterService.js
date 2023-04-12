import axios from 'axios';

export default {

    getCurrentMonster() {
        return axios.get(`http://localhost:9000/monsters`)
    },

    /**
     * 
     * @param {string} date date in the format 'YYYY-MM-DD'
     * @returns promise whose data returns a monster object
     */
    getMonsterByDate(date) {
        return axios.get(`http://localhost:9000/monsters?date=${date}`)
    },


}