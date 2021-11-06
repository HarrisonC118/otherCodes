<template>
  <div class="hello">
    <div class="username">
      <div class="title">用户名：</div>
      <el-input v-model="userInfo.username" placeholder="Please input" />
    </div>
    <div class="password">
      <div class="title">密码：</div>
      <el-input v-model="userInfo.password" placeholder="Please input" />
    </div>
    <el-button type="success">Success</el-button>
  </div>
</template>
<script lang="ts">
import { defineComponent, reactive } from "vue";
export default defineComponent({
  setup() {
    const userInfo = reactive({
      username: "",
      password: "",
    });
    return { userInfo };
  },
});
</script>
<style scoped lang="scss">
.hello {
  width: 500px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
}
.title {
  width: 100px;
}
.username {
  display: flex;
}
.password {
  display: flex;
}
</style>
