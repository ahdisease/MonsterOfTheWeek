import axios from 'axios';

export default {

    getAllCharacters(date) {
        return axios.get(`/characters?date=${date}`);
    },

    addNewCharacter(character) {
        return axios.post('/characters', character);
    },

    addNewParty(party) {
        return axios.post ('/party', party);
    }

}