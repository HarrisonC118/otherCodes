<template>
  <div>
    <input type="text" v-focus.aaa.bbb.ccc="'这是一个message'" />
  </div>
</template>

<script>
export default {
  // 局部自定义指令
  //   directives: {
  //     focus: {
  //       mounted(el) {
  //         el.focus();
  //       },
  //     },
  //   },
  setup() {},
};
</script>

<style lang="scss"></style>
