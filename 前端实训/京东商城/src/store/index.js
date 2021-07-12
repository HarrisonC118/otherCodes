import { createStore } from 'vuex'

export default createStore({
  state: {
    cartList: {},
    pageIndex: 0
  },
  mutations: {
    changeDockerNum (state, param) {
      state.pageIndex = param
    },
    itemToCart (state, param) {
      const { shopId, itemId, itemInfo, num } = param
      let shopInfo = state.cartList[shopId] // 获取已经加到购物车中的商品
      if (!shopInfo) {
        shopInfo = {}
      }
      let itemInfos = shopInfo[itemId]
      if (!itemInfos) {
        itemInfos = itemInfo
        itemInfos.count = 0
      }
      itemInfos.count = itemInfos.count + num
      if (itemInfos.count <= 0) {
        itemInfos.count = 0
      }
      shopInfo[itemId] = itemInfos
      state.cartList[shopId] = shopInfo
      console.log(state.cartList)
    }
  },
  actions: {},
  modules: {}
})
