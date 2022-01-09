<template>
  <div>
    <button v-for="item in componentsList" :key="item" @click="changeCurrentComponentName(item)">
      display {{ item }}
    </button>
    <!-- is属性可以规定到底使用哪个组件，里面的内容就是下面定义的components中的内容 -->
    <keep-alive>
      <component :is="currentComponentName" name="hatcher" :age="18"></component>
    </keep-alive>
  </div>
</template>

<script>
import Component_1 from './Component1.vue';
import Component_2 from './Component2.vue';
export default {
  components: { Component_1, Component_2 },
  data() {
    return {
      componentsList: ['Component_1', 'Component_2'],
      currentComponentName: '',
    };
  },
  methods: {
    changeCurrentComponentName(item) {
      this.currentComponentName = item;
    },
  },
};
</script>

<style scoped></style>
