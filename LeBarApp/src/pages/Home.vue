<script setup lang="ts"></script>

<template>
  <div class="mb-2">
    <h4>Bar'App: Où chaque verre devient une application de bonheur!</h4>
    <div class="container my-5">
      <div class="row">
        <div class="col-lg-6">
          <img
            class="shadow w-100 mt-5"
            src="https://cdn.pixabay.com/photo/2024/04/21/03/29/ai-generated-8709772_1280.jpg"
            height="600"
          />
        </div>
        <div class="col-lg-6">
          <div class="p-2 home-text">
            <h2>Bienvenue au <strong>Bar'App</strong></h2>
            <div>
              <h4>Au <strong>Bar'App</strong></h4>
              <p>
                Nous sommes fiers de vous offrir une expérience unique où chaque
                verre raconte une histoire et chaque conversation crée des
                souvenirs inoubliables. Situé au cœur de Lille, notre bar est
                l'endroit idéal pour se détendre après une longue journée ou
                pour célébrer les moments spéciaux de la vie.
              </p>
            </div>
            <div>
              <h4>Notre Ambiance</h4>
              <p>
                Entrez et plongez-vous dans une atmosphère chaleureuse et
                conviviale. Que vous veniez seul, en couple ou en groupe, notre
                équipe attentionnée et passionnée veillera à ce que votre visite
                soit des plus agréables. Avec notre décor élégant et notre
                musique envoûtante, chaque instant passé au Bar
                <strong>Bar'App</strong> sera une véritable escapade pour vos
                sens.
              </p>
            </div>
            <div>
              <h4>Notre Sélection</h4>
              <p>
                Découvrez notre impressionnante sélection de boissons
                soigneusement choisies. Des cocktails classiques aux créations
                uniques de notre barman talentueux, en passant par une variété
                de vins, de bières et de spiritueux de qualité, il y en a pour
                tous les goûts. Laissez-vous tenter par nos spécialités maison
                ou demandez à notre équipe de vous recommander une boisson qui
                correspond à vos préférences.
              </p>
            </div>
            <p>
              Que vous soyez un habitué ou que vous franchissiez nos portes pour
              la première fois, nous sommes impatients de vous accueillir au
              <strong>Bar'App</strong> pour une soirée inoubliable. Santé !
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.home-text {
  text-align: center;

  p {
    text-align: start;
    margin-left: 2px;
    font-size: 1.1em;
  }
}

@media screen and (max-width: 750px) {
  .col-img {
    display: none;
  }
}
</style>
