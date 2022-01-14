<template>
  <div>
    <input type="text" v-focus.aaa.bbb.ccc="'这是一个message'" />
  </div>
</template>

<script>
import { getCurrentInstance, onMounted } from "vue";
export default {
  setup() {
    const instance = getCurrentInstance();
    onMounted(() => {
      console.log(instance.appContext.config.globalProperties.$name);
    });
  },
};
</script>

<style lang="scss"></style>
