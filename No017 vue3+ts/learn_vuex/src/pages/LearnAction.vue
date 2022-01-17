<template>
  <BookPriceVue></BookPriceVue>
  <button @click="increment({ offered: 0.1 })">增加折扣</button>
  <button @click="decrement({ offered: 0.1 })">减少折扣</button>
</template>

<script>
import BookPriceVue from "../components/BookPriceSetupGetters.vue";
import { useStore } from "vuex";
export default {
  components: { BookPriceVue },
  setup() {
    const store = useStore();
    const increment = () => {
      store.dispatch("increment");
    };

    return { increment };
  },
};
</script>

<style lang="scss"></style>
