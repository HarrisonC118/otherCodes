<template>
  <div>
    <h2>name:{{ name }} -- age:{{ age }}</h2>
  </div>
</template>

<script>
export default {
  name: 'component1',
  props: {
    name: {
      type: String,
      default: '',
    },
    age: {
      type: Number,
      default: 0,
    },
  },
};
</script>

<style scoped></style>
