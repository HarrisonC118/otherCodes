<template>
  <div id="nav">
    <!-- 当第一个router-link被选中后，会自动增加一个叫hello的class -->
    <router-link to="/home" v-slot="props" custom>
      <button @click="props.navigate">jumpToAbout</button>
      <p>{{ props.href }}</p>
    </router-link>
    |
    <router-link to="/about/user/hatcher/age/23">About</router-link>
    <button @click="jumpToAbout">jumpToAbout</button>
  </div>
  <router-view #="props">
    <transition name="changeComponent">
      <keep-alive>
        <component :is="props.Component"> </component>
      </keep-alive>
    </transition>
  </router-view>
</template>

<script>
import { useRouter } from "vue-router";
export default {
  setup() {
    const router = useRouter();

    const jumpToAbout = () => {
      // 在setup中控制跳转
      //   router.push("/about/user/hatcher/age/23");

      //   传递参数
      router.push({
        path: "/about",
        query: {
          user: "hatcher",
          age: 23,
        },
      });
    };
    return { jumpToAbout };
  },
};
</script>

<style lang="scss">
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
.changeComponent-enter-from,
.changeComponent-leave-to {
  opacity: 0;
}
.changeComponent-enter-to,
.changeComponent-leave-from {
  opacity: 1;
}
.changeComponent-enter-active,
.changeComponent-leave-active {
  transition: opacity 0.5s ease;
}
</style>
