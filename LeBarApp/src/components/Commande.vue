<script setup lang="ts">
import { ref, onMounted, Ref } from "vue";
import { CommandeService } from "../services/CommandeService";
import Alert from "./Alert.vue";

const commandeService = new CommandeService();

const commande: Ref<CommandeCocktail[]> = ref([]);

const commandeCommander: Ref<CommandeCocktail[]> = ref([]);

const commandeEnCours: Ref<CommandeCocktail[]> = ref([]);

const commandeTerminer: Ref<CommandeCocktail[]> = ref([]);

const alert = ref({
  msg: "",
  show: false,
  type: "",
});

onMounted(async () => {
  commande.value = await commandeService.getCommande();
  sortCommande();
});

const sortCommande = () => {
  if (commande != null) {
    for (let id = 0; id < commande.value.length; id++) {
      const element = commande.value[id];

      switch (element.statusCocktail) {
        case "Commander":
          commandeCommander.value.push(element);
          break;
        case "En cours de preparation":
          commandeEnCours.value.push(element);
          break;
        case "Terminer":
          commandeTerminer.value.push(element);
          break;
        default:
          commandeCommander.value.push(element);
          break;
      }
    }
  }
};

const changeStatusCommande = async (id: number) => {
  if (id != null) {
    const res = await commandeService.changeStatusCocktail(id);
    window.location.reload();
    sortCommande();
    if (res) {
      toggleAlert(true, "Status changer avec Succes sur l'id : " + id, "true");
    } else {
      toggleAlert(true, "Un probleme sur l'id : " + id, "false");
    }
  } else {
    toggleAlert(true, "Un probleme sur l'id : " + id, "false");
  }
};

const toggleAlert = (show = false, msg = "", type = "") => {
  alert.value = {
    msg: msg,
    show: show,
    type: type,
  };
};
</script>

<template>
  <div v-if="alert.show" style="">
    <Alert :msg="alert.msg" :type="alert.type" :remove-alert="toggleAlert" />
  </div>
  <div class="accordion" id="accordionPanelsStayOpenExample">
    <div class="accordion-item">
      <h2 class="accordion-header">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseCommander"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseCommander"
        >
          <span>Il y en à {{ commandeCommander.length }} Commander</span>
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseCommander"
        class="accordion-collapse collapse show"
      >
        <div class="accordion-body">
          <ol class="list-group list-group-numbered">
            <li
              class="list-group-item d-flex justify-content-between align-items-start"
              v-for="item in commandeCommander"
            >
              <div class="ms-2 me-auto">
                <div class="d-grid">
                  <div class="fw-bold col-auto text-start ms-1">
                    {{ item.cocktail.name }}
                    <span class="badge rounded-pill text-bg-primary ms-2">
                      quantiter {{ item.quantity }}
                    </span>
                  </div>
                  <ul class="d-flex col-auto mt-2">
                    <li
                      v-for="ingredient in item.cocktail.ingredients"
                      :key="ingredient.id"
                      class="ms-2"
                    >
                      <span class="badge rounded-pill text-bg-dark">
                        {{ ingredient.name }}
                      </span>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="d-grid">
                <span class="badge text-bg-primary rounded-pill"
                  >id : {{ item.id }}</span
                >
                <button
                  @click="changeStatusCommande(item.id)"
                  class="mt-2 badge text-bg-primary rounded-pill"
                >
                  En cours
                </button>
              </div>
            </li>
          </ol>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseEnCours"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseEnCours"
        >
          <span>Il y en a {{ commandeEnCours.length }} En cours</span>
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseEnCours"
        class="accordion-collapse collapse show"
      >
        <div class="accordion-body">
          <ol class="list-group list-group-numbered">
            <li
              class="list-group-item d-flex justify-content-between align-items-start"
              v-for="item in commandeEnCours"
            >
              <div class="ms-2 me-auto">
                <div class="d-grid">
                  <div class="fw-bold col-auto text-start ms-1">
                    {{ item.cocktail.name }}
                    <span class="badge rounded-pill text-bg-primary ms-2">
                      quantiter {{ item.quantity }}
                    </span>
                  </div>
                  <ul class="d-flex col-auto mt-2">
                    <li
                      v-for="ingredient in item.cocktail.ingredients"
                      :key="ingredient.id"
                      class="ms-2"
                    >
                      <span class="badge rounded-pill text-bg-dark">
                        {{ ingredient.name }}
                      </span>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="d-grid">
                <span class="badge text-bg-primary rounded-pill"
                  >id : {{ item.id }}</span
                >
                <button
                  @click="changeStatusCommande(item.id)"
                  class="mt-2 badge text-bg-primary rounded-pill"
                >
                  Terminer
                </button>
              </div>
            </li>
          </ol>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseTerminer"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseTerminer"
        >
          <span>Il y en a {{ commandeTerminer.length }} Terminer</span>
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseTerminer"
        class="accordion-collapse collapse show"
      >
        <div class="accordion-body">
          <ol class="list-group list-group-numbered">
            <li
              class="list-group-item d-flex justify-content-between align-items-start"
              v-for="item in commandeTerminer"
            >
              <div class="ms-2 me-auto">
                <div class="d-grid">
                  <div class="fw-bold col-auto text-start ms-1">
                    {{ item.cocktail.name }}
                    <span class="badge rounded-pill text-bg-primary ms-2">
                      quantiter {{ item.quantity }}
                    </span>
                  </div>
                  <ul class="d-flex col-auto mt-2">
                    <li
                      v-for="ingredient in item.cocktail.ingredients"
                      :key="ingredient.id"
                      class="ms-2"
                    >
                      <span class="badge rounded-pill text-bg-dark">
                        {{ ingredient.name }}
                      </span>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="d-grid">
                <span class="badge text-bg-primary rounded-pill"
                  >id : {{ item.id }}</span
                >
                <button
                  @click="changeStatusCommande(item.id)"
                  class="mt-2 badge text-bg-primary rounded-pill"
                >
                  Supprimer
                </button>
              </div>
            </li>
          </ol>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.accordion {
  background-color: #0c0d0ee0 !important;
  .accordion-item {
    background-color: #0c0d0ee0;
    color: white;
    .accordion-button.collapsed {
      background-color: #26292a;
      color: white;
    }
    .accordion-button {
      background-color: #0c0d0ee0;
      color: #92c7fa;
    }

    .list-group-item {
      color: white !important;
      background-color: #26292a !important;
    }
  }
}
</style>
