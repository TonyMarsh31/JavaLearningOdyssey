<template>
  <div>
    <h2 class="sub-header">修改人物</h2>
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">姓名</label>
        <input
          type="text"
          v-model="formData.name"
          class="form-control"
          placeholder="请输入姓名"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">性别</label>
        <input
          type="text"
          v-model="formData.gender"
          class="form-control"
          placeholder="请输入性别"
        />
      </div>

      <button type="submit" @click="editItem" class="btn btn-success">
        确定
      </button>
    </form>
  </div>
</template>

<script>
// import axios from "axios";
export default {
  // 添加数据
  data () {
    return {
      formData: {
        name: '',
        gender: ''
      }
    }
  },
  methods: {
    queryItem () {
      const id = this.$route.params.id

      this.$http.get('/heroes/' + id).then(res => {
        this.formData = res.data
      })
    },
    editItem () {
      // 判断非空
      if (this.formData.name && this.formData.gender) {
        const id = this.$route.params.id
        this.$http.put('/heroes/' + id, this.formData).then(res => {
          if (res.status === 200) {
            this.$router.push({ path: '/heroes' })
          } else {
            alert('修改失败')
          }
        })
      }
    }
  },
  mounted () {
    this.queryItem()
  }
}
</script>

<style></style>
