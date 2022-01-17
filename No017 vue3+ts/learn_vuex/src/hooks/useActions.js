import { useMapper, createNamespacedHelpers } from "./StateAndGetterMapper";
import { mapActions } from "vuex";
export function useAction(moduleName, mapper) {
  let mapperFn = mapActions;
  if (typeof moduleName === "string" && moduleName.length > 0) {
    mapperFn = createNamespacedHelpers(moduleName).mapActions;
  }
  const storeValue = useMapper(mapper, mapperFn);
  return storeValue;
}
