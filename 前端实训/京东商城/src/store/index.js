import { createStore } from 'vuex'

export default createStore({
  state: {
    pageIndex: 0
  },
  mutations: {
    changeDockerNum (state, param) {
      state.pageIndex = param
    }
  },
  actions: {},
  modules: {}
})
