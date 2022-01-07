<template>
  <div class="loginForm">
    <el-dialog
      ref="regist_dialog"
      v-model="dialogVisible"
      title="请注册"
      width="450px"
      :show-close="false"
    >
      <el-form
        ref="ruleFormRef"
        :model="ruleForm"
        :rules="rules"
        class="demo-ruleForm"
      >
        <el-form-item
          label="账号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
          prop="username"
        >
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item
          label="密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
          prop="password"
        >
          <el-input type="password" v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirm_password">
          <el-input
            type="password"
            v-model="ruleForm.confirm_password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >注册</el-button
          >
          <el-button @click="resetForm">重置</el-button>
          <el-button @click="toLogin">返回登录</el-button>
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
export default {
  setup() {
    onMounted(() => {
      console.log(ruleFormRef.value);
      console.log(regist_dialog.value);
    });
    const regist_dialog = ref(null);
    // 注册的表单
    const ruleForm = reactive({
      username: "",
      password: "",
      confirm_password: "",
    });
    // 确认密码的检测规则
    const validatePass2 = (rule, value, callback) => {
      if (value !== ruleForm.password) {
        callback(new Error("与密码不匹配"));
      } else {
        callback();
      }
    };
    // 表单的检测规则
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
      confirm_password: [
        {
          validator: validatePass2,
          required: true,
          trigger: "blur",
        },
      ],
    });
    // 表达的dom元素
    const ruleFormRef = ref(null);
    // 重置表单
    const resetForm = () => {
      ruleFormRef.value.resetFields();
    };
    const dialogVisible = ref(true);

    // 返回登录界面
    const router = useRouter();
    const toLogin = () => {
      router.push({ name: "Login" });
    };

    // 注册
    const submitForm = () => {
      ruleFormRef.value.validate((valid) => {
        if (valid) {
          axios({
            method: "post",
            url: "http://localhost:8088/hatcher/user/register",
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
                toLogin();
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
    return {
      toLogin,
      ruleForm,
      rules,
      resetForm,
      ruleFormRef,
      submitForm,
      dialogVisible,
      regist_dialog,
    };
  },
};
</script>
<style scoped>
a {
  text-decoration: none;
  color: black;
}
</style>
