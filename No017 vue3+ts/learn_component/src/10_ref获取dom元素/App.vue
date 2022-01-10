<template>
  <div>
    <h2 ref="hello">你好</h2>
    <button @click="getDomElement">获取dom元素</button>
  </div>
</template>

<script>
export default {
  methods: {
    getDomElement() {
      console.log(this.$refs.hello);
    },
  },
};
</script>

<style scoped></style>
