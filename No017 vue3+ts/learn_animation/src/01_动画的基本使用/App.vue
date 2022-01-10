<template>
  <div>
    <button @click="isShow = !isShow">隐藏\显示</button>
    <transition name="hatcher">
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
.hatcher-enter-active {
  animation: changeColor 1s ease;
}
.hatcher-leave-active {
  animation: changeColor 1s ease reverse;
}
@keyframes changeColor {
  0% {
    color: aqua;
  }
  50% {
    color: coral;
  }
  100% {
    color: cornflowerblue;
  }
}

// .hatcher-enter-from,
// .hatcher-leave-to {
//   opacity: 0;
// }
// .hatcher-enter-to,
// .hatcher-leaver-from {
//   opacity: 1;
// }
// .hatcher-enter-active,
// .hatcher-leave-active {
//   transition: opacity 0.5s ease;
// }
</style>
