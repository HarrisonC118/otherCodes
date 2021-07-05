<template>
  <div class="login">
    <div class="login__img">
      <img src="http://www.dell-lee.com/imgs/vue3/user.png" alt="" />
    </div>
    <div class="login__form">
      <input
        v-model.lazy="user.userName"
        class="form__userPhone"
        type="text"
        placeholder="请输入手机号"
      />
      <input
        v-model.lazy="user.passWord"
        class="form__password"
        type="text"
        placeholder="请输入密码"
      />
      <button class="form__submit" @click="handleLogin">登录</button>
    </div>
    <div class="login__other">
      <span class="other__register" @click="toRegisterPage">立即注册</span>
      <div class="other__br">|</div>
      <span class="other__forget">忘记密码</span>
    </div>
    <docker />
  </div>
</template>
<script>
import docker from '../../components/docker.vue'
import { useRouter } from 'vue-router'
import axios from 'axios'
import { reactive } from 'vue'
// 设置提交数据的格式为json格式
axios.defaults.headers.post['Content-Type'] = 'application/json'
export default {
  name: 'Login',
  components: {
    docker
  },
  setup (porps, context) {
    const router = useRouter()
    const user = reactive({
      userName: '',
      passWord: ''
    })
    function handleLogin () {
      axios
        .post(
          'https://www.fastmock.site/mock/76be3c9b531d8ee9728d14c66fe0bff2/hatcher/login',
          {
            userName: user.userName,
            passWord: user.passWord
          }
        )
        .then(a => {
          localStorage.isLogin = true
          router.push({ name: 'Home' })
        })
        .catch(a => {
          console.log('失败了')
        })
    }
    function toRegisterPage () {
      router.push({ name: 'Register' })
    }
    return {
      handleLogin,
      toRegisterPage,
      user
    }
  }
}
</script>

<style lang="scss" scoped>
.login {
  .login__img {
    margin: 0 auto;
    display: flex;
    justify-content: center;
    margin-top: 1.2rem;
    img {
      width: 0.66rem;
      height: 0.66rem;
    }
  }
  .login__form {
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
    .form__password {
      padding: 0 0.16rem;
      background: #f9f9f9;
      outline: none;
      width: 60%;
      height: 0.48rem;
      border-radius: 0.1rem;
      border: 1px solid rgba(0, 0, 0, 0.1);
    }
    .form__submit {
      margin-top: 0.32rem;
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
  .login__other {
    color: rgba(0, 0, 0, 0.5);
    display: flex;
    font-size: 0.14rem;
    justify-content: center;
    margin-top: 0.16rem;
    .other__br {
      margin: 0 0.12rem;
    }
  }
}
</style>
