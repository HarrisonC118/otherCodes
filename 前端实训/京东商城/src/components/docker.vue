<template>
  <div class="docker">
    <span
      :class="{
        docker__item: true,
        'docker__item--active': index == pageIndex
      }"
      v-for="(item, index) in dockerList"
      :key="item.icon"
    >
      <!-- BEM命名法 Block__item--modifier-->
      <div class="iconfont" v-html="item.icon"></div>
      <div class="docker__title">{{ item.text }}</div>
    </span>
  </div>
</template>
<style lang="scss" scoped>
// scoped可以防止这里写的css在其他地方也生效的问题
.docker {
  display: flex;
  position: absolute;
  box-sizing: border-box;
  // **no
  padding: 0 0.18rem;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 0.49rem;
  border-top: 1px solid #f1f1f1;
  .docker__item--active {
    color: #1fa4fc;
  }
}
.docker__item {
  flex: 1;
  text-align: center;
  .iconfont {
    margin: 0.07rem 0 0.02rem 0;
    font-size: 0.2rem;
  }
}
.docker__title {
  font-size: 0.2rem;
  // 横纵各缩放一半
  transform: scale(0.5, 0.5);
  // 设置缩放元素的位置：x轴放到中心，y轴放到顶部
  transform-origin: center top;
}
</style>
<script>
import { reactive, ref } from 'vue'

export default {
  name: 'docker',
  setup (props, context) {
    const dockerList = reactive([
      {
        icon: '&#xe601;',
        text: '首页'
      },
      {
        icon: '&#xe600;',
        text: '购物车'
      },
      {
        icon: '&#xe669;',
        text: '订单'
      },
      {
        icon: '&#xe620;',
        text: '我的'
      }
    ])
    const pageIndex = ref(0)
    return { dockerList, pageIndex }
  }
}
</script>
