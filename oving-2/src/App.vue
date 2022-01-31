<template>
  <div id="nav">
    <h1>Kalkulator</h1>
    <KalkulatorDisplay></KalkulatorDisplay>
  </div>

</template>

<script>
import KalkulatorDisplay from "@/components/KalkulatorDisplay";

export default {
  name: 'app',
  components: {
    KalkulatorDisplay
  }
}
</script>

<style>

#nav {
  text-align: center;
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
