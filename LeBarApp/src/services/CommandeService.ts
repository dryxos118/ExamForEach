import axios from "axios";
import { ref, Ref } from "vue";

export class CommandeService {
  isLoading: Ref<boolean> = ref(false);

  async getCommande(): Promise<any> {
    try {
      this.isLoading.value = true;
      const { data } = await axios.get("http://localhost:8080/api/commands");
      return data;
    } catch (error) {
      console.log(error);
      return false;
    } finally {
      this.isLoading.value = false;
    }
  }

  async createCommande(id: number): Promise<Boolean> {
    try {
      this.isLoading.value = true;
      if (id != null) {
        const { data } = await axios.post(
          `http://localhost:8080/api/commands/add?id_cocktail=${id}`
        );
        return data;
      } else {
        return false;
      }
    } catch (error) {
      console.log(error);
      return false;
    } finally {
      this.isLoading.value = false;
    }
  }

  async changeStatusCocktail(id: number): Promise<Boolean> {
    try {
      this.isLoading.value = true;
      if (id != null) {
        const { data } = await axios.post(
          `http://localhost:8080/api/commands/status?id_commande=${id}`
        );
        return data;
      } else {
        return false;
      }
    } catch (error) {
      console.log(error);
      return false;
    } finally {
      this.isLoading.value = false;
    }
  }
}
