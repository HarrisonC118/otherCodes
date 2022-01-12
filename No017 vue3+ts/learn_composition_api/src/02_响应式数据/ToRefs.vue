<template>
  <div>响应式数据: {{ counter }}</div>
  <button @click="increament">increament</button>
</template>

<script>
import { reactive, toRefs } from "vue";
export default {
  setup() {
    const user = reactive({
      name: "hatcher",
      age: 18,
    });
    // 一般解构，解构出来的内容不具备响应式的特性
    // const { name, age } = user;

    // 使用toRefs解构，解构出来的内容具备响应式的特性
    const { name, age } = toRefs(user);
    return { name, age };
  },
};
</script>

<style lang="scss"></style>
