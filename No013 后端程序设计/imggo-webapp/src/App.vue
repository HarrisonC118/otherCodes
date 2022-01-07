<template>
  <el-menu
    :default-active="activeIndex2"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    :router="true"
    active-text-color="#ffd04b"
  >
    <el-menu-item :disabled="!isLogin" index="/display">图片展示</el-menu-item>
    <el-menu-item index="/regist">Regist</el-menu-item>
    <el-menu-item :disabled="isLogin" index="/login">Login</el-menu-item>
    <el-menu-item :disabled="!isLogin"
      ><span @click="changeUser">切换账号</span></el-menu-item
    >
    <el-menu-item :disabled="!isLogin" index="/addGroup">添加分组</el-menu-item>
    <el-menu-item index="#" disabled>{{ getUsername }}</el-menu-item>
  </el-menu>
  <router-view />
</template>

<script>
import { computed, ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
export default {
  setup() {
    const router = useRouter();
    const store = useStore();
    const activeIndex = ref("1");
    const activeIndex2 = ref("1");
    const getUsername = computed(() => {
      return store.state.username == ""
        ? "未登录"
        : "当前用户: " + store.state.username;
    });
    // 判断是否已经登录
    const isLogin = computed(() => {
      return store.state.username == "" ? false : true;
    });
    // 切换账号
    const changeUser = () => {
      router.push({
        name: "Login",
      });
      store.commit("changea", "");
    };
    return {
      activeIndex,
      activeIndex2,
      isLogin,
      changeUser,
      getUsername,
    };
  },
};
</script>

<style lang="scss">
.icon {
  width: 1em;
  height: 1em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
}

body {
  margin: 0;
  padding: 0;
  min-width: 1240px;
  background-color: #e7e5e5da;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
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
.el-menu-item .is-disabled {
  color: chocolate;
}
</style>
