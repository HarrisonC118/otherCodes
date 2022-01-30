import axios from "axios";
import type { AxiosRequestConfig, AxiosInstance } from "axios";
import type { HatRequestInterceptor, IHatRequestConfig } from "./type";
/**
 * 封装axios
 * 类的封装性比单个的函数要强
 */
class HatRequest {
  // 用来保存实例，保证多个axios对象互不影响
  instance: AxiosInstance;
  interceptor?: HatRequestInterceptor;
  constructor(config: IHatRequestConfig) {
    this.interceptor = config.interceptors;
    // 创建一个axios实例
    this.instance = axios.create(config);

    // 把传入的拦截器配置到axios中
    this.instance.interceptors.request.use(
      this.interceptor?.requestInterceptor,
      this.interceptor?.requestInterceptorCatch
    );

    this.instance.interceptors.response.use(
      this.interceptor?.responseInterceptor,
      this.interceptor?.responseInterceptorCatch
    );
  }

  request(config: AxiosRequestConfig): void {
    this.instance.request(config).then((res) => {
      console.log(res);
    });
  }
}
export default HatRequest;
