import Vue from 'vue'
import App from './App.vue'
import './../node_modules/bootstrap/dist/css/bootstrap.css' // 引入
import './assets/index.css' // 引入index.css
import router from './router'
import Axios from 'axios'
Vue.prototype.$http = Axios
Axios.defaults.baseURL = 'http://localhost:3000'

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
