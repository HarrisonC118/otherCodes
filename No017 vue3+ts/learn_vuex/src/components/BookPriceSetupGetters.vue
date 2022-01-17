<template>
  <div>当前折扣:{{ curr_discount }}</div>
  <div>总价格:{{ price }}</div>
  <div>discount:{{ discount }}</div>
  <div>
    <div v-for="item in books" :key="item.id">
      <span>id:{{ item.id }}&nbsp;</span>
      <span>price:{{ item.price }}&nbsp;</span>
      <span>num:{{ item.num }}</span>
    </div>
  </div>
</template>

<script>
import { useState, useGetter } from "../hooks";
export default {
  setup() {
    const storeState = useState(["books", "discount"]);
    const storeGetter = useGetter({
      price: "totalPrice",
      curr_discount: "currentDiscount",
    });
    return { ...storeState, ...storeGetter };
  },
};
</script>

<style lang="scss" scoped></style>
