<template>
  <div>
    <slot name="hatcher"></slot>
    {{ a }}
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
    const a = "hello";
    const me = () => {
      console.log("hello");
    };
    return {
      a,
      me,
    };
  },
};
</script>

<style lang="scss"></style>
