<template>
  <div>响应式数据: {{ counter }}</div>
  <button @click="increament">increament</button>
</template>

<script>
import { ref } from "vue";
export default {
  setup() {
    let counter = ref(0);
    const increament = () => {
      counter.value++;
    };
    return {
      counter,
      increament,
    };
  },
};
</script>