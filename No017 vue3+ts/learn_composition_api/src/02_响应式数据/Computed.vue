<template>
  <div></div>
</template>

<script>
import { computed } from "vue";
export default {
  setup() {
    // 直接传入一个箭头函数
    const getAll = computed(() => "hello");
    // 传入对象，重写getter和settter
    const getAllB = computed({
      get: () => "hello",
      set(newValue) {
        console.log(newValue);
      },
    });
    // 更改计算属性的值
    getAllB.value = "wawawa";
    return {
      getAll,
      getAllB,
    };
  },
};
</script>

<style lang="scss"></style>
