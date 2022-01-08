<template>
  <div>
    <MySlotCpnVue :slotArray="slotArray">
      <template v-slot="slotProp">
        <button>{{ slotProp.item }}</button>
      </template>
    </MySlotCpnVue>
    <MySlotCpnVue :slotArray="slotArray">
      <template v-slot="slotProp">
        <i>{{ slotProp.item }}</i>
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
      slotArray: ['hatcher', 'yc', 'ddl', 'wy', 'lzp'],
    };
  },
};
</script>

<style scoped></style>
