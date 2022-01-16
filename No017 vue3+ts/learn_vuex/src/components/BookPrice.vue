<template>
  <div>当前折扣:{{ discount }}</div>
  <div>总价格:{{ price }}</div>
  <div>
    <div v-for="item in books" :key="item.id">
      <span>id:{{ item.id }}&nbsp;</span>
      <span>price:{{ item.price }}&nbsp;</span>
      <span>num:{{ item.num }}</span>
    </div>
  </div>
</template>

<script>
import { useStore } from "vuex";
import { useState } from "../hooks/useState";
export default {
  setup() {
    const store = useStore();
    const storeState = useState(["books"]);
    const price = store.getters.totalPrice;
    const discount = store.getters.currentDiscount;
    return { price, ...storeState, discount };
  },
};
</script>

<style lang="scss" scoped></style>
