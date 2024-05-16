<script setup lang="ts">
import Commande from "../components/Commande.vue";
import Cocktail from "../components/Cocktail.vue";
import Utilisateur from "../components/Utilisateur.vue";
</script>

<template>
  <div class="container-fluid">
    <ul
      class="nav nav-underline align-middle justify-content-start"
      id="myTab"
      role="tablist"
    >
      <li class="nav-item mx-5" role="presentation">
        <button
          class="nav-link active"
          id="home-tab"
          data-bs-toggle="tab"
          data-bs-target="#home-tab-pane"
          type="button"
          role="tab"
          aria-controls="home-tab-pane"
          aria-selected="true"
        >
          Commande
        </button>
      </li>
      <li class="nav-item mx-5" role="presentation">
        <button
          class="nav-link"
          id="profile-tab"
          data-bs-toggle="tab"
          data-bs-target="#profile-tab-pane"
          type="button"
          role="tab"
          aria-controls="profile-tab-pane"
          aria-selected="false"
        >
          Utilisateur
        </button>
      </li>
      <li class="nav-item mx-5" role="presentation">
        <button
          class="nav-link"
          id="contact-tab"
          data-bs-toggle="tab"
          data-bs-target="#contact-tab-pane"
          type="button"
          role="tab"
          aria-controls="contact-tab-pane"
          aria-selected="false"
        >
          Cocktail
        </button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div
        class="tab-pane fade show active"
        id="home-tab-pane"
        role="tabpanel"
        aria-labelledby="home-tab"
        tabindex="0"
      >
        <div class="p-2 mt-2">
          <Commande />
        </div>
      </div>
      <div
        class="tab-pane fade"
        id="profile-tab-pane"
        role="tabpanel"
        aria-labelledby="profile-tab"
        tabindex="0"
      >
        <div class="p-2 mt-2">
          <Utilisateur />
        </div>
      </div>
      <div
        class="tab-pane fade"
        id="contact-tab-pane"
        role="tabpanel"
        aria-labelledby="contact-tab"
        tabindex="0"
      >
        <div class="p-2 mt-2">
          <Cocktail />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.nav-link {
  color: white;
}

.nav-link.active {
  color: burlywood !important;
}
</style>
