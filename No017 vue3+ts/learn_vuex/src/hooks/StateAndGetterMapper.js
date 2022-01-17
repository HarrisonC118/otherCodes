import { useStore } from "vuex";
import { computed } from "vue";
export function useMapper(mapper, mapFn) {
  const store = useStore();
  const mapValue = mapFn(mapper);
  const storeValue = {};
  Object.keys(mapValue).forEach((key) => {
    const fn = mapValue[key].bind({
      $store: store,
    });
    storeValue[key] = computed(fn);
  });
  return storeValue;
}
