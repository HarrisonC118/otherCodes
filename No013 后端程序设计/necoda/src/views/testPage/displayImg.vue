<template>
  <div class="displayImg">
    <el-button type="success" @click="test">test</el-button>
    所属用户：{{ info.userName }}
    <div class="list" v-for="item in info.groupList" :key="item.groupName">
      <el-descriptions
        :title="item.groupName"
        v-if="idLoad"
        direction="vertical"
        :column="2"
        border
      >
        <el-descriptions-item label="分组描述">
          {{ item.groupContent }}
        </el-descriptions-item>
        <el-descriptions-item label="分组创建时间">
          {{ item.strCreateTime }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from "vue";
import axios from "axios";

export default defineComponent({
  name: "DisplayImg",
  setup() {
    interface group {
      userName: string;
      groupList: [groupList];
    }
    interface groupList {
      groupName: string;
      groupContent: string;
      strCreateTime: string;
      imgList: [];
    }
    let info: group = reactive({
      userName: "",
      groupList: [
        {
          groupName: "",
          groupContent: "",
          strCreateTime: "",
          imgList: [],
        },
      ],
    });
    let idLoad = ref(false);
    function test(): void {
      axios({
        method: "get",
        url: "http://localhost:8080/necoda_webapp_war/queryImgsById?userId=21f6cc61f14d92fbc328592c0134276a",
      }).then((res) => {
        info.userName = res.data[0][0].userName;
        info.groupList = res.data[0][0].groupList;
        idLoad.value = true;
        console.log(info);
      });
    }
    return {
      test,
      info,
      idLoad,
    };
  },
});
</script>

<style lang="scss" scoped>
.displayImg {
  height: 500px;
}
img {
  width: 800px;
}
</style>
