import type { AxiosRequestConfig, AxiosResponse } from "axios";
// 定义拦截器类型
export interface HatRequestInterceptor {
  // 请求拦截器函数
  requestInterceptor?: (config: AxiosRequestConfig) => AxiosRequestConfig;
  // 请求出错的拦截器函数
  requestInterceptorCatch?: (error: any) => any;
  // 响应拦截器函数
  responseInterceptor?: (config: AxiosResponse) => AxiosResponse;
  // 响应出错的拦截器函数
  responseInterceptorCatch?: (error: any) => any;
}
// 创建axios必须是AxiosRequestConfig类型，但同时还想在创建的时候传入自定义的拦截器函数，所以单独写一个接口
export interface IHatRequestConfig extends AxiosRequestConfig {
  interceptors?: HatRequestInterceptor;
}
