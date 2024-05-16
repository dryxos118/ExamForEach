import axios from "axios";
import { ref, Ref } from "vue";

export class CocktailService {
  Cocktail: Ref<Cocktail[]> = ref([]);
  isLoading: Ref<boolean> = ref(false);

  async getCocktail(): Promise<any> {
    try {
      this.isLoading.value = true;
      const { data } = await axios.get("http://localhost:8080/api/cocktails");
      return data;
    } catch (error) {
      console.log(error);
    } finally {
      this.isLoading.value = false;
    }
  }
}
