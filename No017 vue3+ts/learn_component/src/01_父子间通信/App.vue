<template>
  <div>
    <Title v-bind="message"></Title>
  </div>
</template>

<script>
import Title from './Title.vue';
export default {
  components: {
    Title,
  },
  data() {
    return {
      message: {
        title: 'warning',
        content: '哇啦啦啦',
      },
    };
  },
};
</script>

<style lang="scss" scoped></style>
