<template>
  <div class="about">
    <h2>username:{{ user }}</h2>
    <h2>userAge:{{ age }}</h2>
  </div>
</template>
<script>
import { useRoute } from "vue-router";
export default {
  setup() {
    const route = useRoute();
    const user = route.query.user;
    const age = route.query.age;
    return {
      user,
      age,
    };
  },
};
</script>
