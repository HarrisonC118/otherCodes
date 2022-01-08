<template>
  <div>
    <MySlotCpnVue>
      <button>slot1</button>
    </MySlotCpnVue>
    <MySlotCpnVue>
      <h3>slot2</h3>
    </MySlotCpnVue>
  </div>
</template>

<script>
import MySlotCpnVue from './MySlotCpn.vue';
export default {
  components: {
    MySlotCpnVue,
  },
};
</script>

<style scoped></style>
