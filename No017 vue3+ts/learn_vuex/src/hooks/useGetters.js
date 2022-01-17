import { useMapper } from "./useMapper";
import { mapGetters } from "vuex";
export function useGetter(mapper) {
  const storeValue = useMapper(mapper, mapGetters);
  return storeValue;
}
