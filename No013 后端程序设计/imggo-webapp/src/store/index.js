import { createStore } from "vuex";

export default createStore({
  state: {
    username: "超级管理员",
    userId: "",
  },
  mutations: {
    changea(state, n) {
      console.log(n);
      state.username = n;
    },
    changeUserId(state, userId) {
      state.userId = userId;
    },
  },
  actions: {},
  modules: {},
});
