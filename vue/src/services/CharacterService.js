import axios from 'axios';

export default {

    getAllCharacters(date) {
        return axios.get(`/characters?date=${date}`);
    },

    getCharacterByUsername(username) {
        return axios.get(`/characters?username=${username}`);
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
    },
    getAllParties(date) {
        return axios.get(`/party?date=${date}`);
    },
    getWinningParty(date) {
        return axios.get(`/top-vote?date=${date}`);
    },
    
    flaggedInappropriate(id) {
        return axios.put(`/flag/characters/${id}`)

    }

}