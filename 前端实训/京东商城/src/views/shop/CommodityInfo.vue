<template>
  <div class="content">
    <div class="content__classify">
      <div
        class="classify__item"
        v-for="item in classify.items"
        :key="item.__id"
        @click="getClassifyItems(item.tag)"
      >
        {{ item.title }}
      </div>
      <!-- 左侧的分类栏 -->
    </div>
    <div class="content__commodity">
      <!-- 右侧的具体商品 -->
      <div
        class="commodity__item"
        v-for="item in commoditys.items"
        :key="item.__id"
      >
        <img class="item__img" :src="item.imgUrl" alt="" />
        <div class="item__detail">
          <h4 class="detail__title">{{ item.name }}</h4>
          <p class="detail__sales">月售{{ item.sales }}件</p>
          <p class="detail__price">
            <span class="price__new">￥{{ item.price }}</span>
            <span class="price__old">￥{{ item.oldPrice }}</span>
          </p>
        </div>
        <div class="item__number">
          <span class="number__minus">-</span>
          {{ cartList?.[shopId]?.[item.__id]?.count || 0 }}
          <span class="number__plus">+</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { get } from '../../utils/request'
import { reactive } from 'vue'
import { useStore } from 'vuex'
import { useRoute } from 'vue-router'
export default {
  name: 'CommodityInfo',
  setup () {
    const store = useStore()
    const route = useRoute()
    var shopId = route.params.id
    var cartList = store.state.cartList
    var commoditys = reactive({
      items: []
    })
    // var commoditysNum = reactive({
    //   itemId: 0,
    //   itemNum: 0
    // })
    var classify = reactive({
      items: []
    })
    const getClassify = async () => {
      const resultClassify = await get('/classify')
      if (resultClassify?.errno === 0 && resultClassify?.data?.length !== 0) {
        classify.items = resultClassify.data
      }
    }
    getClassify()

    function getClassifyItems (tag) {
      getInfo(tag)
      console.log(tag)
    }
    const getInfo = async tag => {
      const result = await get(`/commodityItems/${tag}`)
      if (result?.errno === 0 && result?.data?.length !== 0) {
        commoditys.items = result.data
      }
      // for (var i = 0; i < commoditys.items.length; i++) {
      //   commoditys.items[i].id
      // }
    }
    return {
      commoditys,
      getClassifyItems,
      classify,
      cartList,
      shopId
    }
  }
}
</script>
<style lang="scss" scoped>
.content {
  width: 100%;
  position: absolute;
  top: 1.5rem;
  bottom: 0.5rem;
  padding: 0;
  overflow-y: auto;
  display: flex;
  align-items: stretch;
  .content__classify {
    overflow-y: auto;
    flex: 2;
    background-color: #f5f5f5;
    text-align: center;
    font-size: 0.14rem;
    line-height: 0.4rem;
    color: #333;
  }
  .classify__item--active {
    background-color: #fff;
  }
  .content__commodity {
    overflow-y: auto;
    .commodity__item {
      position: relative;
      display: flex;
      padding: 0.12rem 0;
      margin: 0 0.16rem;
      border-bottom: 0.01rem solid #f1f1f1;
      .item__detail {
        overflow: scroll;
        .detail__title {
          margin: 0;
          line-height: 0.2rem;
          font-size: 0.14rem;
          color: #333;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
        }
        .detail__sales {
          margin: 0.06rem 0;
          font-size: 0.12rem;
          color: #333;
        }
        .detail__price {
          margin: 0;
          line-height: 0.2rem;
          font-size: 0.14rem;
          color: #e93b3b;
          .price__new {
            font-size: 0.14rem;
          }
          .price__old {
            margin-left: 0.06rem;
            line-height: 0.2rem;
            font-size: 0.1rem;
            color: #999;
            text-decoration: line-through;
          }
        }
      }
      .item__img {
        margin-right: 0.16rem;
        width: 0.68rem;
        height: 0.68rem;
      }
      .item__number {
        position: absolute;
        display: flex;
        align-items: center;
        justify-content: space-between;
        right: 0;
        bottom: 0.12rem;
        width: 0.8rem;
        font-size: 0.14rem;
        .number__minus,
        .number__plus {
          display: inline-block;
          width: 0.2rem;
          height: 0.2rem;
          line-height: 0.16rem;
          border-radius: 50%;
          text-align: center;
          font-size: 0.25rem;
        }
        .number__minus {
          border: 0.02rem solid #666;
          color: #666;
        }
        .number__plus {
          background: #0091ff;
          border: 0.02rem solid #0091ff;
          color: #fff;
        }
      }
    }
    flex: 8;
  }
}
</style>
