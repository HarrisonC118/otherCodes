<template>
  <div class="gourpContainer">
    <template v-for="group in info.value?.groupList" :key="group.groupId">
      <el-card :body-style="{ padding: '0px' }">
        <div class="groupTitle">
          <div class="groupName">{{ group.groupName }}</div>
          <svg
            class="icon"
            aria-hidden="true"
            @click="updateGroupInfo(group.groupId)"
          >
            <use xlink:href="#icon-setting"></use>
          </svg>
        </div>
        <el-divider></el-divider>
        <div class="groupContent">
          <!-- <div class="title">{{}}</div> -->
          <div class="content">
            {{ group.groupContent }}
          </div>
          <span class="time">创建时间: {{ group.groupCreateTime }}</span>
        </div>
      </el-card>
      <div class="pics">
        <el-space wrap>
          <tempalte v-for="img in group?.imgList" :key="img.imgId">
            <div class="imgBox">
              <el-image
                :style="imgStyle"
                :preview-src-list="getImgUrl(img.imgUrl)"
                :hide-on-click-modal="true"
                :initial-index="0"
                :src="getImgUrl(img.imgUrl)[0]"
                fit="cover"
              ></el-image>
              <el-icon
                class="imgIcon"
                v-if="isShowDeleteButton"
                @click="deletePic(img.imgId)"
              >
                <close-bold />
              </el-icon>
            </div>
          </tempalte>
          <!-- <div class="uploadImg" @click="addImg(group.groupId)">上传图片</div> -->
          <el-upload
            class="avatar-uploader"
            action="http://localhost:8088/hatcher/img/addImg"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :data="{ userId: userId, groupId: group.groupId }"
            name="multipartFiles"
          >
            <el-icon class="avatar-uploader-icon"><plus /></el-icon>
          </el-upload>
          <el-icon class="avatar-uploader-icon" @click="changeDeleteButton"
            ><close-bold
          /></el-icon>
        </el-space>
      </div>
    </template>
  </div>
  <el-dialog v-model="isShowGroupDialog" title="修改分组信息" width="50%">
    <UpdateGroupInfoVue
      :groupInfo="currentGroupInfo"
      @changeDialogVisible="changeDialogVisible"
      v-if="isShowGroupDialog"
    ></UpdateGroupInfoVue>
  </el-dialog>
</template>

<script>
import { ref, onMounted, reactive, toRefs } from "vue";
import axios from "axios";
import { ElMessage } from "element-plus";
import { useStore } from "vuex";
import { Plus, CloseBold } from "@element-plus/icons-vue";
import UpdateGroupInfoVue from "../views/UpdateGroupInfo.vue";
export default {
  name: "displayPic",
  components: {
    Plus,
    CloseBold,
    UpdateGroupInfoVue,
  },
  setup() {
    const store = useStore();
    const info = reactive({});
    // 获取数据
    onMounted(() => {
      getInfos();
    });
    const getInfos = async () => {
      await axios({
        method: "get",
        url: "http://localhost:8088/hatcher/img/getImg/" + store.state.userId,
      }).then((res) => {
        info.value = res.data.data[0];
        console.log(info.value);
      });
    };
    const { userId } = toRefs(store.state);
    const srcList = ref([
      "https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg",
    ]);
    const imgStyle = {
      width: "334px",
      height: "185px",
      borderRadius: "10px",
      margin: "15px",
    };
    // 是否显示更改分组信息的页面
    let isShowGroupDialog = ref(false);
    const changeDialogVisible = () => {
      isShowGroupDialog.value = !isShowGroupDialog.value;
      getInfos();
    };
    // 更改分组信息
    const currentGroupInfo = reactive({
      groupName: "",
      groupContent: "",
      groupId: "",
    });
    const updateGroupInfo = (groupId) => {
      axios({
        method: "get",
        url: "http://localhost:8088/hatcher/group/getGroupInfo/" + groupId,
      }).then((res) => {
        currentGroupInfo.groupName = res.data.data.groupName;
        currentGroupInfo.groupContent = res.data.data.groupContent;
        currentGroupInfo.groupId = res.data.data.groupId;
        changeDialogVisible();
      });
    };
    // 拼接图片地址
    const getImgUrl = (img) => {
      return ["http://localhost:8088/hatcher/" + img];
    };
    // 添加图片
    const addImg = (groupId) => {
      console.log(groupId);
    };
    const imageUrl = ref("");
    const handleAvatarSuccess = (res, file) => {
      getInfos();
      imageUrl.value = URL.createObjectURL(file.raw);
    };
    // 是否展示删除按钮
    const isShowDeleteButton = ref(false);
    // 更改删除按钮展示
    const changeDeleteButton = () => {
      isShowDeleteButton.value = !isShowDeleteButton.value;
    };
    // 删除图片
    const deletePic = (imgId) => {
      console.log(imgId);
      axios({
        method: "delete",
        url: "http://localhost:8088/hatcher/img/deleteImg",
        params: {
          userId: imgId,
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
            getInfos();
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
    };
    return {
      srcList,
      getImgUrl,
      imgStyle,
      updateGroupInfo,
      isShowGroupDialog,
      info,
      addImg,
      handleAvatarSuccess,
      userId,
      isShowDeleteButton,
      changeDeleteButton,
      deletePic,
      imageUrl,
      currentGroupInfo,
      changeDialogVisible,
    };
  },
};
</script>

<style scoped lang="scss">
.gourpContainer {
  margin: 10px 210px;
  .groupTitle {
    padding-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    .groupName {
      letter-spacing: 8px;
      font-weight: 700;
      font-size: 30px;
      margin: 0 auto;
    }
    .icon {
      position: relative;
      right: 80px;
      font-size: 30px;
    }
  }

  .groupContent {
    margin: 5px 40px;
    padding-bottom: 20px;
    .title {
      font-size: 20px;
      font-weight: 600;
      padding: 10px 0;
    }
    .content {
      text-indent: 2em;
      color: #888;
      margin-bottom: 10px;
    }
    .time {
      border-top: 3px dotted #888;
      color: #888;
    }
  }
  .pics {
    .imgBox {
      position: relative;
      .imgIcon {
        position: absolute;
        top: 20px;
        right: 30px;
        font-size: 20px;
        border-radius: 20px;
        padding: 10px;
        background-color: #40a0ff8f;
      }
      .imgIcon:hover {
        background-color: #40a0ff;
      }
    }

    // display: flex;
    // flex-wrap: wrap;
    // justify-content: center;
    el-image {
      border-radius: 10px;
    }
    // .uploadImg {
    //   cursor: pointer;
    //   display: flex;
    //   justify-content: center;
    //   align-items: center;
    //   width: 330px;
    //   height: 185px;
    //   border: 2px dotted #888;
    //   border-radius: 10px;
    //   margin: 15px;
    //   background: rgba(204, 204, 204, 0.52);
    //   /* 应用于初始状态，因此此转换将应用于返回状态 */
    //   transition: background 0.25s ease-in;
    // }
    // .uploadImg:hover {
    //   background: rgb(158, 158, 158);
    //   /* 应用于悬停状态，因此在触发悬停时将应用此过渡 */
    //   transition: background 0.35s ease-out;
    // }
    .avatar-uploader .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
      border-color: #409eff;
    }
    .avatar-uploader-icon {
      font-size: 28px;
      color: #8c939d;
      width: 330px;
      height: 185px;
      background: rgba(204, 204, 204, 0.52);
      /* 应用于初始状态，因此此转换将应用于返回状态 */
      transition: background 0.25s ease-in;
      border: 2px dotted #888;
      border-radius: 10px;
      margin: 15px;
      text-align: center;
    }
    .avatar-uploader-icon:hover {
      background: rgba(158, 158, 158, 0.52);
      /* 应用于悬停状态，因此在触发悬停时将应用此过渡 */
      transition: background 0.35s ease-out;
    }
    .avatar-uploader-icon svg {
      margin-top: 74px; /* (178px - 28px) / 2 - 1px */
    }
    .avatar {
      width: 178px;
      height: 178px;
      display: block;
    }
  }
  .el-image {
    margin: 0 auto;
  }
}
</style>
