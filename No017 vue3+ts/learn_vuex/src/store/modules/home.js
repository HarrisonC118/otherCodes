const homeModule = {
  namespaced: true,
  state: {
    name: "hatcher",
  },
  getters: {
    getName(state) {
      return "--------getter:" + state.name;
    },
  },
  mutations: {
    changeName(state, payload) {
      console.log(payload);
      if (payload) {
        state.name = payload;
      } else {
        state.name = "mutationChange";
      }
    },
  },
  actions: {
    changeName2(context) {
      context.commit("changeName", "actionChange");
    },
  },
};
export default homeModule;
