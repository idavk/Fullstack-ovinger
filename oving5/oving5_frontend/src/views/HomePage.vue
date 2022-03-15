<template>
  <router-link to="/Kalkulator">Kalkulator</router-link>
  <h3>Hei {{ username }}</h3>
</template>
<script>
export default {
  computed: {
    username() {
      return this.$store.state.login_username;
    },
  },
};
</script>


