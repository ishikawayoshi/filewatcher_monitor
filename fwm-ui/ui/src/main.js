import Vue from 'vue'
import VueRouter from 'vue-router';
import App from './App.vue'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'
import axios from 'axios'
import router from './router'
import store from './store'
import VueMoment from 'vue-moment'

Vue.use(Buefy)
Vue.use(VueRouter);
Vue.use(VueMoment);

Vue.prototype.axios = axios.create({
  // baseURL:"http://localhost:8080/",
  timeout:5000
})

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
