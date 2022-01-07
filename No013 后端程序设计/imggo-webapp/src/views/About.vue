<template>
  <div class="about">
    <h1>{{ c }}</h1>
    <HomeVue />
  </div>
</template>
<script setup>
import { ref } from "vue";
import HomeVue from "./Home.vue";
const c = ref("not");
</script>
