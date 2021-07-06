<template>
  <div class="shop">
    <img class="shop__img" :src="item.imgUrl" alt="" />
    <div class="shop__content">
      <div
        :class="{
          shop__content: true,
          'shop__content--bordered': hideBorder ? false : true
        }"
      ></div>
      <div class="content__title">{{ item.title }}</div>
      <div class="content__tags">
        <span class="tags__tag">月售:{{ item.sales }}</span>
        <span class="tags__tag">起送:{{ item.expressLimit }}</span>
        <span class="tags__tag">基础运费:{{ item.expressPrice }}</span>
      </div>
      <p class="content__discount">{{ item.slogan }}</p>
    </div>
  </div>
</template>
<style lang="sass" scoped>
.shop {
    display:flex;
    padding-top: .12rem;
}
</style>
