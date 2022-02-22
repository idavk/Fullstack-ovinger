<template>
  <div class="container">
    <form @submit.prevent="onSubmit()">
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
        type="text"
      />

      <p class="textarea">
        <label for="review">Review:</label>
        <textarea v-model="review"></textarea>
      </p>

      <button class="button" type="submit">Submit</button>
    </form>
  </div>
</template>
<script>
import BaseInput from "./BaseInput.vue";
import { useField, useForm } from "vee-validate";
export default {
  components: { BaseInput },
  setup() {
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
    };
    useForm({
      validationSchema: validations,
    });
    const { value: email, errorMessage: emailError, handleChangeEmail, } = useField("email");
    const { value: name, errorMessage: nameError, handleChangeName,} = useField("name");
    return {
      onSubmit,
      email,
      emailError,
      name,
      nameError,
      handleChangeEmail,
      handleChangeName,
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
  min-height: 200px;
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