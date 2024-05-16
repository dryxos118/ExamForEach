interface CommandeCocktail {
  id: number;
  idCommande: Commande;
  idTaille: Taille;
  quantity: number;
  statusCocktail: string;
  cocktail: Cocktail;
}

interface Commande {
  id: number;
  created: Date;
  statusCommande: string;
}

interface Taille {
  id: number;
  name: string;
}
