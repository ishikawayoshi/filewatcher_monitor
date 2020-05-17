<template>
  <div id="app">
    <section class="container is-fluid">
      <h2>Section</h2>
    </section>

    <section>
      <b-field>
        <b-upload v-model="dropFiles"
                  multiple
                  drag-drop>
          <section class="section">
            <div class="content has-text-centered">
              <p>
                <b-icon
                  icon="upload"
                  size="is-large">
                </b-icon>
              </p>
              <p>Drop your files here or click to upload</p>
            </div>
          </section>
        </b-upload>
      </b-field>

      <div class="tags">
            <span v-for="(file, index) in dropFiles"
                  :key="index"
                  class="tag is-primary">
                {{file.name}}
                <button class="delete is-small"
                        type="button"
                        @click="deleteDropFile(index)">
                </button>
            </span>
      </div>
    </section>
    <section>
      <p class="content"><b>Selected:</b> {{ selected }}</p>
      <b-field label="Find a JS framework">
        <b-autocomplete
          rounded
          v-model="name"
          :data="filteredDataArray"
          placeholder="e.g. jQuery"
          icon="magnify"
          clearable
          @select="option => selected = option">
          <template slot="empty">No results found</template>
        </b-autocomplete>
      </b-field>
    </section>
  </div>
</template>

<script>
  export default {
    name: 'app',
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
