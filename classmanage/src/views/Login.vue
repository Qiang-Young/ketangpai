<!--登录界面-->
<template >
  <div >
    <el-container style="margin: 0 auto;height: 922px;background-color: honeydew">
      <div style="margin: 0 auto">
      <el-row :gutter="20" style="margin-top: 20%">
        <el-col :span="3" style="width: 600px;height: 540px">
          <div >
            <img src="../assets/enterpage/img1.png" width="690px" height="540px">
          </div>
        </el-col>
        <el-col :span="3" style="width: 430px;height: 470px;background-color: white;text-align: center">
            <div style="height: 65px;margin-top: 20px">
              <div style="margin:0 auto;height:30px">
                <span style="font-size: 25px;font-weight: bolder" >账号登录</span>
              </div>
            </div>
          <div style="height: 40px;width: auto">
            <el-menu mode="horizontal" style="text-align: center">
              <el-menu-item>账号、手机号、账号登录</el-menu-item>
            </el-menu>
          </div>
          <div style="margin: 0 auto;margin-top: 30px;text-align: center">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm"  >
              <el-form-item  prop="id" >
                <el-input placeholder="账号或者邮箱" v-model="ruleForm.id"></el-input>
              </el-form-item>
              <el-form-item  prop="password">
                <el-input v-model="ruleForm.password" placeholder="密码" type="password"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <div>
            <el-button type="primary" @click="viewky">登录</el-button>
            <el-button @click="enrol">注册</el-button>
          </div>

        </el-col>
      </el-row>
      </div>
    </el-container>
  </div>
</template>

<script>


export default {
  data () {
    return{
      ruleForm: {
        id:'',
        password:'',
      },
      rules: {
        id: [
          {required: true, message: '请输入账号', trigger: 'blur'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur'}
        ],
      }
    };
  },
  methods :{
    viewky() {
      let x = this.ruleForm.password
      let z = this.ruleForm.id
      const _this = this

      axios.get('http://localhost:8181/users/findById/' + this.ruleForm.id).then(function (resp) {
        let y = resp.data.password
        if (x == y){
          alert("登录成功")
          _this.$router.push({
            path: '/',
            query:{
              userId: resp.data.id
            }
          })
          _this.$parent.success = true;
          _this.$parent.login = false;
          _this.$parent.islogin = true;
        } else if (x != y &&  x != null){
          alert("密码错误，请重新输入！")
        } else if(resp.data != z) {
          alert("账号不存在，请重新输入正确账号，或者注册新账号！")
        }
      })

    },
    enrol() {
      this.$router.push('/Enrol')
    }
  },
  created() {
    this.$parent.success = false;
  }
}
</script>
