<template>
  <div>响应式数据: {{ state.counter }}</div>
  <button @click="increament">increament</button>
</template>

<script>
import { reactive } from "vue";
export default {
  setup() {
    let state = reactive({
      counter: 0,
    });
    const increament = () => {
      state.counter++;
    };
    return {
      state,
      increament,
    };
  },
};
</script>

<style lang="scss"></style>
