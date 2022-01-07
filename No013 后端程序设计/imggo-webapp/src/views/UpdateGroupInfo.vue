<template>
  <div class="home">
    <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
      class="demo-ruleForm"
    >
      <el-form-item label="分组名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="分组介绍" prop="desc">
        <el-input v-model="ruleForm.desc" type="textarea" rows="6"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">修改</el-button>
        <el-button @click="resetForm">重写</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { ref, onMounted, reactive } from "vue";
import axios from "axios";
import { ElMessage } from "element-plus";
export default {
  name: "updateGroupInfo",
  setup(props, context) {
    console.log(props, context);
    const { attrs, emit } = context;
    const ruleFormRef = ref(null);
    console.log(attrs.groupInfo);
    onMounted(() => {
      resetForm();
    });
    const ruleForm = reactive({
      name: attrs.groupInfo.groupName,
      desc: attrs.groupInfo.groupContent,
    });
    const rules = {
      name: [
        {
          required: true,
          message: "分组名不能为空",
          trigger: "blur",
        },
        {
          min: 3,
          max: 20,
          message: "长度必须为3到20个字符",
          trigger: "blur",
        },
      ],
      desc: [
        {
          required: true,
          message: "描述内容不能为空",
          trigger: "blur",
        },
      ],
    };
    const submitForm = () => {
      ruleFormRef.value.validate((valid) => {
        if (valid) {
          axios({
            method: "post",
            url: "http://localhost:8088/hatcher/group/updateGroupInfo",
            data: {
              groupContent: ruleForm.desc,
              groupId: attrs.groupInfo.groupId,
              groupName: ruleForm.name,
            },
          }).then((res) => {
            if (res.data.status == 200) {
              ElMessage({
                message: res.data.data,
                type: "success",
              });
              emit("changeDialogVisible");
            } else {
              ElMessage({
                message: res.data.msg,
                type: "warning",
              });
            }
          });
        } else {
          console.log("格式错误");
          return false;
        }
      });
    };
    const resetForm = () => {
      ruleForm.name = attrs.groupInfo.groupName;
      ruleForm.desc = attrs.groupInfo.groupContent;
    };
    return { ruleForm, rules, submitForm, resetForm, ruleFormRef };
  },
};
</script>
<style scoped>
.home {
  padding: 10px 0;
}
</style>
