<template>
  <div id="app">

    <section class="container is-fluid">
      <app-navbar></app-navbar>
    </section>
    <router-view />
  </div>
</template>

<script>
  import AppNavbar from "./components/layout/AppNavbar";
  export default {
    name: 'app',
    components:{AppNavbar},
    data() {
      return {
        dropFiles: [],
        data:[],
        name: '',
        selected: null
      }
    },
    mounted(){
      this.axios.get('/actuator/beans').then(res=>{
        let strings = Object.keys(res.data.contexts.application.beans);
        this.data = strings;
        console.log(strings)
      })
    },
    computed:{
      filteredDataArray() {
        return this.data.filter((option) => {
          return option
            .toString()
            .toLowerCase()
            .indexOf(this.name.toLowerCase()) >= 0
        })
      }
    },
    methods: {
      deleteDropFile(index) {
        this.dropFiles.splice(index, 1)
      }
    }
  }
</script>

<style lang="scss">

</style>
