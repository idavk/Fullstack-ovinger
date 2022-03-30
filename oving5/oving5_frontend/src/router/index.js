import { createRouter, createWebHistory } from "vue-router";
import Kalkulator from "../views/Kalkulator.vue";
import LoginPage from "../views/LoginPage.vue";

const routes = [
  {
    path: "/Kalkulator",
    name: "Kalkulator",
    component: Kalkulator,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/",
    redirect: "/loginpage",
  },
  {
    path: "/loginpage",
    name: "Loginpage",
    component: LoginPage,
  },
];
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
