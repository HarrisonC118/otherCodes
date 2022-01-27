import { createRouter, createWebHistory } from "vue-router";
import type { RouteRecordRaw } from "vue-router";

const routes: RouteRecordRaw[] = [
  { path: "/", redirect: "login" },
  {
    path: "/login",
    name: "Home",
    component: () => import("../views/Login.vue")
  },
  {
    path: "/main",
    name: "Main",
    component: () => import("../views/Main.vue")
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
