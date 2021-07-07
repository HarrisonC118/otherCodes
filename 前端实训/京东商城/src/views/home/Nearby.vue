<template>
  <div class="wrapper__nearby">
    <!-- 附近的店 -->
    <h3 class="nearby__title">附近店铺</h3>

    <router-link
      class="nearby__item"
      v-for="item in goodLists.goodList"
      :key="item.__id"
      :to="`/shop/${item.__id}`"
    >
      <ShopInfo :item="item" hideBorder="False" />
    </router-link>

    <Toast v-show="isShowToast" :mes="mes" />
  </div>
</template>
<script>
import { reactive, ref } from 'vue'
import { get } from '../../utils/request.js'
import Toast from '../../components/toast.vue'
import ShopInfo from '../../components/shopInfo.vue'
export default {
  name: 'Nearby',
  components: {
    Toast,
    ShopInfo
  },
  setup (porps, context) {
    var mes = ref('')
    var isShowToast = ref(false)
    var goodLists = reactive({
      goodList: []
    })
    const handleRegister = async () => {
      try {
        const result = await get('/hotList')
        if (result?.errno === 0 && result?.data?.length !== 0) {
          goodLists.goodList = result.data
        } else {
          mes.value = '商品信息失败,请重试!'
          isShowToast.value = true
          setTimeout(() => {
            isShowToast.value = false
          }, 2000)
        }
      } catch (e) {
        mes.value = '连接服务器失败'
        isShowToast.value = true
        setTimeout(() => {
          isShowToast.value = false
        }, 2000)
      }
    }

    handleRegister()
    return {
      goodLists,
      isShowToast,
      mes
    }
  }
}
</script>

<style lang="scss" scoped>
.wrapper__nearby {
  .nearby__title {
    margin: 0.16rem 0 0.04rem 0;
    font-size: 0.18rem;
    color: #333;
    font-weight: normal;
  }
}
a {
  text-decoration: none;
}
</style>
