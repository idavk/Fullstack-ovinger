<template>
  <div id="loginContainer" @submit.prevent="handleClickSignin">
    <BaseInput
      id="inpUsername"
      class="input"
      v-model="username"
      label="Username"
      type="text"
    />

    <BaseInput
      id="inpPassword"
      class="input"
      v-model="password"
      label="Password"
      type="password"
    />

    <button id="btnSubmit" class="button" @click="handleClickSignin">
      Login
    </button>
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
      userNotFound: false,
      register: false,
      username: "",
      password: "",
    };
  },
  methods: {
     async handleClickSignin() {
      const loginRequest = { username: this.username, password: this.password };
      const loginResponse = await doLogin(loginRequest);
      this.$router.push("/Kalkulator");
      if (loginResponse == "Wrong password") {
        alert(loginResponse);
      } else if (loginResponse == "User not found") {
        alert(loginResponse)
      } else {
        this.$store.commit("SET_TOKEN", loginResponse);
        this.$store.commit("SET_USERNAME", this.username);
      }
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
.button {
  display: flex;
  justify-content: center;
}
</style>
