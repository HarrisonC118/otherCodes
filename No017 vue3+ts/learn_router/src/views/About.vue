<template>
  <div class="about">
    <h2>username:{{ username }}</h2>
    <h2>userAge:{{ user_age }}</h2>
  </div>
</template>
<script>
import { useRoute } from "vue-router";
export default {
  setup() {
    const route = useRoute();
    const username = route.params.username;
    const user_age = route.params.user_age;
    return {
      username,
      user_age,
    };
  },
};
</script>
