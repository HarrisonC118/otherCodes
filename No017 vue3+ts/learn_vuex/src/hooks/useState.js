import { useMapper } from "./useMapper";
import { mapState } from "vuex";
export function useState(mapper) {
  const storeValue = useMapper(mapper, mapState);
  return storeValue;
}
