import axios from 'axios';

export default {

    getAllCharacters(date) {
        return axios.get(`/characters?date=${date}`);
    },

    getCharacterById(id) {
        return axios.get(`/characters/${id}`);
    },

    addNewCharacter(character) {
        return axios.post('/characters/', character);
    },

    addNewParty(party) {
        return axios.post ('/party/', party);
    },

    getPartyByUsername(username) {
        return axios.get(`/party?username=${username}`)
    }

}