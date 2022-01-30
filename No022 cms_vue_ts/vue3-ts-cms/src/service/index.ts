/**
 * service的统一出口
 * - HatRequest是对axios库进行了封装
 */
// 引入
import HatRequest from "./request";
import hatRequestConfig from "./request/config";

const hatRequest = new HatRequest({
  // 规定axios的基本Url和超时时间的配置
  baseURL: hatRequestConfig.BASE_URL,
  timeout: hatRequestConfig.TIME_OUT,
  interceptors: {
    requestInterceptor: (config) => {
      return config;
    },
    requestInterceptorCatch: (err) => {
      console.log(err);
      return err;
    },
    responseInterceptor: (config) => {
      return config;
    },
    responseInterceptorCatch: (err) => {
      console.log(err);
      return err;
    }
  }
});

export default hatRequest;
