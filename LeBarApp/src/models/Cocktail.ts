interface Category {
  id: number;
  name: string;
}

interface Ingredient {
  id: number;
  name: string;
}

interface Cocktail {
  id: number;
  name: string;
  priceS: number;
  priceM: number;
  priceL: number;
  img: string;
  categories: Category[];
  ingredients: Ingredient[];
}
