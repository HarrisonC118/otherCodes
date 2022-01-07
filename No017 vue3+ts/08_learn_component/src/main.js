import { createApp } from "vue";
import App from "./02_子传父/App.vue";
import router from "./router";
import store from "./store";

createApp(App).use(store).use(router).mount("#app");
