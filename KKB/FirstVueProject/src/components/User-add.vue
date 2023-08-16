<template>
  <div>
    <h2 class="sub-header">新增人物</h2>
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

      <button type="submit" @click="addItem" class="btn btn-success">
        确定
      </button>
    </form>
  </div>
</template>

<script>
// import axios from 'axios'
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
    // 添加的方法
    addItem () {
      // 判断非空
      if (this.formData.name && this.formData.gender) {
        // 发送请求添加信息
        this.$http.post('/heroes/', this.formData).then(res => {
          // 判断添加成功的状态码
          if (res.status === 201) {
            this.$router.push({ path: '/heroes' })
          } else {
            alert('添加失败')
          }
        })
      } else {
        alert('提交的信息不能为空')
      }
    }
  }
}
</script>

<style></style>
