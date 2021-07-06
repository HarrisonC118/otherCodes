<template>
  <div class="wrapper__nearby">
    <!-- 附近的店 -->
    <h3 class="nearby__title">附近店铺</h3>
    <div
      class="nearby__item"
      v-for="item in goodLists.goodList"
      :key="item.__id"
    >
      <img class="item__img" :src="item.imgUrl" alt />
      <div class="item__content">
        <div class="content__title">{{ item.title }}</div>
        <div class="content__tags">
          <span class="tags__tag"> 月售:{{ item.sales }} </span>
          <span class="tags__tag"> 起送:{{ item.expressLimit }} </span>
          <span class="tags__tag"> 基础运费:{{ item.expressPrice }} </span>
        </div>
        <div class="content__discount">{{ item.discount }}</div>
        <div class="content__br"></div>
      </div>
    </div>
    <Toast v-show="isShowToast" :mes="mes" />
  </div>
</template>
<script>
import { reactive, ref } from 'vue'
import { get } from '../../utils/request.js'
import Toast from '../../components/toast.vue'
export default {
  name: 'Nearby',
  components: {
    Toast
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
  .nearby__item {
    display: flex;
    padding-top: 0.12rem;
    .item__img {
      margin-right: 0.16rem;
      width: 0.56rem;
      height: 0.56rem;
    }
    .item__content {
      // flex: 1;
      padding-bottom: 0.12rem;
      border-bottom: 1px solid #f1f1f1;
      margin: 0.08rem;
      .content__title {
        color: #333;
        font-size: 0.16rem;
        line-height: 0.22rem;
      }
      .content__tags {
        font-size: 0.13rem;
        // margin: 0.08rem 0;
        margin-top: 0.08rem;
        line-height: 0.18rem;
        .tags__tag {
          margin-right: 0.16rem;
        }
      }
      .content__discount {
        margin: 0.08rem 0 0;
        font-size: 0.13rem;
        color: #e93b3b;
        line-height: 0.18rem;
      }
    }
  }
}
</style>
