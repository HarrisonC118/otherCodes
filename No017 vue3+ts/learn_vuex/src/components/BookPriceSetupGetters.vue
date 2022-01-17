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
import { useState, useGetter } from "../hooks";
export default {
  setup() {
    const storeState = useState(["books"]);
    const storeGetter = useGetter({
      price: "totalPrice",
      discount: "currentDiscount",
    });
    return { ...storeState, ...storeGetter };
  },
};
</script>

<style lang="scss" scoped></style>
