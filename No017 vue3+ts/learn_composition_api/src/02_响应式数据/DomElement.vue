<template>
  <div>
    <span ref="hello"></span>
  </div>
</template>

<script>
import { ref } from "vue";
export default {
  setup() {
    const hello = ref(null);
    return { hello };
  },
};
</script>
