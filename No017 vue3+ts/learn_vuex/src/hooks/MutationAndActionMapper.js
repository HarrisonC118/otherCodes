import { useStore } from "vuex";
export function useMapper(mapper, fn) {
  const store = useStore();
  const mapValue = fn(mapper);
  const storeValue = {};
  Object.keys(mapValue).forEach((key) => {
    const fn = mapValue[key].bind({
      $store: store,
    });
    storeValue[key] = fn;
  });
  return storeValue;
}
