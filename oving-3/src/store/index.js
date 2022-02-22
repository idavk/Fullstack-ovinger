import { createStore } from "vuex";

export default createStore({
  state: {
    name: '',
    email: '',
    reviews: []
  },
  mutations: {
    ADD_REVIE(state, review) {
      state.reviews.push(review)
    }
  },
  actions: {},
  modules: {},
});
