<!--个人信息设置-->
<template>
  <div>
    <el-container>
      <div style="margin: 0 auto;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1);height: 50px">
        <el-breadcrumb separator="">
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 15px">
            <i @click="drawer = true" class="el-icon-s-operation"></i>
            <el-drawer
                title="我是标题"
                :visible.sync="drawer"
                :with-header="false">
              <span>我来啦!</span>
            </el-drawer>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 23px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">我的课堂</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">></a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a style="font-size: medium;font-weight: bold">用户设置</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <i class="el-icon-sort" style="color: black;margin-left: 1200px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px;font-weight: inherit" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
          </el-breadcrumb-item>
          <el-dropdown trigger="click">
            <img :src="userclass.userface" width="32px" height="32px" style="margin-top: 10px;border-radius: 50px">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item icon="el-icon-arrow-down">开通vip</el-dropdown-item>
              <el-dropdown-item icon="el-icon-paperclip">机构用户认证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">
                <span >个人设置</span></el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">学术存证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-close">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-breadcrumb>
      </div>
    </el-container>
    <div style="margin-top: 20px">
      <el-container>
        <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;height: 140px;border-radius: 8px">
          <el-row gutter="">
            <el-col span="3" style="margin-top: 20px;margin-left: 20px">
              <div>
                <img @click="editmypic" :src="userclass.userface" height="100px" style="border-radius: 50px" width="100px">
                <el-dialog center title="设置头像" width="500px" :visible.sync="picedit">
                  <el-upload
                      action="http://localhost:8181/users/userface"
                      :data="this.userclass"
                      :show-file-list="false"
                      :on-success="handleAvatarSuccess"
                      :before-upload="beforeAvatarUpload">
                    <img  align="center" style="border-radius: 50px;margin-left: 130px;height: 200px;width: 200px"
                         title="点击修改头像" :src="userclass.userface" alt="">
                  </el-upload>
                  <span slot="footer" class="dialog-footer">
                    <el-button @click="exiteditmypic">取 消</el-button>
                    <el-button type="primary" @click="savemypic">确 定</el-button>
                  </span>
                </el-dialog>
              </div>
            </el-col>
            <el-col span="4">
              <div style="margin-top: 40px">
                <span v-if="this.editname.length > 0" style="font-size: 25px">{{this.userclass.username}}</span>
                <span v-if="this.editname.length == 0" style="font-size: 25px">您还未设置姓名</span>
              </div>
              <div style="margin-top: 10px">
                <span style="font-size: 15px;color: dodgerblue">开通课堂派vip</span>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-container>
      <div style="width: 900px;margin: 0 auto;margin-top: 10px">
        <el-container>
          <div style="width: 900px">
            <el-tabs>
              <el-tab-pane >
                <span slot="label">账户信息</span>
                <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;border-radius: 8px">
                  <el-container>
                    <div style="margin-top: 20px;margin-left: 20px">
                      <span @click="edit"> 基础信息</span>
                      <el-button type="text" v-if="this.baseflag == 'scan' "  style="font-size: 20px;margin-left: 730px" @click="edit" >编辑</el-button>
                      <el-button v-if="this.baseflag == 'edit' " style="margin-left: 650px" @click="exitedit">取消</el-button>
                      <el-button v-if="this.baseflag == 'edit' " type="primary" @click="save">保存</el-button>
                    </div>
                  </el-container>
                  <el-container >
                    <div style="margin: 0 auto;width: 852px;margin-top: 20px;border-radius: 8px">
                      <div  >
                        <el-divider></el-divider>
                        <span style="width: 100px">姓名</span>
                        <i v-if="this.editname == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.username}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入姓名" style="width: 200px;margin-left: 120px" v-model="editname"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">学号</span>
                        <i v-if="this.editnumber.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.number}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入学号" style="width: 200px;margin-left: 120px" v-model="editnumber"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">学校</span>
                        <i v-if="this.editschool.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.school}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入学校" style="width: 200px;margin-left: 120px" v-model="editschool"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">院系</span>
                        <i v-if="this.editcourt.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.court}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入院系" style="width: 200px;margin-left: 120px" v-model="editcourt"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">专业</span>
                        <i v-if="this.editspeciality.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.speciality}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入专业" style="width: 200px;margin-left: 120px" v-model="editspeciality"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">班级</span>
                        <i v-if="this.editmyclasses.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.myclasses}}</span>
                        <el-input v-if="this.baseflag == 'edit'" placeholder="请输入班级" style="width: 200px;margin-left: 120px" v-model="editmyclasses"></el-input>
                        <el-divider></el-divider>
                      </div>
                      <div>

                        <span style="width: 100px">年级</span>
                        <i v-if="this.editgrade.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 120px;color: #909399">{{this.userclass.grade}}</span>
                        <el-select v-if="this.baseflag == 'edit'" v-model="editgrade" style="margin-left: 120px" placeholder="请选择年级">
                          <el-option label="1年级" value="1grade"></el-option>
                          <el-option label="2年级" value="2grade"></el-option>
                          <el-option label="3年级" value="3grade"></el-option>
                          <el-option label="4年级" value="4grade"></el-option>
                          <el-option label="5年级" value="5grade"></el-option>
                          <el-option label="6年级" value="6grade"></el-option>
                        </el-select>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">入学时间</span>
                        <i v-if="this.editadmission.length == 0 && this.baseflag == 'scan'"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 90px">未完善</i>
                        <span v-if="this.baseflag == 'scan'" style="margin-left: 86px;color: #909399">{{this.userclass.admission}}</span>
                        <el-date-picker v-if="this.baseflag == 'edit'" format="yyyy 年 MM 月 dd 日" value-format="yyyy-MM-dd" type="date" placeholder="选择日期"
                                        v-model="editadmission" style="margin-left: 85px"></el-date-picker>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin-top: 50px;margin-left: 20px">
                      <span style="color: #303133;font-size: 20px">账号设置</span>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin: 0 auto;width: 852px;margin-top: 30px">
                      <div>
                        <el-divider></el-divider>
                        <span style="width: 100px">课堂派账号</span>
                        <i v-if="this.editktpnum.length == 0" class="el-icon-warning" style="color: #E6A23C;margin-left: 72px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.ktpnum}}</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">所属角色</span>
                        <i v-if="this.editrole.length == 0 && this.roleedit == false"
                           class="el-icon-warning" style="color: #E6A23C;margin-left: 90px">未完善</i>
                        <span v-if="this.roleedit == false" style="margin-left: 90px;color: #909399">{{this.userclass.role}}</span>
                        <el-button type="text" v-if="this.roleedit == false" @click="editmyrole" style="font-size: 15px;margin-left: 580px">去设置</el-button>
                        <el-radio-group v-if="this.roleedit == true" v-model="editrole" style="margin-left: 90px">
                          <el-radio label="老师"></el-radio>
                          <el-radio label="学生"></el-radio>
                        </el-radio-group>
                        <el-button v-if="this.roleedit == true" style="margin-left: 400px" size="small" @click="exiteditrole">取消</el-button>
                        <el-button v-if="this.roleedit == true" type="primary" @click="saverole" size="small">确定</el-button>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">手机号</span>
                        <i v-if="this.editphone.length == 0" class="el-icon-warning" style="color: #E6A23C;margin-left: 105px">未完善</i>
<!--                        <span  @click="this.editmyphone = true" style="color: dodgerblue;font-size: 15px;margin-left: 480px">更换手机号</span>-->
                        <span style="margin-left: 100px;width:200px;color: #909399">{{this.userclass.phone}}</span>
                        <el-button type="text" @click="editmyphone" style="font-size: 15px;margin-left: 440px">更换手机号</el-button>
                        <el-dialog title="修改手机号" width="600px"  :visible.sync="myphoneedit">
                          <div>
                            <span style="margin-left: 20px">原手机号:</span>
                            <span style="margin-left: 80px">{{this.userclass.phone}}</span>
                          </div>
                          <div style="margin-top: 40px">
                            <span style="margin-left: 20px">手机号:</span>
                            <el-input v-model="editnewphone" style="width: 200px;margin-left: 100px"></el-input>
                          </div>
                          <div slot="footer" class="dialog-footer">
                            <el-button @click="exiteditmyphone">取 消</el-button>
                            <el-button type="primary" @click="savemyphone">确 定</el-button>
                          </div>
                        </el-dialog>
                        <span  style="font-size: 15px">    |    </span>
                        <span  style="color: dodgerblue;font-size: 15px">解绑</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">密码</span>
                        <span  style="margin-left: 120px;color: #909399">******</span>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>

                  <el-container>
                    <div style="margin-top: 50px;margin-left: 20px">
                      <span @click="edit" style="color: #303133;font-size: 20px">第三方账号绑定</span>
                    </div>
                  </el-container>
                  <el-container>
                    <div style="margin: 0 auto;width: 852px;margin-top: 30px;height: 220px;">
                      <div>
                        <el-divider></el-divider>
                        <span style="width: 100px">邮箱绑定</span>
                        <i v-if="this.editemail.length == 0" class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.email}}</span>
                        <el-divider></el-divider>
                      </div>
                      <div>
                        <span style="width: 100px">微信绑定</span>
                        <i v-if="this.editwechat.length == 0" class="el-icon-warning" style="color: #E6A23C;margin-left: 120px">未完善</i>
                        <span style="margin-left: 72px;color: #909399">{{this.userclass.wechat}}</span>
                        <el-divider></el-divider>
                      </div>
                    </div>
                  </el-container>
                </div>
              </el-tab-pane>
              <el-tab-pane >
                <span slot="label">通知管理</span>
                <div style="margin: 0 auto;background-color: #F2F6FC;width: 900px;height: 255px;border-radius: 8px">
                  <el-container>
                    <div style="margin-top: 20px;margin-left: 20px">
                      <span>消息推送</span>
                    </div>
                  </el-container>
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-container>

      </div>
    </div>
  </div>
</template>



<script>
export default {
  data() {
    return{
      // imageUrl: '',
      disabled: false,
      editnewphone:'',
      editname: '',
      editnumber: '',
      editschool: '',
      editspeciality: '',
      editmyclasses: '',
      editadmission: '',
      editgrade: '',
      editcourt: '',
      editphone: '',
      editrole:'',
      editpassword:'',
      editemail: '',
      editwechat:'',
      userId: '',
      editktpnum:'',
      drawer: false,
      //用户信息
      userclass:'',
      //基础信息状态
      baseflag: "scan",
      roleedit: false,
      myphoneedit: false,
      picedit: false,
    }
  },
  methods:{
    handleAvatarSuccess(){
      let _this = this
      axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (res) {
        _this.userclass.userface = res.data.userface
      })
    },
    beforeAvatarUpload(file){
      const isJpg = file.type === 'image/jpeg' || file.type === 'image/png'
      const isLt5M = file.size / 1024 / 1024 < 5;
      if(!isJpg){
        this.$message.error('只能上传jpg和png图片');
      }
      if (!isLt5M) {
        this.$message.error('上传头像图片大小不能超过 5MB!');
      }
      return isJpg && isLt5M;
    },
    editmypic(){
      this.picedit = true
    },
    exiteditmypic(){
      this.picedit = false

    },
    savemypic(){
      this.picedit = false
    },
    exiteditmyphone(){
      this.myphoneedit = false
    },
    savemyphone(){
      this.myphoneedit = false
    },
    editmyphone(){
      this.myphoneedit = true
    },
    exitedit(){
      this.baseflag = "scan"
    },
    saverole(){
      this.userclass.role = this.editrole
      axios.put('http://localhost:8181/users/update',this.userclass).then(function (resp) {

      })
      this.roleedit = false
    },
    exiteditrole(){
      this.roleedit = false
    },
    save(){
      this.userclass.username = this.editname
      this.userclass.number = this.editnumber
      this.userclass.school = this.editschool
      this.userclass.court = this.editcourt
      this.userclass.speciality = this.editspeciality
      this.userclass.grade = this.editgrade
      this.userclass.myclasses = this.editmyclasses
      this.userclass.admission = this.editadmission
      axios.put('http://localhost:8181/users/update',this.userclass).then(function (resp) {

      })
      this.baseflag = "scan"
    },
    editmyrole(){
      this.roleedit=true
    },
    edit(){
      // this.editname = this.userclass.username
      // this.editnumber = this.userclass.number
      // this.editschool = this.userclass.school
      // this.editcourt = this.userclass.court
      // this.editspeciality = this.userclass.speciality
      // this.editgrade = this.userclass.grade
      // this.editmyclasses = this.userclass.myclasses
      // this.editadmission = this.userclass.admission
      this.baseflag = "edit"
    },
    tomyclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.userId
        }
      })
    }
  },
  created() {
    this.$parent.success = false;
    this.userId = this.$route.query.userId
    let _this = this
    axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (res) {
      _this.userclass = res.data

      if(_this.userclass.username != null){
        _this.editname = _this.userclass.username
      }
      if(_this.userclass.court != null){
        _this.editcourt = _this.userclass.court
      }
      if(_this.userclass.number != null){
        _this.editnumber = _this.userclass.number
      }
      if(_this.userclass.school != null){
        _this.editschool = _this.userclass.school
      }
      if(_this.userclass.speciality != null){
        _this.editspeciality = _this.userclass.speciality
      }
      if(_this.userclass.grade != null){
        _this.editgrade = _this.userclass.grade
      }
      if(_this.userclass.myclasses != null){
        _this.editmyclasses = _this.userclass.myclasses
      }
      if(_this.userclass.admission != null){
        _this.editadmission = _this.userclass.admission
      }
      if(_this.userclass.ktpnum != null){
        _this.editktpnum = _this.userclass.ktpnum
      }
      if(_this.userclass.role != null){
        _this.editrole = _this.userclass.role
      }
      if(_this.userclass.phone != null){
        _this.editphone = _this.userclass.phone
      }
      if(_this.userclass.email != null){
        _this.editemail = _this.userclass.email
      }
      if(_this.userclass.wechat != null){
        _this.editwechat = _this.userclass.wechat
      }
    })
  }
}
</script>
<style scoped>

</style>