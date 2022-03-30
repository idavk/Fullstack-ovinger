import { createStore } from "vuex";

export default createStore({
  state: {
    isFormSent: false,
    username: "",
    calculationLog: [],
    token: "",
  },
  mutations: {
    SET_NAME(state, name) {
      state.name = name;
    },
    SET_EMAIL(state, email) {
      state.email = email;
    },
    SET_USERNAME(state, username) {
      state.username = username;
      localStorage.username = username;
    },
    SET_CALCULATIONLOG(state, calculationLog) {
      state.calculationLog = calculationLog;
    },
    ADD_CALCULATION(state, calculation) {
      state.calculationLog.push(calculation);
    },
    ADD_PREVIOUS_CALCULATIONS(state, calculations) {
      state.calculationLog.push(calculations);
    },
    SET_TOKEN(state, token) {
      state.token = token;
      state.isLoggedIn = true;
    },
  },
  getters: {
    GET_TOKEN(state) {
      return state.token;
    },
    GET_USERNAME(state) {
      return state.username;
    },
    GET_CALCULATIONLOG(state) {
      return state.calculationLog;
    },
  },
  actions: {},
  modules: {},
});
