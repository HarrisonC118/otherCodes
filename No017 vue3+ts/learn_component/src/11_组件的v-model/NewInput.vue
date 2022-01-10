<template>
  <div>
    <input v-model="inputName" />
    <input v-model="inputAge" />
  </div>
</template>

<script>
export default {
  props: {
    name: {
      type: String,
    },
    age: {
      type: Number,
    },
  },
  emits: ['update:name', 'update:age'],
  computed: {
    inputName: {
      set(value) {
        this.$emit('update:name', value);
      },
      get() {
        return this.name;
      },
    },
    inputAge: {
      set(value) {
        this.$emit('update:age', value);
      },
      get() {
        return this.age;
      },
    },
  },
  //   methods: {
  //     changeValue(event) {
  //       this.$emit('update:modelValue', event.target.value);
  //     },
  //   },
};
</script>

<style scoped></style>
