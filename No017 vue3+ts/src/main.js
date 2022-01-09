import { createApp } from 'vue';
import App from './09_异步组件/App.vue';
// 使用import函数，就可以让webpack在打包的时候分成多个包打包
import('./09_异步组件/utils/math.js').then((res) => {
  console.log(res.sum(1, 2));
});
createApp(App).mount('#app');
