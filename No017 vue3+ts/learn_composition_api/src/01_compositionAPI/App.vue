<template>
  <div>
    <HomeVue message="hatcher" mes2="testMessage" @sendMessage="testMethod">
      <template #hatcher>
        <h1>哈哈哈哈</h1>
      </template>
    </HomeVue>
  </div>
</template>

<script>
import HomeVue from "./Home.vue";
export default {
  name: "App",
  components: { HomeVue },
  methods: {
    testMethod(message) {
      console.log("父组件方法接收" + message + "成功哦！");
    },
  },
};
</script>

<style lang="scss"></style>
