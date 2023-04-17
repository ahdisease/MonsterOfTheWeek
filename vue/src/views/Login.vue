<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" class= "alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" class= "alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit" class="sign-in-btn">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#login{
 background-color: #3a5268;
 height: 100%;
 padding-bottom: 356px;
}

.alert {
  color: #00E88A;
}

h1 {
  margin: 30px auto;
  color: #00E88A;
}

form {
  display: flex;
  flex-direction: column;
}

.form-input-group {
  margin: 0 auto 1rem;
  color: #00E88A;
}

.password {
  margin-right: 60px;
}

.sign-in-btn {
  margin: 10px auto;
  background-color: lightgreen;
  border-radius: 3px;
  border: none;
  text-align: center;
  font-size: 16px;
}

.sign-in-btn:hover {
  background-color: lightgreen;
  border: 3px solid black;
}

label {
  margin-right: 0.5rem;
}

p {
  margin: auto;
}
</style>