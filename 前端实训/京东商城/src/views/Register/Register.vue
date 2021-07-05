<template>
  <div class="register">
    <div class="register__img">
      <img src="http://www.dell-lee.com/imgs/vue3/user.png" alt="" />
    </div>
    <div class="register__form">
      <input class="form__userPhone" type="text" placeholder="请输入手机号" />
      <input class="form__password" type="text" placeholder="请输入密码" />
      <input class="form__confirmPassword" type="text" placeholder="确认密码" />
      <button class="form__submit" @click="handleRegister">注册</button>
    </div>
    <div class="register__other">
      <span class="other__register" @click="toLoginPage">已有账号去登陆</span>
    </div>
    <docker />
  </div>
</template>
<script>
import docker from '../../components/docker.vue'
import { useRouter } from 'vue-router'
export default {
  name: 'Register',
  components: {
    docker
  },
  setup (porps, context) {
    const router = useRouter()
    function handleRegister () {
      localStorage.isLogin = true
      router.push({ name: 'Home' })
    }
    function toLoginPage () {
      router.push({ name: 'Login' })
    }
    return {
      handleRegister,
      toLoginPage
    }
  }
}
</script>

<style lang="scss" scoped>
.register {
  .register__img {
    margin: 0 auto;
    display: flex;
    justify-content: center;
    margin-top: 1.2rem;
    img {
      width: 0.66rem;
      height: 0.66rem;
    }
  }
  .register__form {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    font-size: 0.16rem;
    font-family: PingFangSC-Regular;
    color: rgba(0, 0, 0, 0.5);

    .form__userPhone {
      padding: 0 0.16rem;
      background: #f9f9f9;
      outline: none;
      width: 60%;
      margin-top: 0.4rem;
      margin-bottom: 0.16rem;
      height: 0.48rem;
      border: 1px solid rgba(0, 0, 0, 0.1);
      border-radius: 0.1rem;
    }
    .form__password,
    .form__confirmPassword {
      margin-bottom: 0.16rem;
      padding: 0 0.16rem;
      background: #f9f9f9;
      outline: none;
      width: 60%;
      height: 0.48rem;
      border-radius: 0.1rem;
      border: 1px solid rgba(0, 0, 0, 0.1);
    }
    .form__submit {
      margin-top: 0.16rem;
      padding: 0 0.16rem;
      outline: none;
      border: none;
      box-sizing: content-box;
      width: 60%;
      height: 0.48rem;
      border-radius: 0.1rem;
      background-color: #0091ff;
      color: white;
      box-shadow: 0 4px 8px 0 rgba(0, 145, 255, 0.32);
    }
  }
  .register__other {
    color: rgba(0, 0, 0, 0.5);
    display: flex;
    font-size: 0.14rem;
    justify-content: center;
    margin-top: 0.16rem;
  }
}
</style>
