import { createApp } from 'vue';
import App from './05_具名插槽/App.vue';
import router from './router';
import store from './store';

createApp(App).use(store).use(router).mount('#app');
