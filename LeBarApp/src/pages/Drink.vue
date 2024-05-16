<script setup lang="ts">
import { ref, onMounted, Ref } from "vue";
import { CocktailService } from "../services/CocktailService";
import Alert from "../components/Alert.vue";
import { CommandeService } from "../services/CommandeService";

const cocktailService = new CocktailService();
const commandeService = new CommandeService();

const Cocktail: Ref<Cocktail[]> = ref([]);

const Panier: Ref<Cocktail | null> = ref(null);

const alert = ref({
  msg: "",
  show: false,
  type: "",
});

onMounted(async () => {
  Cocktail.value = await cocktailService.getCocktail();
});

const AddCocktailToPanier = (id_cocktail: number) => {
  console.log(id_cocktail);
  if (id_cocktail != null) {
    let cocktail = Cocktail.value.find((x) => x.id === id_cocktail);
    if (cocktail != null) {
      if (Panier.value != cocktail) {
        Panier.value = cocktail;
        console.log(Panier.value);
        toggleAlert(true, `${cocktail.name} ajouter au panier`, "true");
      } else {
        toggleAlert(true, `${cocktail.name} déja ajouter au panier`, "false");
      }
    } else {
      console.log("Value null");
    }
  }
};

const addCommande = async () => {
  if (Panier.value != null) {
    let res: Boolean = await commandeService.createCommande(Panier.value.id);
    if (res) {
      toggleAlert(true, `${Panier.value.name} Commander avec succée`, "true");
    } else {
      toggleAlert(true, `${Panier.value.name} na pas etais commander`, "true");
    }
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
  <div class="container-fluid">
    <div class="mb-4 align-middle">
      <h2 class="text-center">Voici la liste des Cocktail Disponible</h2>
    </div>
    <div class="mb-3 mt-3 table-responsive">
      <table
        class="table table-bordered table-dark table-hover align-middle caption-top"
      >
        <caption>
          <div v-if="Panier != null">
            <button class="btn btn-custom" @click="addCommande()">
              Ajouter la commande
            </button>
          </div>
        </caption>
        <thead>
          <tr style="height: 3rem">
            <th scope="col">Names</th>
            <th scope="col">Image</th>
            <th scope="col">PriceS</th>
            <th scope="col">PriceM</th>
            <th scope="col">PriceL</th>
            <th scope="col">Categories</th>
            <th scope="col">Ingredient</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody class="table-group-divider">
          <tr v-for="cocktail in Cocktail" :key="cocktail.id">
            <td scope="row">{{ cocktail.name }}</td>
            <td>
              <img
                :src="cocktail.img"
                :alt="cocktail.name"
                height="100"
                width="50"
              />
            </td>
            <td>{{ cocktail.priceS }}</td>
            <td>{{ cocktail.priceM }}</td>
            <td>{{ cocktail.priceL }}</td>
            <td>
              <ul>
                <li v-for="category in cocktail.categories" :key="category.id">
                  {{ category.name }}
                </li>
              </ul>
            </td>
            <td>
              <ul>
                <li
                  v-for="ingredient in cocktail.ingredients"
                  :key="ingredient.id"
                >
                  {{ ingredient.name }}
                </li>
              </ul>
            </td>
            <td>
              <button
                class="btn btn-danger"
                @click="AddCocktailToPanier(cocktail.id)"
              >
                Ajouter
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<style scoped lang="scss">
table {
  max-height: 90vh;
  overflow: scroll;
}

.btn {
  color: burlywood !important;
}

.btn-custom {
  border: none !important;
}

.btn-custom:hover {
  color: white !important;
}
</style>
