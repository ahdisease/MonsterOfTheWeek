<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register" class="form-class">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit" class="create-btn">Create Account</button>
      <div>
      <p id="login-link"><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register {
 background-color: #3a5268;
 height: 100%;
 padding-bottom: 356px;
}

h1 {
  padding-top: 30px;
  color: #00E88A;
}

.form {
  display: flex;
  flex-direction: column;
}

.form-input-group {
  margin-bottom: 1rem;
  color: #00E88A;
}

#username {
  margin-right: 4px;
}

#confirmPassword {
  margin-right: 60px;
}

.create-btn {
  margin: 10px auto;
  background-color: lightgreen;
  border-radius: 3px;
  border: none;
  text-align: center;
  font-size: 16px;
}

.create-btn:hover {
  background-color: lightgreen;
  border: 3px solid black;
}

label {
  margin-right: 0.5rem;
}

#login-link {
  background-image: linear-gradient(
    to right,
    #00e88a,
    #00e88a 50%,
    white 50%
  );
  background-size: 200% 100%;
  background-position: -100%;
  display: inline-block;
  padding: 5px 0;
  position: relative;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  transition: all 0.3s ease-in-out;
}

#login-link:before {
  content: '';
  background: #00e88a;
  display: block;
  position: absolute;
  bottom: -3px;
  left: 0;
  width: 0;
  height: 3px;
  transition: all 0.3s ease-in-out;
}

#login-link:hover {
 background-position: 0;
}

#login-link:hover::before {
  width:100%;
}
</style>
