<script setup lang="ts">
import Navbar from "./components/Navbar.vue";
</script>

<template>
  <Navbar />
  <div class="center">
    <RouterView></RouterView>
  </div>
</template>

<style scoped lang="scss">
.center {
  max-width: 1250px;
  margin: 0 auto;
  padding: 2rem;
  text-align: center;
}
</style>
