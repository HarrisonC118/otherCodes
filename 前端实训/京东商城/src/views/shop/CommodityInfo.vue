<template>
  <div class="content">
    <div class="content__classify">
      <!-- 左侧的分类栏 -->
      <div class="classify__item classify__item--active">全部商品</div>
      <div class="classify__item">秒杀</div>
      <div class="classify__item">新鲜水果</div>
      <div class="classify__item">休闲食品</div>
      <div class="classify__item">时令蔬菜</div>
      <div class="classify__item">肉蛋家禽</div>
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
          0
          <span class="number__plus">+</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { get } from '../../utils/request'
import { reactive } from 'vue'
export default {
  name: 'CommodityInfo',
  setup () {
    var commoditys = reactive({
      items: []
    })
    const getInfo = async () => {
      const result = await get('/commodityItems')
      if (result?.errno === 0 && result?.data?.length !== 0) {
        commoditys.items = result.data
      }
    }
    getInfo()
    return {
      commoditys
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
