import { InjectionKey } from "vue";
import { createStore, useStore as baseUseStore, Store } from "vuex";

export interface State {
  something: string;
}

export const key: InjectionKey<Store<State>> = Symbol();

export const store = createStore<State>({
  state: {
    something: "",
  },
  mutations: {},
  actions: {},
  modules: {},
});

// 定义自己的 `useStore` 组合式函数
export function useStore() {
  return baseUseStore(key);
}
