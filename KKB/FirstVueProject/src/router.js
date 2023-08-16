import Vue from 'vue'
import VueRouter from 'vue-router'
import Applist from './components/List-users.vue'
import Foo from './components/List-task.vue'
import Bar from './components/List-point.vue'
import Add from './components/User-add.vue'
import Edit from './components/User-edit.vue'
Vue.use(VueRouter)
Vue.config.productionTip = false
const router = new VueRouter({
  linkActiveClass: 'active',
  routes: [{
    path: '/',
    redirect: '/heroes'

  }, {
    path: '/heroes',
    component: Applist

  }, {
    path: '/foo',
    component: Foo
  }, {
    path: '/bar',
    component: Bar
  }, {
    path: '/add',
    component: Add
  }, {
    path: '/edit/:id',
    component: Edit,
    keepAlive: false
  }]
})
export default router
