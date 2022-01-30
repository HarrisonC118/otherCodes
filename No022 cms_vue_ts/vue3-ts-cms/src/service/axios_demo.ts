import axios from "axios";
// 全局配置
axios.defaults.baseURL = "http://httpbin.org";
axios.defaults.timeout = 10000;
// 根据请求单独配置
axios.get("/get", {
  params: {
    name: "hatcher"
  },
  timeout: 3000
});
axios
  .all([
    axios.get("/get", {
      params: {
        name: "java"
      }
    }),
    axios.post("/post", {
      data: {
        name: "java"
      }
    })
  ])
  .then((res) => {
    console.log(res[0].data); // 第一个请求，就是上面写的get请求
    console.log(res[1].data);
  });

// 拦截器

// 拦截发送的数据
axios.interceptors.request.use(
  (config) => {
    // config中就有这个请求的详细参数，比如请求的地址，发送的内容等等
    // 用完之后要把这个config返回
    return config;
  },
  (err) => {
    console.log("请求发送失败", err);
  }
);

// 拦截响应的数据
axios.interceptors.response.use(
  (res) => {
    // res就是响应数据的具体内容
    console.log("响应成功了");
    return res;
  },
  (err) => {
    // 如果服务器返回400那种错误，就会执行这里
    console.log(err);
  }
);
