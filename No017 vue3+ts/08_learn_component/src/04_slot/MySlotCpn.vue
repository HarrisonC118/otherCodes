<template>
  <div>
    <h2>组件开始</h2>
    <!-- 定义默认内容，如果父组件未提供内容，则会显示默认内容 -->
    <slot></slot>
    <h2>组件结束</h2>
  </div>
</template>

<script>
export default {};
</script>

<style scoped></style>
