export default {
  install(app) {
    //给全局属性添加一个名字叫$name的变量
    app.config.globalProperties.$name = "hatcher";
  },
};
