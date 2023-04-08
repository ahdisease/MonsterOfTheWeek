import axios from 'axios';

export default {

    getAllCharacters() {
        return axios.get('/characters');
    },

    addNewCharacter(character) {
        return axios.post('/characters', character);
    }

}