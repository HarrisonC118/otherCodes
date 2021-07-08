<template>
  <div>
    <div class="wrapper">
      <div class="wrapper__search">
        <div class="iconfont search__returnFont" @click="returnToHome">
          &#xe632;
        </div>
        <div class="search__content">
          <div class="iconfont content__searchFont">&#xe7ac;</div>
          <input
            class="content__input"
            type="text"
            placeholder="请输入商品名称搜索"
          />
        </div>
      </div>
      <ShopInfo :item="data.item" :hideBorder="true" />
    </div>
    <CommodityInfo />
    <Cart />
  </div>
</template>
<script>
import ShopInfo from '../../components/shopInfo.vue'
import { reactive } from 'vue'
import { get } from '../../utils/request.js'
// route用来获取参数值
import { useRoute, useRouter } from 'vue-router'
import CommodityInfo from './CommodityInfo.vue'
import Cart from './Cart.vue'
export default {
  name: 'Shop',
  components: {
    ShopInfo,
    CommodityInfo,
    Cart
  },
  setup (props, context) {
    const route = useRoute()
    const router = useRouter()
    const data = reactive({
      item: []
    })
    const getItemData = async () => {
      const result = await get(`/shop/${route.params.id}`)

      if (result?.errno === 0 && result?.data?.length !== 0) {
        data.item = result.data
      }
    }
    const returnToHome = () => {
      router.push({ name: 'Home' })
    }
    getItemData()
    return {
      data,
      getItemData,
      returnToHome
    }
  }
}
</script>
<style lang="scss" scoped>
.wrapper {
  padding: 0 0.18rem;
  .wrapper__search {
    display: flex;
    position: relative;
    justify-content: space-between;
    width: 100%;
    margin-top: 0.16rem;
    .search__returnFont {
      color: #b7b7b7;
      font-size: 0.3rem;
      margin-right: 0.16rem;
    }
    .search__content {
      position: relative;
      right: 0;
      top: 0;
      display: flex;
      justify-content: space-between;
      align-items: center;
      height: 0.32rem;
      background: #f5f5f5;
      width: 100%;
      border-radius: 0.5rem;
      .content__input {
        outline: none;
        font-family: PingFangSC-Regular;
        font-size: 14px;
        color: #333333;
        line-height: 16px;
        margin: 0 0.16rem 0 0;
        display: block;
        position: relative;
        top: 0;
        width: 100%;
        background: #f5f5f5;
        border-style: none;
        height: 0.18rem;
      }
      .content__searchFont {
        color: #b7b7b7;
        margin: 0 0.16rem;
        font-size: 0.2rem;
      }
    }
  }
}
</style>
