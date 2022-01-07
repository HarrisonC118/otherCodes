<template>
  <div>
    <h2>当前计数: {{ counter }}</h2>
    <!-- 给子组件添加了三个可以触发的方法名字，分别是add,sub,tips -->
    <!-- 当子组件触发了定义好的方法(add)，就会同时触发对应绑定的父组件中的方法(addOne) -->
    <!-- 如果子组件触发方法(alert)的时候带参数，那就可以在父组件的方法中(tips)接收这个参数 -->
    <CounterOperationVue
      @add="addOne"
      @sub="subOne"
      @alert="tips"
    ></CounterOperationVue>
  </div>
</template>

<script>
import CounterOperationVue from "./CounterOperation.vue";
export default {
  components: {
    CounterOperationVue,
  },
  data() {
    return {
      counter: 0,
    };
  },
  methods: {
    addOne() {
      this.counter++;
    },
    // 接收不带参数的触发方法
    subOne() {
      this.counter--;
    },
    // 接收带参数的触发方法
    tips(message) {
      console.log(message);
    },
  },
};
</script>

<style scoped></style>
