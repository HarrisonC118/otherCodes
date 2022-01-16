<template>
  <div>{{ name }}</div>
  <div>{{ age }}</div>
</template>

<script>
import { useState } from "./hooks/useState";

export default {
  setup() {
    const storeState = useState(["name", "age"]);
    return { ...storeState };
  },
};
</script>

<style lang="scss"></style>
