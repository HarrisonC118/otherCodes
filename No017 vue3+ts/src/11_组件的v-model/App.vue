<template>
  <div>
    <!-- 绑定一个 -->
    <!-- <NewInputVue v-model="message"></NewInputVue> -->
    <!-- 绑定多个 -->
    <h2>message的值: {{ name }} -- {{ age }}</h2>
    <NewInputVue v-model:name="name" v-model:age.number="age"></NewInputVue>
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
      name: '',
      age: 0,
    };
  },
};
</script>

<style scoped></style>
