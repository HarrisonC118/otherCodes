// 把setup使用mapState封装成hook
import { useStore, mapState } from "vuex";
import { computed } from "vue";
export function useState(mapper) {
  const store = useStore();
  // mapState返回了一个对象，里面都是computed可以用的函数
  const mapStateValue = mapState(mapper);
  // 创建一个空对象，用来存放处理后的数据
  const storeValue = {};
  // 把mapStateValue对象变成数组后遍历
  Object.keys(mapStateValue).forEach((key) => {
    // 函数里面会访问this.$store，但是这里没有绑定this，所以自己指定一个$store
    const fn = mapStateValue[key].bind({
      $store: store,
    });
    storeValue[key] = computed(fn);
  });
  return storeValue;
}
