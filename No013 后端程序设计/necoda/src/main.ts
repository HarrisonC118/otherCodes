import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import { useStore } from "./store";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

createApp(App).use(useStore()).use(router).use(ElementPlus).mount("#app");
