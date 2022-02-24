<template>
  <form @submit.prevent="onSubmit">
    <BaseInput
      id="inpFullName"
      class="input"
      v-bind="$attrs"
      v-model="event.fullname"
      label="Full name"
      type="text"
    />
    <BaseInput
      id="inpAdress"
      class="input"
      v-bind="$attrs"
      v-model="event.adress"
      label="Adress"
      type="text"
    />
    <BaseInput
      id="inpUserName"
      class="input"
      v-bind="$attrs"
      v-model="event.username"
      label="Username"
      type="text"
    />
    <BaseInput
      id="inpPass"
      class="input"
      v-bind="$attrs"
      v-model="event.password"
      label="Password"
      type="password"
    />
    <BaseInput
      id="inpEmail"
      class="input"
      v-bind="$attrs"
      v-model="event.email"
      label="Email"
      type="email"
    />
    <BaseInput
      id="inpPhone"
      class="input"
      v-bind="$attrs"
      v-model="event.name"
      label="Phone"
      type="Integer"
    />
    <button id="btnRegister" type="submit" @click="onSubmit">Register</button>
  </form>
</template>
<script>
import BaseInput from "../components/BaseInput.vue";
import { v4 as uuidv4 } from "uuid";
export default {
  components: {
    BaseInput,
  },
  data() {
    return {
      event: {
        id: "",
        name: "",
        adress: "",
        username: "",
        password: "",
        email: "",
        phone: "",
      },
    };
  },
  created() {
    this.event = this.$store.state.event;
  },
  methods: {
    onSubmit() {
      this.$store.state.id = uuidv4();
      this.$store.commit("set_event", this.event);

      console.log("Lagring i state: ", this.$store.state.event);
    },
  },
};
</script>
