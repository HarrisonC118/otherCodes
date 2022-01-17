import { useStore, mapMutations } from "vuex";
export function useMutation(mapper) {
  const store = useStore();
  const mapValue = mapMutations(mapper);
  const storeValue = {};
  Object.keys(mapValue).forEach((key) => {
    const fn = mapValue[key].bind({
      $store: store,
    });
    storeValue[key] = fn;
  });
  return storeValue;
}
