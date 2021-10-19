<template>
  <div class="login_Content">
    <el-alert :title="infos.title" type="success" />
    <el-input
      v-model="inputValue"
      @keydown.enter="addItems(newNode(inputValue))"
    />
    <div class="itemNames" v-for="item in items" :key="item.id">
      {{ item.id }} --> {{ item.name }}
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, PropType } from "vue";

import { TeleObj, TodoNode } from "../../typings/login";

export default defineComponent({
  props: {
    infos: {
      type: Object as PropType<TeleObj>,
      required: true,
    },
  },
  setup() {
    const inputValue = ref("");
    const items = ref([] as TodoNode[]);
    const newNode = (name: string): TodoNode => {
      return {
        id: items.value.length,
        name,
        completed: false,
      };
    };
    const addItems = (item: TodoNode): void => {
      items.value.push(item);
    };
    return {
      items,
      addItems,
      newNode,
      inputValue,
    };
  },
});
</script>

<style lang="scss"></style>
