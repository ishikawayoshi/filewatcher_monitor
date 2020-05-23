<template>
  <div class="welcome-page">
    <section class="hero is-primary">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Welcome to FWM Tool
          </h1>
          <h2 class="subtitle">
            Primary subtitle
          </h2>
        </div>
      </div>
    </section>
    <section class="container is-fluid">
      <TabsElement />
    </section>
  </div>

</template>

<script>
  import TabsElement from "../elements/TabsElement";
  export default {
    name: "WelcomePage",
    components: {TabsElement}
  }
</script>

<style scoped>

</style>
