import axios from 'axios';

export default {
    markedApproved(id) {
        return axios.put(`/moderator/review/${id}`)

    },
    getAllUsers() {
        return axios.get(`/moderator/users/`)
    },
    banUserById(id) {
        return axios.put(`/moderator/ban/${id}`);
    }


}