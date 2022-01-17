import { useMapper, createNamespacedHelpers } from "./StateAndGetterMapper";
import { mapState } from "vuex";
export function useState(moduleName, mapper) {
  let mapperFn = mapState;
  if (typeof moduleName === "string" && moduleName.length > 0) {
    mapperFn = createNamespacedHelpers(moduleName).mapState;
  }
  const storeValue = useMapper(mapper, mapperFn);
  return storeValue;
}
