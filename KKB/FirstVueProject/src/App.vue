<template>
  <div id="app">
    <!--   <app-menu></app-menu>-->
    <div id="app">
      <app-header></app-header>
      <div class="container-fluid">
        <div class="row">
          <div class="col-sm-3 col-md-2 sidebar">
            <app-slider></app-slider>
          </div>
          <!--          <app-list></app-list>-->
          <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <router-view></router-view>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import appMenu from './components/Menu.vue'
import appHeader from './components/Header'
import appSlider from './components/Slider'
// import appList from './list'

export default {
  name: 'App',
  components: {
    // appMenu
    appHeader,
    appSlider
    // appList
  }
}
</script>

<style lang="less">

</style>
