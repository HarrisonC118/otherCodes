import { createApp } from "vue";
import App from "./03_自定义指令/App.vue";

const app = createApp(App);
// 自定义全局的指令
app.directive("focus", {
  mounted(el, bindings) {
    el.focus();
    console.log(bindings.value);
    console.log(bindings.modifiers.aaa);
  },
});
app.mount("#app");
