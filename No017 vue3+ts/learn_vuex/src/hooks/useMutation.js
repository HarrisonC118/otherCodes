import { mapMutations, createNamespacedHelpers } from "vuex";
import { useMapper } from "./MutationAndActionMapper";
export function useMutation(moduleName, mapper) {
  let mapperFn = mapMutations;
  if (typeof moduleName === "string" && moduleName.length > 0) {
    mapperFn = createNamespacedHelpers(moduleName).mapMutations;
  }
  const storeValue = useMapper(mapper, mapperFn);
  return storeValue;
}
