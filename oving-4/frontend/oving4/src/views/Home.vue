<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <kalkulator-display />
  </div>
</template>

<script>
// @ is an alias to /src
import KalkulatorDisplay from "@/components/KalkulatorDisplay.vue";

export default {
  name: "Home",
  components: {
    KalkulatorDisplay,
  },
};
</script>
