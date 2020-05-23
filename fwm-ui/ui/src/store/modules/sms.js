import api from './../api'

const state = {};
const getters = {};
const actions = {
  showMessages({commit}) {
    console.log("execute api")
  }
};
const mutations = {};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
