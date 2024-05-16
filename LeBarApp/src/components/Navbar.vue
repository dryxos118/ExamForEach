<script setup lang="ts"></script>

<template>
  <nav class="nav">
    <input type="checkbox" id="nav-check" />
    <div class="nav-header">
      <RouterLink to="/">
        <img src="../../public\LeBarApp.png" alt="Bar'App" class="logo" />
      </RouterLink>
    </div>
    <div class="nav-btn">
      <label for="nav-check">
        <span></span>
        <span></span>
        <span></span>
      </label>
    </div>
    <div class="nav-links">
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/drink">Drinks</RouterLink>
      <RouterLink to="/barman">Barman</RouterLink>
      <a
        class="bi bi-github icon-link"
        style="font-size: 1.4rem"
        href="https://icons.getbootstrap.com/icons/github/"
      ></a>
    </div>
  </nav>
</template>

<style scoped lang="scss">
.nav {
  height: inherit;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #4d4d4d;
  position: relative;
  border: none;

  .logo {
    height: auto;
    width: 200px;
  }

  .nav-header {
    width: 50%;
    display: inline;
  }

  .nav-btn {
    display: none;
  }

  .nav-links {
    width: 50%;
    height: 100%;
    display: inline-flex;
    justify-content: flex-end;
    column-gap: 20px;
    font-size: 18px;
    border: none;
    border-radius: 0 0 10px 10px;

    a {
      display: inline-block;
      padding: 10px 10px;
      text-decoration: none;
      color: #efefef;
      margin: auto 0px auto 0px;
      width: 75px;
    }

    a:hover {
      color: burlywood;
    }
  }

  #nav-check {
    display: none;
  }
}

.router-link-active {
  color: burlywood !important;
}

@media (max-width: 750px) {
  .nav {
    .nav-btn {
      display: inline-block;
      position: absolute;
      right: 0px;
      top: 0px;

      label {
        display: flex;
        flex-direction: column;
        row-gap: 10px;
        width: inherit;
        height: auto;
        padding: 15px;
        border: none;
        border-top-right-radius: 10px;
        transition: var(--mainTransition);

        span {
          display: block;
          width: 25px;
          height: 5px;
          background-color: #eee;
          border-radius: 5px;
        }
      }

      label:hover,
      .nav #nav-check:checked ~ .nav-btn label {
        background-color: rgba(0, 0, 0, 0.3);
        cursor: pointer;
      }
    }

    .nav-links {
      position: absolute;
      display: block;
      width: 100%;
      background-color: #333;
      height: 0px;
      transition: all 0.3s ease-in;
      overflow-y: hidden;
      top: 65px;
      left: 0px;
      margin: auto;

      a {
        display: block;
        width: 100%;
        padding-left: 20px;
        margin: auto;
      }
    }

    #nav-check:not(:checked) ~ .nav-links {
      height: 0px;
    }

    #nav-check:checked ~ .nav-links {
      height: auto;
      overflow-y: hidden;
      padding-bottom: 20px;
    }
  }
}
</style>
