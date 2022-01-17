<template>
  <h2>homeModule:{{ name }}</h2>
  <h2>getters:{{ getterName }}</h2>
  <button @click="changeName">mutationChangeName</button>
  <button @click="changeName2">actionChangeName</button>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const name = computed(() => store.state.home.name);
    // 指定命名空间的getter 通过中括号来指明getter 模块/getter名
    const getterName = store.getters["home/getName"];
    // 指定命名空间的mutation
    const changeName = () => {
      store.commit("home/changeName");
    };
    // 指定命名空间的action
    const changeName2 = () => {
      store.dispatch("home/changeName2");
    };
    return { name, getterName, changeName, changeName2 };
  },
};
</script>

<style scoped lang="scss"></style>
