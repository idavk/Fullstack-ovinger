<template>
  <div class="home">
    <kalkulatorDisplay></kalkulatorDisplay>
  </div>
</template>

<script>
// @ is an alias to /src
import KalkulatorDisplay from "@/components/KalkulatorDisplay.vue";

export default {
  name: "Kalkulator",
  components: {
    KalkulatorDisplay,
  },
};
</script>