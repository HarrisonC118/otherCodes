import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/",
    name: "NotLogin",
    component: () => import("../views/NotLogin.vue"),
  },
  {
    path: "/addGroup",
    name: "AddGroup",
    component: () => import("../views/AddGroup.vue"),
  },
  {
    path: "/display",
    name: "Display",
    component: () => import("../components/DIsplayPic.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },
  {
    path: "/regist",
    name: "Regist",
    component: () => import("../views/Regist.vue"),
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
