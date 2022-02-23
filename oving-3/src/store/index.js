import { createStore } from "vuex";

export default createStore({
  state: {
    id: null,
    name: null,
    email: null,
  },
  mutations: {
    ADD_NAME(state, name) {
      state.name = name;
    },
    ADD_EMAIL(state, email) {
      state.email = email;
    },
  },
  actions: {},
  modules: {},
});
