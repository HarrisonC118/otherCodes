<template>
  <div></div>
</template>

<script>
import { ref, watchEffect } from "vue";
export default {
  setup() {
    const name = ref("hatcher");
    const age = ref(22);
    // 不用指定监听的属性
    watchEffect(() => {
      // 用到了name就监听name,没用到的age就不监听
      console.log("hatcher->", name.value);
    });
    return {
      name,
      age,
    };
  },
};
</script>

<style lang="scss"></style>
