import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// 配置映射关系
const routes = [
  { path: "/", redirect: "/home" },
  {
    path: "/home",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    component: () => import("../views/About.vue"),
  },
];
// 创建映射对象
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});
// 导出router对象，方便使用
export default router;
