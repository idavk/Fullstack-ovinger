import { createStore } from "vuex";

export default createStore({
  state: {
    user: {
      name: null,
      email: null,
      id: null,
    },
    event: {
      id: null,
      name: null,
      adress: null,
      username: null,
      email: null,
      phone: null,
    },
    messageStatus: null,
    login_username: null,
  },
  mutations: {
    set_user(state, value) {
      state.user = value;
    },
    set_status(state, value) {
      state.messageStatus = value;
    },
    set_login_username(state, value) {
      state.login_username = value;
    },
    set_event(state, value) {
      state.event = value;
    },
  },
  actions: {},
  modules: {},
});
