<template>
  <div class="container">
    <form @submit.prevent="onSubmit">
      <BaseInput
        class="input"
        v-model="name"
        :error="nameError"
        label="Name"
        type="text"
      />

      <BaseInput
        class="input"
        v-model="email"
        :error="emailError"
        label="Email "
        type="email"
      />

      <BaseInput
        class="input"
        v-model="message"
        :error="messageError"
        label="Feedback "
        type="text"
      />

      <button class="button" type="submit" @click="onSubmit">Submit</button>
    </form>
  </div>
</template>
<script>
import BaseInput from "./BaseInput.vue";
import { useField, useForm } from "vee-validate";
import { useStore } from "vuex";
import { v4 as uuidv4 } from "uuid";
export default {
  components: { BaseInput },
  data() {
    return {
      user: ["id", "name", "email", "message"]
    }
  },
  setup() {
    const store = useStore();
    function onSubmit() {
      console.log("Reviewer: ", this.name, this.email);
    }
    let validations = {
      email: (value) => {
        if (!value) return "This field is required";
        const regex =
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!regex.test(String(value).toLowerCase())) {
          return "Please enter a valid email address";
        }
        return true;
      },
      name: (value) => {
        const requiredMessage = "This field is required";
        if (value === undefined || value === null) return requiredMessage;
        if (!String(value).length) return requiredMessage;
        const validName = /^[a-åA-Å]+$/;
        if (!validName.test(String(value).toLowerCase())) {
          return "Please enter a valid name";
        }
        return true;
      },
      message: (value) => {
        if (!value) return "This field is required";
        if(!String(value).length) return "This field is required"
      }
    };
    useForm({
      validationSchema: validations,
    });
    const { value: email, errorMessage: emailError, handleChangeEmail, } = useField("email");
    const { value: name, errorMessage: nameError, handleChangeName,} = useField("name");
    const { value: message, errorMessage: messageError, handleChangeMessage} = useField("message");

    name.value = store.state.name;
    email.value = store.state.email;

    return {
      onSubmit,
      email,
      emailError,
      name,
      nameError,
      handleChangeEmail,
      handleChangeName,
      message,
      handleChangeMessage,
      messageError
    };
  },
};
</script>
<style scoped>
.container {
  margin-inline-start: 550px;
  border: solid black;
  padding: 4px;
  background-color: whitesmoke;
  align-self: auto;
  max-width: 250px;
  min-height: 400px;
  color: black;
}
#name {
  margin-inline-start: 30px;
  min-width: 50px;
  max-width: 5px;
}
#epost {
  margin-inline-start: 30px;
  min-width: 50px;
  max-width: 5px;
}
#review {
  max-width: 50px;
  max-width: 5px;
  margin-inline-start: 30px;
}
</style>