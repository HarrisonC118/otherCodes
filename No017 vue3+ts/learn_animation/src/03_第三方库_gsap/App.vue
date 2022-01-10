<template>
  <div>
    <div>
      <button @click="isShow = !isShow">隐藏\显示</button>
    </div>
    <transition
      name="hatcher"
      @enter="animateEnter"
      @leave="animateLeave"
      :css="false"
      appear
    >
      <h2 class="title" v-show="isShow">Hello World!</h2>
    </transition>
  </div>
</template>

<script>
import gsap from "gsap";
export default {
  data() {
    return {
      isShow: true,
    };
  },
  methods: {
    animateEnter(el, done) {
      gsap.to(el, {
        scale: 1,
        x: 0,
        onComplete: done,
      });
      // 有Bug，不知道怎么修
      //   gsap.from(el, {
      //     scale: 0,
      //     x: 200,
      //     onComplete: done,
      //   });
    },
    animateLeave(el, done) {
      gsap.to(el, {
        scale: 0,
        x: 200,
        onComplete: done,
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.title {
  display: inline-block;
}
</style>
