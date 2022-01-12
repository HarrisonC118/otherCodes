<template>
  <div>
    <span ref="hello"></span>
  </div>
</template>

<script>
import { ref, reactive, watch } from "vue";
export default {
  setup() {
    // 对普通的ref对象进行监听
    const hello = ref("hello");
    watch(hello, (newValue, oldValue) => {
      console.log(newValue, oldValue);
    });
    // 对reactive对象中的属性进行监听
    const stu = reactive({
      name: "hatcher",
      age: 18,
    });
    watch(
      () => {
        return { ...stu };
      },
      (newValue, oldValue) => {
        console.log(newValue, oldValue);
      }
    );
    return { hello };
  },
};
</script>
