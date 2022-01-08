<template>
  <div>
    <AppSub></AppSub>
  </div>
</template>

<script>
import AppSub from './App_sub.vue';
export default {
  // 普通写法
  //   provide: {
  //     HomeName: 'hatcher',
  //   },
  
  // 函数写法，可以通过this调用data中的数据
  provide() {
    return {
      HomeName: this.myname,
    };
  },
  components: {
    AppSub,
  },
  data() {
    return {
      myname: 'hatcher',
    };
  },
};
</script>

<style scoped></style>
