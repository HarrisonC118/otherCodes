<template>
  <div>
    <button @click="addNum">添加数字</button>
    <button @click="removeNum">删除数字</button>
    <transition-group tag="div" name="hatcher">
      <span v-for="item in numbers" :key="item" class="item">
        {{ item }}
      </span>
    </transition-group>
  </div>
</template>

<script>
export default {
  data() {
    return {
      numbers: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
      numberCounter: 10,
    };
  },
  methods: {
    addNum() {
      this.numbers.splice(this.randomIndex(), 0, this.numberCounter++);
    },
    removeNum() {
      this.numbers.splice(this.randomIndex(), 1);
    },
    randomIndex() {
      return Math.floor(Math.random() * this.numbers.length);
    },
  },
};
</script>

<style lang="scss" scoped>
.item {
  margin-right: 10px;
  display: inline-block;
}
.hatcher-enter-from,
.hatcher-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
.hatcher-enter-active,
.hatcher-leave-active {
  transition: all 1s ease;
}
// v-move是vue动画自带的class，一个元素删除后，用来移动其他的元素
.hatcher-move {
  transition: transform 1s ease;
}
// 删除元素的时候需要设置绝对定位，把他所占的宽度去掉，其他的元素才可以移动
// 要让删除的元素先脱离文档流，旁边的元素才能过渡过来
.hatcher-leave-active {
  position: absolute;
}
</style>
