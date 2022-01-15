import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
// 配置映射关系
const routes = [
  { path: "/", redirect: "/home" },
  {
    path: "/home",
    component: Home,
  },
  {
    // 动态路由获取url变量
    path: "/about",
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
// 动态添加路由
const HomeRoute = {
  path: "/home",
  name: "home",
  component: Home,
};
router.addRoute(HomeRoute);
// 添加二级路由
router.addRoute("home", {
  path: "/message",
  component: () => import("../views/Message.vue"),
});

// 路由守卫
// to:Route对象，这个路由要跳到哪去
// from:Route对象，从哪个路由过来的
router.beforeEach((to, from) => {
  console.log(to);
  console.log(from);
  return undefined;
});

// 导出router对象，方便使用
export default router;
