<script setup lang="ts">
import { onMounted, defineProps, onBeforeUnmount, ref } from "vue";

const props = defineProps<{
  type: string;
  msg: string;
  removeAlert: Function;
}>();

const timer = ref<any>(0);

const setTimer = () => {
  timer.value = setTimeout(() => {
    props.removeAlert();
  }, 3000);
};

onMounted(() => {
  console.log(props.msg);
  setTimer();
});

onBeforeUnmount(() => {
  if (timer.value) {
    clearTimeout(timer.value);
  }
});
</script>

<template>
  <div class="d-flex align-middle alert">
    <i
      v-if="props.type === 'true'"
      class="bi bi-check2-square"
      style="font-size: 1.4rem; color: green"
    ></i>
    <i v-else class="bi bi-x-circle" style="font-size: 1.4rem; color: red"></i>
    <p :class="`alert-${type}`">{{ msg }}</p>
  </div>
</template>

<style scoped lang="scss">
.alert {
  position: fixed;
  margin: 0 auto;
  height: auto;
  display: grid;
  align-items: center;
  text-align: center;
  font-size: 0.7rem;
  border-radius: 0.25rem;
  width: auto;
  max-width: 400px;
  background-color: white;
  z-index: 50;
  top: 30px;
  left: 45%;
  overflow: auto;
  -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
  animation: fadein 0.5s, fadeout 0.5s 2.5s;

  p {
    font-size: 1rem;
    margin: 0 auto;
    margin-left: 5px;
    text-align: start;
  }
}
.alert-false {
  color: #721c24;
}
.alert-true {
  color: #155724;
}

@-webkit-keyframes fadein {
  from {
    top: 0;
    opacity: 0;
  }
  to {
    top: 30px;
    opacity: 1;
  }
}

@keyframes fadein {
  from {
    top: 0;
    opacity: 0;
  }
  to {
    top: 30px;
    opacity: 1;
  }
}

@-webkit-keyframes fadeout {
  from {
    top: 30px;
    opacity: 1;
  }
  to {
    top: 0;
    opacity: 0;
  }
}

@keyframes fadeout {
  from {
    top: 30px;
    opacity: 1;
  }
  to {
    top: 0;
    opacity: 0;
  }
}
</style>
