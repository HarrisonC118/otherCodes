<template>
  <div>
    <button @click="increment()">+1</button>
    <button @click="decrement()">-1</button>
    <button @click="notice()">notice</button>
  </div>
</template>

<script>
export default {
  // 告诉vue一会儿要触发父组件的什么事件
  emits: ['add', 'sub', 'alert'],
  data() {
    return {
      message: 'hello world!',
    };
  },
  methods: {
    increment() {
      this.$emit('add');
    },
    decrement() {
      this.$emit('sub');
    },
    notice() {
      this.$emit('alert', this.message);
    },
  },
};
</script>

<style lang="scss" scoped></style>
