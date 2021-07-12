import { createRouter, createWebHashHistory } from 'vue-router'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/home/home.vue')
  },
  {
    path: '/login',
    name: 'Login',
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
    component: () => import('../views/Register/Register.vue'),
    beforeEnter (to, from, next) {
      const isLogin = localStorage.isLogin
      if (isLogin) {
        next({ name: 'Home' })
      }
      next()
    }
  },
  {
    path: '/shop/:id',
    name: 'Shop',
    component: () => import('../views/shop/Shop.vue')
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
