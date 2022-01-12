<template>
  <div></div>
</template>

<script>
import { provide, inject, ref, readonly } from "vue";
export default {
  setup() {
    const name = ref("hatcher");
    // 一般是不允许子组件直接修改值的，所以推荐加上readonly
    provide("name", readonly(name.value));
    
    // 从provide提取出需要的值
    const injectName = inject("name");
    return { name, injectName };
  },
};
</script>

<style lang="scss"></style>
