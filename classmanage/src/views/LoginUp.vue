<template>
  <div>
    <el-container style="position: absolute ;right: 0px;left:0px">
      <div style="margin: 0 auto">
        <el-main>
          <el-row>
            <el-col>
              <div style="margin-top: 200px">
                <img src="../assets/enterpage/img1.png" width="690px" height="540px">
              </div>
            </el-col>
            <el-col >
              <div style="bottom:630px;left:300px;width: 450px; height: 735px; margin-left: 35%;background:#FFFFFF; border-radius: 10px; position: relative;box-shadow: 0 0 25px #cac6c6;">
                <h1 style="height: 50px; font-size: 35px; line-height: 90px;font-family: cursive;position: relative;left: 130px">注册账号</h1>
                <el-form ref="user" :model="user" :rules="rules" style="margin-left: 20px; margin-right: 20px;">
                  <el-form-item prop="email">
                    <el-input v-model="user.username" placeholder="电话"></el-input>
                  </el-form-item>
                  <el-form-item prop="password">
                    <el-input type="password" v-model="user.password" placeholder="请输入密码"></el-input>
                  </el-form-item>
                  <el-form-item prop="password">
                    <el-input v-model="user.rePassword" placeholder="请在此输入密码"></el-input>
                  </el-form-item>
                  <div class="el-form-item margin-bottom el-form-item--feedback">
                    <div class="el-form-item__content">
                      <p class="font-bold font16">选择身份</p>
                      <div class="role-box">
                        <div class="item flex-align":class="{active:role==='teacher'}"  @click="changleRole('teacher')">
                            <img src="../assets/homepageimg/register/teacher.svg" class="icon">
                            <span class="name">老师/助教</span>
                        </div>
                        <div class="item flex-align ":class="{active: role==='student'}" @click="changleRole('student')">
                             <img src="../assets/homepageimg/register/student.svg" class="icon">
                             <span class="name">学生</span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <el-form-item prop="name">
                    <el-input v-model="user.name" placeholder="请输入姓名"></el-input>
                  </el-form-item>
                  <el-form-item prop="school">
                    <el-input v-model="user.school" placeholder="请输入学校"></el-input>
                  </el-form-item>
                  <el-form-item v-if="type===3" prop="tsid">
                    <el-input v-model="user.studentid" placeholder="我的学号/工号"></el-input>
                  </el-form-item>
                  <el-form-item prop="identyInput">
                    <el-input
                        v-model="user.identyInput"
                        placeholder="验证码"
                        style="width:220px;float:left"
                    ></el-input>
                    <div class="code" @click="refreshCode">
                      <s-identify :identifyCode="identifyCode"></s-identify>
                    </div>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submit" style="width: 385px">注册</el-button>
                  </el-form-item>
                  <div style="width: 100px;height: 30px; margin-left: 280px; font-size: 13px;color: #CAC6C6;">
                    已有账号?
                  </div>
                  <router-link to='/Login'>
                    <a style="width: 50px; float: right; font-size: 13px;position: relative;left: 5px;top: -30px;"> 去登录</a>
                  </router-link>
                </el-form>
              </div>
            </el-col>
          </el-row>
        </el-main>
      </div>
    </el-container>
  </div>
</template>

<script>
import SIdentify from "@/components/identify";
export default {
  name: "LoginUp",
  components: {SIdentify},
  data(){
      var newReg1 = (rule, value, callback) => {
        if (value != this.identifyCode) {
          callback(new Error("验证码错误"));
        } else {
          callback(); //必须要有回调，要不然表单无法提交
        }
      };
      return{
        user: {
            username:"",
            password:"",
            rePassword:"",
            name:"",
            school: "",
           number:"",
        },
        role: 'teacher',
        identifyCodes: "1234567890",
        identifyCode: "",
        rules: {
          email: [
            { required: true, message: "邮箱不能为空", trigger: "blur" },
            {
              pattern:/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/,
              message:"邮箱输入有误",
              trigger:"blur"
            }
          ],
          name: [
            {
              required: true,
              message: "姓名不能为空",
              trigger: "blur"
            },
            {
              pattern: /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/,
              message: "姓名需为中文姓名",
              trigger: "change"
            }
          ],
          password: [
            { required: true, message: "密码不能为空", trigger: "blur" },
            {
              pattern:/^(?![A-Za-z]+$)(?![A-Z0-9]+$)(?![a-z0-9]+$)(?![a-z\W_!@#$%^&*`~()-+=]+$)(?![A-Z\W_!@#$%^&*`~()-+=+$)(?![0-9\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\W_!@#$%^&*`~()-+=]{8,16}$/,
              message:"密码需8-16位(包含大小写字母、特殊符号、数字中的任意三项)",
              trigger:"blur"
            }
          ],
          school: [
            { required: true, message: "学校不能为空", trigger: "blur" }
          ],
          identyInput: [
            {
              required: true,
              message: "验证码不能为空",
              trigger: "blur"
            },
            { validator: newReg1, trigger: "blur" }
          ]
        }
      }
    },

    methods:{
    changleRole(role){
      this.role=role
    },
      randomNum(min, max) {
        return Math.floor(Math.random() * (max - min) + min);
      },
      refreshCode() {
        this.identifyCode = "";
        this.makeCode(this.identifyCodes, 4);
      },
      makeCode(o, l) {
        for (let i = 0; i < l; i++) {
          this.identifyCode += this.identifyCodes[
              this.randomNum(0, this.identifyCodes.length)
              ];
        }
        console.log(this.identifyCode);
      },
    }

}
</script>

<style scoped>
.role-box{
  display: flex;
  justify-content: space-between;
}
.role-box .active {
  border: 1px solid #4285f4;
}
.flex-align {
  display: flex;
  align-items: center;
}

.role-box .item {
  width: 172px;
  padding: 8px 16px;
}
.role-box .item .name {
  font-size: 14px;
  font-family: MicrosoftYaHei;
  text-align: center;
  color: #3c4043;
  line-height: 24px;
  letter-spacing: 1px;
}
.font-bold {
  font-weight: 700;
}

.font16 {
  font-size: 16px;
}
.code {
  width: 157px;
  height: 46px;
  float: right;
}
</style>
