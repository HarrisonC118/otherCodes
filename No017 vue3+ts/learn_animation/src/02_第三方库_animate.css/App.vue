<template>
  <div>
    <button @click="isShow = !isShow">隐藏\显示</button>
    <transition
      name="hatcher"
      enter-active-class="animate__animated animate__bounce"
    >
      <h2 v-show="isShow">Hello World!</h2>
    </transition>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isShow: true,
    };
  },
};
</script>

<style lang="scss" scoped>
.animate__bounce {
  animation-direction: reverse;
}
</style>
