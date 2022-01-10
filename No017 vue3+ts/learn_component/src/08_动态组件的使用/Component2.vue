<template>
  <div>
    <h2>name:{{ name }} -- age:{{ age }}</h2>
    <button @click="counterPlus">{{ counter }}</button>
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
  data() {
    return {
      counter: 0,
    };
  },
  methods: {
    counterPlus() {
      this.counter++;
    },
  },
};
</script>

<style scoped></style>
