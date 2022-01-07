<template>
  <div class="loginForm">
    <el-dialog
      v-model="dialogVisible"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      title="请登录"
      width="450px"
      :show-close="false"
    >
      <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        :rules="rules"
        class="demo-ruleForm"
      >
        <el-form-item label="账号" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">登录</el-button>
          <el-button @click="resetForm">重置</el-button>
          <el-button @click="toRegist">注册</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
import { ref, reactive, onMounted } from "vue";
import axios from "axios";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const router = useRouter();
    const ruleForm = reactive({
      username: "",
      password: "",
    });
    let rules = reactive({
      username: [
        {
          required: true,
          message: "请输入用户名",
          trigger: "blur",
        },
        {
          min: 3,
          max: 8,
          message: "长度为3到8位",
          trigger: "blur",
        },
      ],
      password: [
        {
          required: true,
          message: "请输入密码",
          trigger: "blur",
        },
        {
          min: 6,
          max: 12,
          message: "长度为6到12位",
          trigger: "blur",
        },
      ],
    });
    const ruleFormRef = ref(null);
    const resetForm = () => {
      ruleFormRef.value.resetFields();
    };
    onMounted(() => {
      console.log(ruleFormRef.value);
    });
    const submitForm = () => {
      ruleFormRef.value.validate((valid) => {
        if (valid) {
          axios({
            method: "post",
            url: "http://localhost:8088/hatcher/user/login",
            params: {
              username: ruleForm.username,
              password: ruleForm.password,
            },
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
          })
            .then((res) => {
              console.log(res.data);
              if (res.data.status == 200) {
                ElMessage({
                  message: res.data.data,
                  type: "success",
                });
                store.commit("changea", ruleForm.username);
                getUserId();
                dialogVisible.value = false;
                router.replace("/");
              } else {
                ElMessage({
                  message: res.data.msg,
                  type: "warning",
                });
              }
            })
            .catch(function (error) {
              console.log(error);
            });
        } else {
          return false;
        }
      });
    };
    // 根据用户的userName获取对用的用户id
    const getUserId = () => {
      axios({
        method: "post",
        url:
          "http://localhost:8088/hatcher/user/getIdByUsername/" +
          ruleForm.username,
      }).then((res) => {
        store.commit("changeUserId", res.data.data);
      });
    };

    const dialogVisible = ref(true);
    // 注册
    const toRegist = () => {
      router.push({
        name: "Regist",
      });
    };
    return {
      ruleForm,
      rules,
      resetForm,
      ruleFormRef,
      submitForm,
      dialogVisible,
      toRegist,
    };
  },
};
</script>
<style scoped lang="scss"></style>
