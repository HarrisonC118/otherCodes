<template>
  <div>
    <h2>name:{{ name }} -- age:{{ age }}</h2>
  </div>
</template>

<script>
export default {
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
