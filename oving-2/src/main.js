import { createApp } from "vue";
import App from "./App.vue";
import KalkulatorDisplay from "./components/KalkulatorDisplay";
import store from "./store";

createApp(App).use(store).use(KalkulatorDisplay).mount("#app");
