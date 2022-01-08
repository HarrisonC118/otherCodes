<template>
  <div>
    <AppSub></AppSub>
  </div>
</template>

<script>
import AppSub from './App_sub.vue';
export default {
  provide: {
    HomeName: 'hatcher',
  },
  components: {
    AppSub,
  },
  data() {
    return {};
  },
};
</script>

<style scoped></style>
