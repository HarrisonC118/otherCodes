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
          <!-- { "year": 2021, "month": "NOVEMBER", "dayOfMonth": 12, "dayOfWeek": "FRIDAY", 
            "dayOfYear": 316, "monthValue": 11, "hour": 9, "minute": 4, "second": 22, "nano": 0, 
            "chronology": { "id": "ISO", "calendarType": "iso8601" } } -->
          {{ item.groupCreateTime.year }}年{{
            item.groupCreateTime.monthValue
          }}月{{ item.groupCreateTime.dayOfMonth }}日
          {{ item.groupCreateTime.hour }}:{{ item.groupCreateTime.minute }}:{{
            item.groupCreateTime.second
          }}
        </el-descriptions-item>
        <el-descriptions-item label="分组照片">
          <div class="imgContainer">
            <div class="myImg" v-for="item in item.imgList" :key="item.imgId">
              <el-image
                style="width: 300px; height: 300px"
                :src="
                  'http://localhost:8080/necoda_webapp_war/displayImg?imgUrl=' +
                  item.imgUrl
                "
                fit="contain"
              ></el-image>
            </div>
          </div>
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
        url: "http://localhost:8080/necoda_webapp_war/queryImgsById?userId=349ddf58bfd19e78293b2acd7c70a2ae",
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
  height: 1000px;
}
img {
  width: 800px;
}
.imgContainer {
  display: flex;
}
</style>
