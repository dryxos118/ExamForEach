import { createRouter, createWebHistory } from "vue-router";
import Home from "./pages/Home.vue";
import Drink from "./pages/Drink.vue";
import Barman from "./pages/Barman.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      component: Home,
    },
    {
      path: "/drink",
      component: Drink,
    },
    {
      path: "/barman",
      component: Barman,
    },
  ],
});

export default router;
