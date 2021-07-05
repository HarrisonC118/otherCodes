<template>
  <div class="div">
    <div class="wrapper__position">
      <span class="iconfont position__locationFont">&#xe602;</span>
      天津城建大学软件工程
      <span class="iconfont position__messageFont">&#xe7ab;</span>
    </div>
    <div class="wrapper__search">
      <span class="iconfont search__searchFont">&#xe7ac;</span>
      山姆会员商店优惠商品
    </div>
    <div class="wrapper__banner">
      <img
        src="//img.alicdn.com/imgextra/i2/2206686532409/O1CN01tTgj8M1TfMoQ2tuRB_!!2206686532409-0-lubanimage.jpg"
        alt
      />
    </div>
    <div class="wrapper__navigation">
      <div
        class="navigation__item"
        v-for="items in iconsList"
        :key="items.imgName"
      >
        <img
          class="item__img"
          :src="`http://www.dell-lee.com/imgs/vue3/${items.imgName}.png`"
          alt
        />
        <p class="item__name">{{ items.name }}</p>
      </div>
    </div>
    <div class="wrapper__gap"></div>
  </div>
</template>

<script>
import { reactive } from 'vue'
export default {
  name: 'StaticPart',
  setup (props, context) {
    const iconsList = reactive([
      {
        imgName: '超市',
        name: '超市便利'
      },
      {
        imgName: '菜市场',
        name: '菜市场'
      },
      {
        imgName: '水果店',
        name: '水果店'
      },
      {
        imgName: '鲜花',
        name: '鲜花绿植'
      },
      {
        imgName: '医药健康',
        name: '医药健康'
      },
      {
        imgName: '家居',
        name: '家居时尚'
      },
      {
        imgName: '蛋糕',
        name: '烘焙蛋糕'
      },
      {
        imgName: '签到',
        name: '签到'
      },
      {
        imgName: '大牌免运',
        name: '大牌免运'
      },
      {
        imgName: '红包',
        name: '红包套餐'
      }
    ])
    return {
      iconsList
    }
  }
}
</script>
<style lang="scss" scoped>
.wrapper__position {
  position: relative;
  padding: 0.16rem 0.24rem 0.16rem 0;
  line-height: 0.22rem;
  font-size: 0.16rem;
  // 设置文字溢出时的省略号
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  .position__locationFont {
    position: relative;
    font-size: 0.2rem;
    top: 0.01rem;
  }
  .position__messageFont {
    position: absolute;
    right: 0;
    font-size: 0.2rem;
    top: 0.17rem;
  }
}
.wrapper__search {
  line-height: 0.32rem;
  background-color: #f5f5f5;
  color: #b7b7b7;
  font-size: 0.14rem;
  border-radius: 0.16rem;
  .search__searchFont {
    font-size: 0.2rem;
    display: inline-block;
    position: relative;
    top: 0.04rem;
    padding: 0 0.08rem 0 0.16rem;
  }
}
.wrapper__banner {
  margin-top: 0.12rem;
  // 解决图片加载抖动问题
  height: 0;
  overflow: hidden;
  // 百分比数值：图片的 高/宽
  padding-bottom: 32%;
  img {
    width: 100%;
  }
}
.wrapper__navigation {
  margin-top: 0.16rem;
  display: flex;
  flex-wrap: wrap;
  .navigation__item {
    width: 20%;
    .item__img {
      display: block;
      width: 0.4rem;
      height: 0.4rem;
      margin: 0 auto;
    }
    .item__name {
      text-align: center;
      color: #333;
      margin: 0.06rem 0 0.16rem 0;
      font-size: 0.06rem;
    }
  }
}
.wrapper__gap {
  height: 0.1rem;
  background-color: #f1f1f1;
  margin: 0 -0.18rem;
}
</style>
