<template>
  <div>
    <NewInputVue v-model="message"></NewInputVue>
    <h2>message的值: {{ message }}</h2>
  </div>
</template>

<script>
import NewInputVue from './NewInput.vue';
export default {
  components: {
    NewInputVue,
  },
  data() {
    return {
      message: '',
    };
  },
};
</script>

<style scoped></style>
