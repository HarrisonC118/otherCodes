<template>
  <div>
    <input v-model="value" />
  </div>
</template>

<script>
export default {
  props: {
    modelValue: {
      type: String,
    },
  },
  emits: ['update:modelValue'],
  computed: {
    value: {
      set(value) {
        this.$emit('update:modelValue', value);
      },
      get() {
        return this.modelValue;
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
