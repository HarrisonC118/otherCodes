import { createRouter, createWebHashHistory } from 'vue-router'
// import Home from '../views/Home.vue'
import Home from '../views/home/home.vue'
import Register from '../views/Register/Register.vue'
import Shop from '../views/shop/Shop.vue'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/Login/Login.vue'),
    beforeEnter (to, from, next) {
      const isLogin = localStorage.isLogin
      if (isLogin) {
        next({ name: 'Home' })
      }
      next()
    }
  },
  {
    path: '/register',
    name: 'Register',
    component: Register,
    beforeEnter (to, from, next) {
      const isLogin = localStorage.isLogin
      if (isLogin) {
        next({ name: 'Home' })
      }
      next()
    }
  },
  {
    path: '/shop',
    name: 'Shop',
    component: Shop
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

// 只有登录才能访问首页
router.beforeEach((to, from, next) => {
  const isLogin = localStorage.isLogin
  if (isLogin || to.name === 'Login' || to.name === 'Register') {
    next()
  } else {
    next({ name: 'Login' })
  }
})

export default router
