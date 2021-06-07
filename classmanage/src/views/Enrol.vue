<!--账号注册页面-->
<template >
  <div >
    <el-container style="margin: 0 auto;height: 922px;background-color: honeydew">
      <div style="margin: 0 auto">
        <el-row :gutter="20" style="margin-top: 20%">
          <el-col :span="3" style="width: 600px;height: 540px">
            <div >
              <img src="../assets/enterpage/img1.png" width="790px" height="530px">
            </div>
          </el-col>
          <el-col :span="3" style="width: 430px;height: 470px;background-color: white;text-align: center">
            <div style="height: 65px;margin-top: 20px">
              <div style="margin:0 auto;height:30px">
                <span style="font-size: 25px;font-weight: bolder" >账号注册</span>
              </div>
            </div>
            <div style="height: 40px;width: auto">
              <el-menu mode="horizontal" style="text-align: center">
                <el-menu-item>账号、邮箱、手机号注册</el-menu-item>
              </el-menu>
            </div>
            <div style="margin: 0 auto;margin-top: 30px;text-align: center">
              <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" class="demo-ruleForm">
                <el-form-item prop="id">
                  <el-input v-model.number="ruleForm.id" placeholder="输入账号"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                  <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码"></el-input>
                </el-form-item>
                <el-form-item prop="checkpassword">
                  <el-input type="password" v-model="ruleForm.checkpassword" autocomplete="off" placeholder="请再次输入密码"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div>
              <el-button type="primary" @click="viewky">注册</el-button>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-container>
  </div>
</template>

<script>


export default {
  data() {
    return{
      ruleForm: {
        id:'',
        password:'',
        checkpassword: '',
      },
      rules: {
        id: [
          {required: true, message: '请输入账号', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur'}
        ],
        checkpassword: [
          {required: true, message: '请再次输入密码', trigger: 'blur'},
          {min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur'}
        ]
      }
    };
  },
  methods :{
    viewky() {
      // let x = this.ruleForm.password
      // let z = this.ruleForm.id
      const _this = this
      if(this.ruleForm.password != this.ruleForm.checkpassword){
         // alert("两次密码不一致！！")
        this.$alert(' 两次密码不一致', '系统提示', {
          confirmButtonText: '确定',
        });
      } else if(this.ruleForm.password == this.ruleForm.checkpassword){
        let data = {
          "id": _this.ruleForm.id,
          "password": _this.ruleForm.password,
        }
        axios.post('http://localhost:8181/users/save',data).then(function (resp){
          console.log(resp)
          if(resp.data == 'success') {
            _this.$alert('注册成功 , 请进行登录', '系统提示', {
              confirmButtonText: '确定',
              callback: action => {
                _this.$router.push('/login')
              }
            });
          }
        })
      }
    }
  },
  created() {
    this.$parent.success = false;
  }
}
</script>
