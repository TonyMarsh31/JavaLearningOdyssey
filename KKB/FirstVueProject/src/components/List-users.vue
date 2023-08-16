<template>
  <div>
    <h2 class="sub-header">Hero List</h2>
    <a class="btn btn-success" href="#/add">新增</a>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>id</th>
          <th>姓名</th>
          <th>性别</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="item in list" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.gender }}</td>
          <td>
            <router-link :to="{ path: '/edit/' + item.id }">编辑</router-link>
            &nbsp;&nbsp;
            <a href="javascript:" @click="deleItem(item.id)">删除</a>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
// import axios from 'axios';
export default {
  data () {
    return {
      list: []
    }
  },
  methods: {
    loadData () {
      this.$http.get('/heroes').then(res => {
        this.list = res.data
      })
    },
    deleItem (id) {
      if (confirm('确定要删除吗')) {
        this.$http.delete('/heroes/' + id).then(res => {
          if (res.status === 200) {
            this.loadData()
          }
        })
      }
    }
  },
  mounted () {
    this.loadData()
  }
}
</script>

<style></style>
