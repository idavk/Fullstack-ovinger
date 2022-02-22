<template>
  <div class="container" @submit.prevent="handleClickSignin">
    <BaseInput
      class="input"
      v-model="event.username"
      label="Username"
      type="text"
    />

    <BaseInput
      class="input"
      v-model="event.password"
      label="Password"
      type="text"
    />

    <button class="button" @click="handleClickSignin">Login</button>
  </div>
</template>
<script>
import BaseInput from "./BaseInput.vue";
import axios from "axios";
export default {
  name: "LoginComponent",
  components: {
    BaseInput,
  },
  data() {
    return {
      event: {
        username: "",
        password: "",
        loginStatus: "",
        message: "Looks like you need to be registered!",
      },
    };
  },
  methods: {
    async handleClickSignin() {
      //alert("You entered, username: " + this.username);
      const loginRequest = {
        username: this.event.username,
        password: this.event.password,
      };
      const loginResponse = await axios.post(
        "http://localhost:8085/demo/login",
        loginRequest
      );
      console.log(loginResponse);
      alert("Login: " + loginResponse.data.loginStatus);
      if (loginResponse.status == 201) {
        this.$router.push("/homepage");
      } else {
        alert("Denne brukeren er ikke registrert");
      }
    },
  },
};
</script>
