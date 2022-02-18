<template>
  <router-link to="/homepage">Homepage</router-link> |
  <router-link to="/Kontaktskjema">Kontaktskjema</router-link>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <kalkulatorDisplay></kalkulatorDisplay>
  </div>
</template>

<script>
// @ is an alias to /src
import KalkulatorDisplay from "@/components/KalkulatorDisplay.vue";

export default {
  name: "Kalkulator",
  components: {
    KalkulatorDisplay
  },
};
</script>
