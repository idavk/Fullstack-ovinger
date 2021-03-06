import { createRouter, createWebHistory } from "vue-router";
import Kalkulator from "../views/Kalkulator.vue";
import LoginPage from "../views/LoginPage.vue";
import HomePage from "../views/HomePage.vue";
import RegisterLogin from "../views/RegisterLogin.vue";
import store from "../store";

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
    path: "/kontaktskjema",
    name: "Kontaktskjema",

    component: () => import("../views/Kontaktskjema.vue"),
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
  {
    path: "/homepage",
    name: "Homepage",
    component: HomePage,
    meta: {
      requiresAuth: true,
    },
  },
  {
    path: "/registrering",
    name: "Registrering",
    component: RegisterLogin,
  },
];
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!store.state.login_username) {
      next({
        path: "/",
      });
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
