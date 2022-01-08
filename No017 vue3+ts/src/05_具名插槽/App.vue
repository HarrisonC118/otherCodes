<template>
  <div>
    <MySlotCpnVue :slotName="slotName">
      <!-- 使用v-slot来指明里面的内容需要放到哪个插槽中 -->
      <template v-slot:one>
        <button>第一个插槽</button>
      </template>
      <!-- 简写 -->
      <template #two>
        <button>第二个插槽</button>
      </template>
      <!-- 动态插槽 -->
      <template #[slotName]>
        <button>第三个插槽</button>
      </template>
    </MySlotCpnVue>
  </div>
</template>

<script>
import MySlotCpnVue from './MySlotCpn.vue';
export default {
  components: {
    MySlotCpnVue,
  },
  data() {
    return {
      slotName: 'hat',
    };
  },
};
</script>

<style scoped></style>
