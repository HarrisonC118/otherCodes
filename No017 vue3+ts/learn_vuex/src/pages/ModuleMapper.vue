<template>
  <h2>homeModule:{{ name }}</h2>
  <h2>getters:{{ getterName }}</h2>
  <button @click="changeName">mutationChangeName</button>
  <button @click="changeName2">actionChangeName</button>
</template>

<script>
import { computed } from "vue";
import { useState, useGetter, useMutation, useAction } from "../hooks";
export default {
  setup() {
    const state = useState("home", ["name"]);
    const getters = useGetter("home", ["getName"]);
    const mutations = useMutation("home", ["changeName"]);
    const actions = useAction("home", "changeName2");
    return { ...state, ...getters, ...mutations, ...actions };
  },
};
</script>

<style scoped lang="scss"></style>
