<template>
  <div>
    <div v-for="(item, index) in slotArray" :key="item">
      <span><slot :item="item" :index="index"></slot></span>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    slotArray: {
      type: Array,
      default() {
        return [];
      },
    },
  },
};
</script>

<style scoped></style>
