<template>
  <div>
    <Suspense>
      <template v-slot:default>
        <Component1></Component1>
      </template>
      <template v-slot:fallback> 加载失败 </template>
    </Suspense>
  </div>
</template>

<script>
import { defineAsyncComponent } from 'vue';
const Component1 = defineAsyncComponent(() => import('./Component1.vue'));
export default {
  components: {
    Component1,
  },
};
</script>

<style scoped></style>
