import { createStore } from "vuex";
import homeModule from "./modules/home";
export default createStore({
  state: {
    rootState: 1,
  },
  getters: {},
  mutations: {},
  actions: {},
  modules: { home: homeModule },
});
