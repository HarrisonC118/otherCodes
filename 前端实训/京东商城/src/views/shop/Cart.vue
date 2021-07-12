<template>
  <div class="cart">
    <div class="cart__check">
      <div class="check__icon">
        <img
          class="icon__img"
          src="http://www.dell-lee.com/imgs/vue3/basket.png"
          alt=""
        />
        <div class="icon__tag">{{ total.count }}</div>
      </div>
      <div class="check__info">
        <span>总计:</span>
        <span class="info__price">&yen;{{ total.money }}</span>
      </div>
      <div class="check__btn">去结算</div>
    </div>
  </div>
</template>
<script>
import { useStore } from 'vuex'
import { useRoute } from 'vue-router'
import { computed } from 'vue'
export default {
  name: 'Cart',
  setup () {
    const store = useStore()
    const route = useRoute()
    const shopId = route.params.id
    const cartList = store.state.cartList

    const total = computed(() => {
      const itemList = cartList[shopId]
      let count = 0
      let money = 0
      if (itemList) {
        for (const i in itemList) {
          const item = itemList[i]
          count += item.count
          money += item.count * item.price
        }
      }
      return { count, money }
    })
    return {
      total
    }
  }
}
</script>
<style scoped lang="scss">
.cart {
  position: absolute;
  left: 0;
  right: 0;
  bottom: 0;
}
.cart__check {
  display: flex;
  height: 0.49rem;
  border-top: 0.01rem solid #f1f1f1;
  line-height: 0.49rem;
  .check__icon {
    position: relative;
    width: 0.84rem;
    .icon__img {
      display: block;
      margin: 0.12rem auto;
      width: 0.3rem;
      height: 0.28rem;
    }
    .icon__tag {
      position: absolute;
      right: 0.2rem;
      top: 0.04rem;
      width: 0.2rem;
      height: 0.2rem;
      line-height: 0.2rem;
      background-color: #e93b3b;
      border-radius: 50%;
      font-size: 0.12rem;
      text-align: center;
      color: #fff;
      // 缩放50% 中心点为左中
      transform: scale(0.5);
      transform: left center;
    }
  }
  .check__info {
    flex: 1;
    color: #333;
    font-size: 0.12rem;
    .info__price {
      line-height: 0.49rem;
      color: #e93b3b;
      font-size: 0.18rem;
    }
  }
  .check__btn {
    background-color: #4fb0f9;
    width: 0.98rem;
    text-align: center;
    color: #fff;
    font-size: 0.14rem;
  }
}
</style>
