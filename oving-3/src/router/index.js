import { createRouter, createWebHistory } from "vue-router";
import Kalkulator from "../views/Kalkulator.vue";
import LoginPage from "../views/LoginPage.vue"
import HomePage from "../views/HomePage.vue"
//import RegisterLogin from '../views/RegisterLogin.vue'

const routes = [
  {
    path: "/",
    name: "Kalkulator",
    component: Kalkulator,
  },
  {
    path: "/kontaktskjema",
    name: "Kontaktskjema",
    
    component: () =>
      import("../views/Kontaktskjema.vue"),
  },
  {
    path: "/loginpage",
    name: "Loginpage",
    component: LoginPage
  },
  {
    path: "/homepage",
    name: "Homepage",
    component: HomePage
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
