<template>
  <div class="wrapper">
    <ShopInfo :item="item" :hideBorder="true" />
  </div>
</template>
<script>
import ShopInfo from '../../components/shopInfo.vue'
export default {
  name: 'Shop',
  components: {
    ShopInfo
  },
  setup () {
    const item = {
      __id: 1,
      imgUrl: 'http://www.dell-lee.com/imgs/vue3/near.png',
      title: '沃尔玛',
      sales: 10000,
      expressLimit: 0,
      expressPrice: 5,
      discount: 'VIP尊享满89减4元运费券(每月3张)'
    }
    return {
      item
    }
  }
}
</script>
<style scoped lang="scss">
.wrapper {
  padding: 0 0.18rem;
}
</style>
