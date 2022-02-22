<template>
  <router-link to="/homepage">Homepage</router-link> |
  <router-link to="/Kalkulator">Kalkulator</router-link>
  <div class="about">
    <kontaktform></kontaktform>
  </div>
</template>
<script>
import Kontaktform from "../components/Kontaktform.vue";
export default {
  components: {
    Kontaktform,
  },
};
</script>
