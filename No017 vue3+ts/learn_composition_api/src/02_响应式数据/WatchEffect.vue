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
    const stop = watchEffect((onInvalidate) => {
      onInvalidate(() => {
        // request.concel...
      });
    });
    // 停止监听
    stop();
    return {
      name,
      age,
    };
  },
};
</script>

<style lang="scss"></style>
