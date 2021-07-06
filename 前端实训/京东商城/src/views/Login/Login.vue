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
    <toasat v-show="isShowToast" :mes="mes"></toasat>
  </div>
</template>
<script>
import docker from '../../components/docker.vue'
import { useRouter } from 'vue-router'
import { reactive, ref } from 'vue'
import { post } from '../../utils/request.js'
import Toasat from '../../components/toast.vue'

export default {
  name: 'Login',
  components: {
    docker,
    Toasat
  },
  setup (porps, context) {
    const router = useRouter()
    var mes = ref('')
    var isShowToast = ref(false)
    const user = reactive({
      userName: '',
      passWord: ''
    })
    // 异步访问
    const handleLogin = async () => {
      // await关键字只能在async修饰的函数中使用，用来等待一个 Promise 对象
      try {
        const result = await post('/isLogin', {
          userName: user.userName,
          passWord: user.passWord
        })
        console.log(result)
        if (result?.errno === 0) {
          mes.value = '登录成功！'
          isShowToast.value = true
          setTimeout(() => {
            isShowToast.value = false
            localStorage.isLogin = true
            router.push({ name: 'Home' })
          }, 2000)
        } else {
          mes.value = '登录失败！'
          isShowToast.value = true
          setTimeout(() => {
            isShowToast.value = false
          }, 2000)
        }
      } catch (e) {
        mes.value = '连接服务器失败！'
        isShowToast.value = true
        setTimeout(() => {
          isShowToast.value = false
        }, 2000)
      }
    }
    function toRegisterPage () {
      router.push({ name: 'Register' })
    }
    return {
      handleLogin,
      toRegisterPage,
      user,
      isShowToast,
      mes
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
