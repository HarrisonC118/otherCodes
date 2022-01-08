<template>
  <div>
    <!-- 定义插槽的名字 -->
    <slot name="one"></slot>
    <slot name="two"></slot>
    <slot :name="slotName"></slot>
  </div>
</template>

<script>
export default {
  props: {
    slotName: String,
  },
};
</script>

<style scoped></style>
