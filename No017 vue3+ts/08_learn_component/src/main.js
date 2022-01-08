import { createApp } from 'vue';
import App from './06_作用域插槽/App.vue';
import router from './router';
import store from './store';

createApp(App).use(store).use(router).mount('#app');
