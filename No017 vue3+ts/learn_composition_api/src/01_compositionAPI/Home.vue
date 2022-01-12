<template>
  <div>
    <slot name="hatcher"></slot>
  </div>
</template>

<script>
export default {
  name: "Home",
  props: ["message"],
  setup(props, { attrs, slots, emit }) {
    console.log(props.message);
    console.log(attrs.mes2);
    console.log(slots);
    emit("sendMessage", "hello");
  },
};
</script>

<style lang="scss"></style>
