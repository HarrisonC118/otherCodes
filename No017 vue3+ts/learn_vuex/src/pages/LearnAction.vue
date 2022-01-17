<template>
  <BookPriceVue></BookPriceVue>
  <button @click="increment({ offered: 0.1 })">增加折扣</button>
  <button @click="decrement({ offered: 0.1 })">减少折扣</button>
  <br />
  <button @click="beginDownload">开始加载</button>
  <div>是否完成加载:{{ isDone }}</div>
</template>

<script>
import BookPriceVue from "../components/BookPriceSetupGetters.vue";
import { useStore } from "vuex";
import { ref } from "vue";
export default {
  components: { BookPriceVue },
  setup() {
    const store = useStore();
    const increment = () => {
      store.dispatch("increment");
    };
    const isDone = ref("未加载");
    const beginDownload = () => {
      isDone.value = "正在加载...";
      store
        .dispatch("increment")
        .then(() => {
          isDone.value = "加载完成";
        })
        .catch((err) => {
          isDone.value = err;
        });
    };
    return { increment, isDone, beginDownload };
  },
};
</script>

<style lang="scss"></style>
