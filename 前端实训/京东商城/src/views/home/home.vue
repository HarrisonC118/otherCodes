<template>
  <div>
    <div class="wrapper">
      <StaticPart />
      <Nearby />
    </div>
    <docker />
  </div>
</template>

<script>
import StaticPart from './StaticPart.vue'
import Nearby from './Nearby.vue'
import docker from '../../components/docker.vue'
export default {
  // 需要指定组件的名字
  name: 'Home',
  components: {
    StaticPart,
    Nearby,
    docker
  }
}
</script>
<style lang="scss">
.wrapper {
  position: absolute;
  padding: 0 0.18rem;
  left: 0;
  top: 0;
  bottom: 0.5rem;
  right: 0;
  color: #333;
  // 如果溢出框，则应该提供滚动机制。
  overflow-y: auto;
}
</style>
