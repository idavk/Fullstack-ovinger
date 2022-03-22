<template>
  <div id="loginContainer" @submit.prevent="handleClickSignin">
    <BaseInput
      id="inpUsername"
      class="input"
      v-model="event.username"
      label="Username"
      type="text"
    />

    <BaseInput
      id="inpPassword"
      class="input"
      v-model="event.password"
      label="Password"
      type="password"
    />

    <button id="btnSubmit" class="button" @click="handleClickSignin">
      Login
    </button>
    <label id="loginstatusLabel">{{ loginStatus }}</label>
    <p v-if="loginFailed" id="alertRegister">
      Uuuups! Login failed.... Click here to sign up:
      <router-link to="/registrering">Register</router-link>
    </p>
  </div>
</template>
<script>
import BaseInput from "./BaseInput.vue";
import { doLogin } from "../utils/apiutil";
export default {
  name: "LoginInfo",
  components: {
    BaseInput,
  },
  data() {
    return {
      event: {
        username: "",
        password: "",
        message: "Looks like you need to be registered!",
      },
      loginFailed: false,
      loginStatus: "",
    };
  },
  methods: {
    async handleClickSignin() {
      //alert("You entered, username: " + this.event.username);
      const loginRequest = {
        username: this.event.username,
        password: this.event.password,
      };
      const LoginResponse = await doLogin(loginRequest);
      if (LoginResponse.loginStatus == "Success") {
        this.$store.commit("set_login_username", loginRequest.username);
        this.$router.push("/homepage");
      } else this.loginFailed = true;
    },
  },
};
</script>
<style scoped>
#loginContainer {
  display: grid;
  justify-content: center;
  margin: 40px;
}

#loginTitle {
  font-size: x-large;
  font-weight: bold;
  margin-bottom: 20px;
}

#username,
#password {
  display: flex;
  flex-direction: row;
  align-items: center;
  column-gap: 20px;
}
</style>
