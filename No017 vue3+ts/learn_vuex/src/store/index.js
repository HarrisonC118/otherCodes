import { createStore } from "vuex";

export default createStore({
  state: {
    name: "hatcher",
    age: 22,
    books: [
      { id: 1, price: 10, num: 3 },
      { id: 2, price: 5, num: 5 },
      { id: 3, price: 3, num: 2 },
      { id: 4, price: 7, num: 2 },
      { id: 5, price: 1, num: 5 },
    ],
    discount: 0.7,
  },
  getters: {
    totalPrice(state, getters) {
      let totalPrice = 0;
      for (const books of state.books) {
        totalPrice += books.price * books.num;
      }
      return (totalPrice * getters.currentDiscount).toFixed(2);
    },
    currentDiscount(state) {
      return (state.discount * 0.9).toFixed(2);
    },
  },
  mutations: {
    increment(state, payload) {
      state.discount = state.discount - payload.offered;
    },
    decrement(state, payload) {
      state.discount = state.discount + payload.offered;
    },
  },
  actions: {},
  modules: {},
});
