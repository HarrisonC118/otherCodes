<template>
  <BookPriceVue></BookPriceVue>
  <button @click="increment({ offered: 0.1 })">增加折扣</button>
  <button @click="decrement({ offered: 0.1 })">减少折扣</button>
</template>

<script>
import BookPriceVue from "../components/BookPriceSetupGetters.vue";
import { mapMutations } from "vuex";
export default {
  components: { BookPriceVue },
  setup() {
    const mutations = mapMutations(["increment", "decrement"]);

    return { ...mutations };
  },
};
</script>

<style lang="scss"></style>
