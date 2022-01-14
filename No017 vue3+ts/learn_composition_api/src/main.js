import { createApp } from "vue";
import App from "./04_定义插件/App.vue";
import plugins_object from "./04_定义插件/plugins_object";

const app = createApp(App);
// 自定义全局的指令
app.directive("focus", {
  mounted(el, bindings) {
    el.focus();
    console.log(bindings.value);
    console.log(bindings.modifiers.aaa);
  },
});
app.use(plugins_object);
app.mount("#app");
