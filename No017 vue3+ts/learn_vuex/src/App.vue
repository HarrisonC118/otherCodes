<template>
  <BookPriceVue></BookPriceVue>
</template>

<script>
import BookPriceVue from "./components/BookPrice.vue";
import { useState } from "./hooks";

export default {
  components: { BookPriceVue },
  setup() {
    const storeState = useState(["name", "age"]);
    return { ...storeState };
  },
};
</script>

<style lang="scss"></style>
