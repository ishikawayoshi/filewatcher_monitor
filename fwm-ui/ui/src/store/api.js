import axios from 'axios'

var api = axios.create({
  timeout: 12000
});

export default api;
