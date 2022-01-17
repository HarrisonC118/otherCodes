import { createApp } from "vue";
import App from "./pages/VuexModule.vue";
import store from "./store";

createApp(App).use(store).mount("#app");
