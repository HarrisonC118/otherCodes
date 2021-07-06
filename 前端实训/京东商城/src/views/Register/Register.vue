<template>
  <div class="register">
    <div class="register__img">
      <img src="http://www.dell-lee.com/imgs/vue3/user.png" alt="" />
    </div>
    <div class="register__form">
      <input
        class="form__userPhone"
        type="text"
        placeholder="请输入手机号"
        v-model="registerUser.userName"
      />
      <input
        class="form__password"
        type="text"
        placeholder="请输入密码"
        v-model="registerUser.passWord"
      />
      <input
        class="form__confirmPassword"
        type="text"
        placeholder="确认密码"
        v-model="registerUser.confirmPassword"
      />
      <button class="form__submit" @click="handleRegister">注册</button>
    </div>
    <div class="register__other">
      <span class="other__register" @click="toLoginPage">已有账号去登陆</span>
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
  name: 'Register',
  components: {
    docker,
    Toasat
  },
  setup (porps, context) {
    const router = useRouter()
    var mes = ref('')
    var isShowToast = ref(false)
    var registerUser = reactive({
      userName: '',
      passWord: '',
      confirmPassword: ''
    })
    // function handleRegister () {
    //   localStorage.isLogin = true
    //   router.push({ name: 'Home' })
    // }
    // 异步访问
    const handleRegister = async () => {
      // await关键字只能在async修饰的函数中使用，用来等待一个 Promise 对象
      try {
        const result = await post('/register', {
          userName: registerUser.userName,
          passWord: registerUser.passWord,
          confirmPassword: registerUser.confirmPassword
        })
        console.log(result)
        if (result?.errno === 0) {
          mes.value = '注册成功！'
          isShowToast.value = true
          setTimeout(() => {
            isShowToast.value = false
            // localStorage.isLogin = true
            // router.push({ name: 'Home' })
          }, 2000)
        } else {
          mes.value = '注册失败！'
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
    function toLoginPage () {
      router.push({ name: 'Login' })
    }
    return {
      handleRegister,
      toLoginPage,
      registerUser,
      isShowToast,
      mes
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
