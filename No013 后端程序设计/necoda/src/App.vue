<template>
  <div id="nav">
    <router-view />
    <Login :infos="backgrounds"></Login>
  </div>
</template>

<script lang="ts">
import { reactive } from "vue";
import Login from "./views/login/login.vue";
import { TeleObj } from "./typings/login";
export default {
  components: {
    Login,
  },
  setup(): unknown {
    const backgrounds: TeleObj = reactive({
      title: "哈哈哈",
      color: "red",
    });
    return {
      backgrounds,
    };
  },
};
</script>

<style lang="scss" scoped>
body {
  padding: 0;
  margin: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
