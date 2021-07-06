<template>
  <div class="toast">
    {{ mes }}
  </div>
</template>
<script>
export default {
  name: 'Toast',
  props: ['mes'],
  setup (props, context) {
    console.log(context)
  }
}
</script>
<style scoped lang="scss">
.toast {
  position: fixed;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.6);
  padding: 0.1rem;
  border-radius: 0.05rem;
  color: #fff;
  font-size: 0.16rem;
}
</style>
