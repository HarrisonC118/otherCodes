<template>
  <div class="wrapper__nearby">
    <!-- 附近的店 -->
    <h3 class="nearby__title">附近店铺</h3>
    <div class="nearby__item" v-for="item in goods" :key="item.id">
      <img class="item__img" :src="item.imgUrl" alt />
      <div class="item__content">
        <div class="content__title">{{ item.title }}</div>
        <div class="content__tags">
          <span class="tags__tag" v-for="tag in item.tags" :key="tag">{{
            tag
          }}</span>
        </div>
        <div class="content__discount">{{ item.discount }}</div>
        <div class="content__br"></div>
      </div>
    </div>
  </div>
</template>
<script>
import { reactive } from 'vue'
export default {
  name: 'Nearby',
  setup (porps, context) {
    const goods = reactive([
      {
        id: 1,
        imgUrl: 'http://www.dell-lee.com/imgs/vue3/near.png',
        title: '沃尔玛',
        tags: ['月售1W+', '起送￥0', '基础运费￥5'],
        discount: 'VIP尊享满89减4元运费券(每月3张)'
      },
      {
        id: 2,
        imgUrl:
          'https://img30.360buyimg.com/vendersettle/s120x120_jfs/t1/150287/39/15578/19167/5fc0af1aE970c72c2/abb490ea30c4774c.jpg.dpg',
        title: '家乐福',
        tags: ['月售2W+', '起送￥2', '基础运费￥9'],
        discount: 'VIP尊享满1000减2元运费券(每月1张)'
      },
      {
        id: 3,
        imgUrl:
          'https://img30.360buyimg.com/vendersettle/s120x120_jfs/t1/74093/37/4166/6743/5d2552c2Eadfdfb5d/bb15c4748268940d.png',
        title: '711',
        tags: ['月售10W+', '起送￥2', '基础运费￥3'],
        discount: 'VIP尊享满50减30元运费券(每月6张)'
      },
      {
        id: 4,
        imgUrl: 'http://www.dell-lee.com/imgs/vue3/near.png',
        title: '沃尔玛',
        tags: ['月售1W+', '起送￥0', '基础运费￥5'],
        discount: 'VIP尊享满89减4元运费券(每月3张)'
      }
    ])
    return {
      goods
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
