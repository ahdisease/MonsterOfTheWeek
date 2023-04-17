import axios from 'axios';

export default {
    markedApproved(id) {
        return axios.put(`/moderator/review/${id}`)

    },


}