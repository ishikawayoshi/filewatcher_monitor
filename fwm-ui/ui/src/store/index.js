import Vue from 'vue'
import Vuex from 'vuex'
import sms from './modules/sms'

Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules:{
    sms
  },
  strict:debug
})
