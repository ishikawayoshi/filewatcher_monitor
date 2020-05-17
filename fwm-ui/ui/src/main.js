import Vue from 'vue'
import App from './App.vue'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'
import axios from 'axios'

Vue.use(Buefy)

Vue.prototype.axios = axios.create({
  baseURL:"http://localhost:8081/",
  timeout:5000
})

new Vue({
  el: '#app',
  render: h => h(App)
})
