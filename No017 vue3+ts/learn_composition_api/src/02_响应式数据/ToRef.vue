<template>
  <div>响应式数据: {{ counter }}</div>
  <button @click="increament">increament</button>
</template>

<script>
import { reactive, toRef } from "vue";
export default {
  setup() {
    const user = reactive({
      name: "hatcher",
      age: 18,
    });
    const name = toRef(user, "name");
    return { name };
  },
};
</script>

<style lang="scss"></style>
