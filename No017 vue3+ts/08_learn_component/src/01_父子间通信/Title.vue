<template>
  <div>
    <h2>{{ title }}</h2>
    <p>{{ content }}</p>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      require: false, // 表示这个值必须有
      type: String, // 表示这个类型必须是String
      default: "123", // 设置这个值的默认值
      validator(value) {
        // 自定义验证器，下面表示：传过来的值必须是下面这几个值中的一个
        return ["error", "warning", "normal"].includes(value);
      },
    },
    content: {},
  },
};
</script>

<style lang="scss" scoped></style>
