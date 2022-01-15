import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// 配置映射关系
const routes = [
  { path: "/", redirect: "/home" },
  {
    path: "/home",
    component: Home,
    children: [
      {
        //路由地址：/home/hello
        path: "/hello",
        component: () => import(""),
      },
    ],
  },
  {
    // 动态路由获取url变量
    path: "/about/user/:username/age/:user_age",
    name: "About",
    // 打包时会分包，可以用来做懒加载
    component: () => import("../views/About.vue"),
  },
  {
    path: "/:pathMatch(.*)",
    component: () => import("../views/NotFound.vue"),
  },
];
// 创建映射对象
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});
// 导出router对象，方便使用
export default router;
