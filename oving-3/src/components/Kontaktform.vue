<template>
  <div class="container">
    <form @submit.prevent="onSubmit">
      <BaseInput
        class="input"
        v-model="user.name"
        :error="nameError"
        label="Name"
        type="text"
      />
      <BaseInput
        class="input"
        v-model="user.email"
        :error="emailError"
        label="Email"
        type="text"
      />

      <BaseInput
        class="input"
        v-model="message"
        :error="messageError"
        label="Feedback"
        type="text"
      />

      <button class="button" type="submit" :disabled="buttonIsDisabled">
        {{ buttonText }}
      </button>
    </form>
  </div>
</template>
<script>
import BaseInput from "./BaseInput.vue";
// import { useField, useForm } from "vee-validate";
import { v4 as uuidv4 } from "uuid";
export default {
  components: { BaseInput },
  data() {
    return {
      user: {
        id: "",
        name: "",
        email: "",
      },
      message: "",
      status: "none",
    };
  },
  created() {
    this.user = this.$store.state.user;
  },
  methods: {
    onSubmit() {
      this.user.id = uuidv4();
      this.$store.commit("set_user", this.user);

      console.log("Lagring i state: ", this.$store.state.user);
      this.status = "sending";
      let vueThis = this;
      setTimeout(function () {
        vueThis.status = "done";
        vueThis.$store.commit("set_status", vueThis.status);
      }, 5000);
    },
  },
  computed: {
    buttonIsDisabled() {
      let isValid = true;

      if (!this.inputIsValid) isValid = false;
      if (this.status != "none") isValid = false;
      return !isValid;
    },
    inputIsValid() {
      let value = true;
      console.log("messageError is: " + this.messageError);
      if (this.messageError) value = false;
      if (this.emailError) value = false;
      if (this.nameError) value = false;
      return value;
    },
    emailError() {
      const value = this.user.email;
      if (!value) return "This field is required";
      const regex =
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (!regex.test(String(value).toLowerCase())) {
        return "Please enter a valid email address";
      }
      return null;
    },
    nameError() {
      const value = this.user.name;

      const requiredMessage = "This field is required";
      if (value === undefined || value === null) return requiredMessage;
      const validName = /^[a-åA-Å ]+$/;
      if (!validName.test(String(value).toLowerCase())) {
        return "Please enter a valid name";
      }
      return null;
    },
    messageError() {
      const value = this.message;
      const requiredMessage = "This field is required";
      console.log(value === undefined || value === null || value == "");
      if (value === undefined || value === null || value == "")
        return requiredMessage;
      if (!String(value).length) return requiredMessage;
      return null;
    },
    buttonText() {
      if (this.status == "none") return "Send";
      if (this.status == "sending") return "Sending...";
      if (this.status == "done") return "Submitted!";
      return "";
    },
  },
};
</script>
