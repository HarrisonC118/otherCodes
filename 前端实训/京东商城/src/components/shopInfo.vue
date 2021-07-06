<template>
  <div class="shop">
    <img class="shop__img" :src="item.imgUrl" alt="" />
    <div
      :class="{
        shop__content: true,
        'shop__content--bordered': hideBorder ? false : true
      }"
    >
      <div class="content__title">{{ item.title }}</div>
      <div class="content__tags">
        <span class="tags__tag">月售:{{ item.sales }}</span>
        <span class="tags__tag">起送:{{ item.expressLimit }}</span>
        <span class="tags__tag">基础运费:{{ item.expressPrice }}</span>
      </div>
      <p class="content__discount">{{ item.discount }}</p>
    </div>
  </div>
</template>
<script>
export default {
  name: 'ShopInfo',
  props: ['item', 'hideBorder'],
  setup () {}
}
</script>

<style scoped lang="scss">
.shop {
  display: flex;
  padding-top: 0.12rem;
  .shop__img {
    margin-right: 0.16rem;
    width: 0.56rem;
    height: 0.56rem;
  }
  .shop__content {
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
      margin: 0.08rem 0 0 0;
      font-size: 0.13rem;
      color: #e93b3b;
      line-height: 0.18rem;
    }
  }
  .shop__content--bordered {
    border-bottom: 1px solid #f1f1f1;
  }
}
</style>
