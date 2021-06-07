<!--我选择的所有课程-->
<template>
  <div>
    <el-container style="text-align: center">
      <div style="margin: 0 auto">
        <el-menu v-show="classbegin" mode="horizontal" default-active="7" style="width: 100%" router>
          <el-menu-item>
            <img :src="logo1Url" idenxheight="50px" width="125" style="text-align: left" @click="tohome"/>
          </el-menu-item>
          <el-menu-item index="7" style="margin-left: 600px" @click="myclass">我的课堂</el-menu-item>
          <el-menu-item index="8" @click="lunwen">论文管理</el-menu-item>
          <el-menu-item >
            <i class="el-icon-sort" style="color: black;margin-left: 500px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
<!--            <el-avatar icon="el-icon-user-solid"></el-avatar>-->

            <el-dropdown trigger="click">
              <img :src="userclass.userface"style="border-radius: 50px" width="32px" height="32px">
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item icon="el-icon-arrow-down">开通vip</el-dropdown-item>
                <el-dropdown-item icon="el-icon-paperclip">机构用户认证</el-dropdown-item>
                <el-dropdown-item icon="el-icon-setting">
                  <span @click="tosetting">个人设置</span></el-dropdown-item>
                <el-dropdown-item icon="el-icon-setting">学术存证</el-dropdown-item>
                <el-dropdown-item icon="el-icon-close" @click="tmain">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>

          </el-menu-item >

        </el-menu>
<!--        置顶课程-->
        <div v-if="this.myteach == false"  style="border-radius: 2px;text-align: right;width: 1380px;margin-top: 20px">
          <el-button type="primary"  @click="joinclass">+加入课程</el-button>
        </div>
<!--    加入创建课程-->
        <div v-if="this.myteach == true" style="border-radius: 2px;text-align: right;width: 1380px;margin-top: 20px">
          <el-dropdown>
            <el-button type="primary">+创建/加入课程</el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <span @click="createclass">创建课程</span>
              </el-dropdown-item>
              <el-dropdown-item >
                <span @click="joinclass">加入课程</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
<!--    加入创建课程弹出框-->
        <el-dialog style="text-align: left" :visible.sync="this.createflag">
          <el-tabs v-model="activityName3" >
            <el-tab-pane  name="first">
              <span slot="label">基本信息(必填)</span>
              <el-form ref="form" :rules="rules" :model="form" label-width="80px">
                <el-form-item label="课程名称" prop="classname">
                  <el-input v-model="form.classname" ></el-input>
                </el-form-item>
                <el-form-item label="教学班级" prop="tcclass">
                  <el-input v-model="form.tcclass" ></el-input>
                </el-form-item>
                <el-form-item style="text-align: left" label-width="120px" label="选择学年-学期" prop="classtime">
                    <el-select  v-model="value" placeholder="请选择" >
                      <el-option
                          v-for="item in options"
                          :key="item.value"
                          :label="item.value"
                          :value="item.value">
                      </el-option>
                    </el-select>
                    <el-select style="margin-left: 30px" v-model="value2" placeholder="请选择" >
                      <el-option
                          v-for="item in options2"
                          :key="item.value"
                          :label="item.value"
                          :value="item.value">
                      </el-option>
                    </el-select>
                </el-form-item>
              </el-form>
              <div>
                <el-button type="text" @click="changemoreflag">更多信息</el-button>
                <i v-if="moreinformation == false" style="color: #4285f4" class="el-icon-arrow-down"></i>
                <i v-if="moreinformation == true" style="color: #4285f4" class="el-icon-arrow-up"></i>
              </div>
              <div v-if="moreinformation == true"  style="background-color: #F2F6FC">
                <div>
                  <span >授课模式</span>
                  <el-radio-group style="margin-left: 20px" v-model="resource">
                    <el-radio label="线上"></el-radio>
                    <el-radio label="线下"></el-radio>
                    <el-radio label="混合"></el-radio>
                  </el-radio-group>
                  <span style="margin-left: 50px">学时数</span>
                  <el-input v-model="classtimesum" style="margin-left: 5px;width: 120px" placeholder="请输入学时"></el-input>
                </div>
                <div style="margin-top: 20px">
                  <span>课程介绍</span>
                </div>
                <div style="margin-top: 7px">
                   <el-input type="textarea" style="width: 800px;" v-model="desc"></el-input>
                </div>
                <div style="margin-top: 20px;height: 50px">
                  <span>授课地点</span>
                  <el-input style="margin-left: 10px;width: 735px" v-model="tclocation"></el-input>
                </div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="高级设置" name="second">配置管理</el-tab-pane>
          </el-tabs>
          <div slot="footer" class="dialog-footer">
            <el-button @click="createflag = false">取 消</el-button>
            <el-button type="primary" @click="savecreateclass('form')">确 定</el-button>
          </div>
        </el-dialog>

        <div style="margin: 0 auto;width: 1150px">
          <div>
            <el-tabs  style="width: 1150px;height: 10px;margin-top: 20px">
              <el-tab-pane >
                <plan style="font-size: 20px" slot="label">我学的</plan>
                <el-button type="primary" style="margin-top: 0px;margin-left: 690px" plain>归档管理</el-button>
                <el-input v-model="search"  placeholder="搜索我学的课程" style="margin-top: 5px;width: 200px;border-radius: 30px;margin-left: 30px"/>
                <el-button class="el-icon-search" @click="searchclass"></el-button>
<!--               所有课程-->
                <div v-if="this.searchlist.length == 0" style="width: 1150px;margin: 0 auto;margin-top: 20px">
                  <el-collapse v-model="activityName">
                    <el-collapse-item  title="我的所有课程" name="1" >

                      <div >
                        <el-row :gutter="20" align="center" style="margin-left: 0">
                          <el-col v-for="(item,key) in userclass.classnum" :span="1"
                                  style="height: 310px;width: 259px;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)" >
                            <div @click="tooneclass(classinformation[key].classid)"
                                 :style="backimg((key)%3)"
                                 style="height: 150px;border-radius: 10px 10px 0px 0px;text-align: left">
                              <div style="margin-left: 15px">
                                <span style="color: darkgray;font-size: 5px">{{classinformation[key].classtime}}</span>
                              </div>
                              <div style="margin-top: 10px;margin-left: 15px">
                                <span style="color: beige;font-size: 20px">{{classinformation[key].classname}}</span>
                              </div>
                              <div style="margin-left: 20px;margin-top: 20px">
                                <img src="../assets/class/ma.svg" width="13" height="13" >
                                <span style="color: beige">课堂码:</span>
                                <span style="color: beige">{{classinformation[key].classid}}</span>
                              </div>
                            </div>
                            <div style="border-radius: 2px;text-align: left;height: 80px">
                              <div style="margin-left: 25px;margin-top: 10px">
                                <span style="font-size: 15px">近期作业</span>
                              </div>
                              <div v-for="count in 2" style="margin-top: 5px;margin-left: 25px">
                                <span style="font-size: 14px;color: #303133;font-weight: 100">{{classinformation[key].assignment[count-1]}}</span>
                              </div>
                              <!--                      <div style="margin-top: 5px;margin-left: 25px">-->
                              <!--                        <span style="font-size: 14px;color: #303133;font-weight: 100">7 校验</span>-->
                              <!--                      </div>-->
                              <div style="height: 10px;margin-top: 0px">
                                <el-divider></el-divider>
                              </div>

                              <div>
                                <span>负责人:</span>
                                <span>{{classinformation[key].manager}}</span>
                                <img style="margin-left: 80px" src="../assets/class/top.svg" width="12" height="12">
                                <span style="margin-left: 5px">置顶</span>
                                <el-dropdown >
                                  <img style="margin-left: 10px" src="../assets/class/etc.svg" height="12" width="12">
                                  <el-dropdown-menu slot="dropdown" trigger="click">
                                    <div>
                                      <el-button @click="refundclass(classinformation[key].classid)" target="_blank" >退课</el-button>
                                    </div>
                                    <div>
                                      <el-button @click="interfile" target="_blank" >归档</el-button>
                                    </div>
                                  </el-dropdown-menu>

                                </el-dropdown>
                              </div>
                            </div>
                          </el-col>
                        </el-row>
                      </div>

                    </el-collapse-item>
                  </el-collapse>
                </div>
<!--                学生搜索结果-->
                <div v-if="this.searchlist.length > 0" style="width: 1150px;margin: 0 auto;margin-top: 20px">
                  <el-collapse v-model="activityName2">
                    <el-collapse-item  title="搜索结果" name="2" >
                      <div >
                        <el-row :gutter="20" align="center" style="margin-left: 0">
                          <el-col v-for="(item,key) in this.searchlist" :span="1" style="height: 310px;width: 259px;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)" >
                            <div @click="tooneclass(item.classid)" :style="backimg((key)%3)" style="height: 150px;border-radius: 10px 10px 0px 0px;text-align: left">
                              <div style="margin-left: 15px">
                                <span style="color: darkgray;font-size: 5px">{{item.classtime}}</span>
                              </div>
                              <div style="margin-top: 10px;margin-left: 15px">
                                <span style="color: beige;font-size: 20px">{{item.classname}}</span>
                              </div>
                              <div style="margin-left: 20px;margin-top: 20px">
                                <img src="../assets/class/ma.svg" width="13" height="13" >
                                <span style="color: beige">课堂码:</span>
                                <span style="color: beige">{{item.classid}}</span>
                              </div>
                            </div>
                            <div style="border-radius: 2px;text-align: left;height: 80px">
                              <div style="margin-left: 25px;margin-top: 10px">
                                <span style="font-size: 15px">近期作业</span>
                              </div>
                              <div v-for="count in 2" style="margin-top: 5px;margin-left: 25px">
                                <span style="font-size: 14px;color: #303133;font-weight: 100">{{item.assignment[count-1]}}</span>
                              </div>
                              <div style="height: 10px;margin-top: 0px">
                                <el-divider></el-divider>
                              </div>

                              <div>
                                <span>负责人:</span>
                                <span>{{item.manager}}</span>
                                <img style="margin-left: 80px" src="../assets/class/top.svg" width="12" height="12">
                                <span style="margin-left: 5px">置顶</span>
                                <el-dropdown >
                                  <img style="margin-left: 10px" src="../assets/class/etc.svg" height="12" width="12">
                                  <el-dropdown-menu slot="dropdown" trigger="click">
                                    <div>
                                      <el-button @click="refundclass(item.classid)" target="_blank" >退课</el-button>
                                    </div>
                                    <div>
                                      <el-button @click="interfile" target="_blank" >归档</el-button>
                                    </div>
                                  </el-dropdown-menu>

                                </el-dropdown>
                              </div>
                            </div>
                          </el-col>
                        </el-row>
                      </div>

                    </el-collapse-item>
                  </el-collapse>
                </div>

<!--           我教的-->
              </el-tab-pane>
              <el-tab-pane v-if="myteach == true">
                <plan style="font-size: 20px" slot="label">我教的</plan>
                <el-button type="primary" style="margin-top: 0px;margin-left: 690px" plain>归档管理</el-button>
                <el-input v-model="search2"  placeholder="搜索我教的课程" style="margin-top: 5px;width: 200px;border-radius: 30px;margin-left: 30px"/>
                <el-button class="el-icon-search" @click="searchteach"></el-button>
              </el-tab-pane>
            </el-tabs>
          </div>
<!--          <el-menu v-show="true" class="el-menu-demo"  mode="horizontal" default-active="9">-->
<!--            <el-menu-item index="9">我学的</el-menu-item>-->
<!--            <el-menu-item index="10" @change="changemyteach">我教的</el-menu-item>-->
<!--            <el-button type="primary" style="margin-top: 20px;margin-left: 500px" plain>归档管理</el-button>-->
<!--            <el-input v-model="search"  placeholder="搜索我学的课程" style="margin-top: 5px;width: 200px;border-radius: 30px;margin-left: 50px"/>-->
<!--            <el-button class="el-icon-search" @click="searchclass"></el-button>-->
<!--          </el-menu>-->
        </div>
<!--        所有课程-->

<!--        搜索结果-->

      </div>
    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data () {
    return{
      moreinformation: false,
      options2:[{
        value: '全年',
      },{
        value: '第一学期'
      },{
        value: '第二学期'
      }],
      options: [{
        value: '2015-2016',
      }, {
        value: '2016-2017',
      }, {
        value: '2017-2018',
      }, {
        value: '2018-2019',
      }, {
        value: '2019-2020',
      },{
        value: '2020-2021',
      }, {
        value: '2021-2022',
      }, {
        value: '2022-2023',
      },],
      value: '',
      value2:'',
      form:{
        classname: '',
        classtime:'',
        tcclass: '',
      },
      rules: {
        classname: [
          {required: true, message: '必填项', trigger: 'blur'},
          {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
        ],
        classtime1: [
          {required: true, message: '必填项', trigger: 'blur'},
        ],
        tcclass: [
          {required: true, message: '必填项', trigger: 'blur'},
        ],
      },
      classtime2:'',
      classtimesum:'',
      tclocation:'',
      desc: '',
      resource:'',
      activityName3: 'first',
      createflag: false,
      search2:'',
      myteach:'',
      searchresult: 'no',
      searchlist:[],
      searchlist2:[],
      activityName: '1',
      activityName2: '2',
      search: "",
      // 所有课程
      classinformation:[],
      teachclass:[],
      userId:'',
      //用户信息
      userclass:'',
      classLen: '',
      classid:'',
      classsum:'',
      classbegin: true,
      logo1Url: require('../assets/homepageimg/logo.png'),
    }
  },
  methods: {
    changemoreflag(){
      if(this.moreinformation == false){
        this.moreinformation = true
      } else if(this.moreinformation == true){
        this.moreinformation = false
      }
    },
    tmain(){
      this.$router.push({
        path: '/'
      });
    },
    createclass(){
      this.createflag = true
    },
    savecreateclass(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
          let randomcode = "";
          // 用字符数组的方式随机
          let model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          for (let j = 0; j < 4; j++) {
            let c = model[Math.round(Math.random()*35)];
            randomcode = randomcode + c;
          }
          let data = {
            "classid": randomcode,
            "classname": this.form.classname,
            "classtime": this.value + ',' + this.value2,
            "manager":this.userclass.username,
            "assignment": '',
            "members": '',
            "teachtype": this.resource,
            "teachplace": this.tclocation,
            "studytime": this.classtimesum,
            "classexplain": this.desc,
          }
          const _this = this
          axios.post('http://localhost:8181/class/save',data).then(function (resp){

          })
          this.createflag = false
          axios.get('http://localhost:8181/users/findById/' + _this.userclass.id).then(function (res) {
            let userdata = res.data
            if(userdata.myteach == null || userdata.myteach.length == 0){
              userdata.myteach = randomcode
            } else {
              userdata.myteach = res.data.myteach.split(',')
              userdata.myteach = randomcode
              userdata.myteach.join(',')
            }
            axios.put('http://localhost:8181/users/update', userdata).then(function (rsp) {
              alert(rsp)
            })
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });


    },
    searchteach(){

    },
    // 搜索课程
    searchclass(){
      this.searchlist = []
      let search = this.search;
      for (let i = 0;i < this.userclass.classnum.length; i++){
        if (search.length > 0) {
          if (this.classinformation[i].classid.indexOf(search) != -1 || this.classinformation[i].classname.indexOf(search) != -1) {
            this.searchlist[this.searchlist.length] = this.classinformation[i]
            this.searchresult = "yes"
          }
        } else {
          this.$message({
            type: 'warning',
            message: '请输入关键词搜索'
          });
          return
        }
      }
      if(this.searchresult != "yes"){
        this.$message({
          type: 'warning',
          message: '没有该课程'
        });
      }
      this.searchresult = "no"
    },
    backimg(index){
      index = index + 1
      let style = {
        backgroundImage: "url(" + require("../assets/class/" + index + ".jpg") + ")",
        backgroundRepeat: 'no-repeat',
        backgroundSize: '259px 150px'
      }

      return style
    },
    tooneclass(num){
      this.$router.push({
        path: '/Oneclass',
        query: {
          userId: this.userId,
          classid: num
        }
      })
    },
    tosetting(){
      this.$router.push({
        path: '/Usersetting',
        query: {
          userId: this.userId
        }
      })
    },
    tohome(){
      this.$router.push('/');
      this.$parent.classbegin = false;
      this.$parent.success = true;
    },
    myclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.userId
        }
      })
    },
    lunwen(){
      this.$router.push({
        path: '/lunwen',
        query: {
          userId: this.userId
        }
      })
    },
    joinclass() {
      this.$prompt('加课码', '加入课程', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /^[a-zA-Z0-9]{5,8}$/,
        inputErrorMessage: '请输入5-8位由字母或者数字组成的课堂号'
      }).then(({value}) => {
        const _this = this
        axios.get('http://localhost:8181/class/findById/' + value).then(function (res){
          if(res == null){
            _this.$message({
              type: 'error',
              message: '该课程不存在'
            });
          } else {
            if (_this.userclass.classnum == null){
              _this.userclass.classnum = value.toString()
              axios.put('http://localhost:8181/users/update', _this.userclass).then(function (rsp) {
              })
              _this.$message({
                type: 'success',
                message: '加入课程成功'
              });
              window.location.reload();
              return
            }
            if(_this.userclass.classnum.length == 0){
              _this.userclass.classnum = value.toString()
              axios.put('http://localhost:8181/users/update', _this.userclass).then(function (rsp) {
              })
              _this.$message({
                type: 'success',
                message: '加入课程成功'
              });
              window.location.reload();
              return
            }
            let num = 0
            for(let i = 0; i < _this.userclass.classnum.length;i++){
              if(value == _this.userclass.classnum[i]){
                _this.$message({
                  type: 'warning',
                  message: '您已经加入了该课程'
                });
                return;
              }
              num = num + 1
            }
            if(num == _this.userclass.classnum.length){
              _this.userclass.classnum[num] = value
              _this.userclass.classnum = _this.userclass.classnum.join(',')
              axios.put('http://localhost:8181/users/update', _this.userclass).then(function (rsp) {
              })
              _this.$message({
                type: 'success',
                message: '加入课程成功'
              });
              window.location.reload();
            }
          }
        })

      })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });
        });
    },
    refundclass(classnum){
      this.$confirm('您确定退选该课程吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // this.$message({
        //   type: 'success',
        //   message: '退选成功!'
        // });
        for(let i = 0; i <= this.userclass.classnum.length-1;i++){
          if(this.userclass.classnum[i] == classnum) {
            for (let j = 0; j < this.userclass.classnum.length - 1 - i; j++) {
              this.userclass.classnum[i+j] = this.userclass.classnum[i+j+1]
            }
            this.userclass.classnum.length = this.userclass.classnum.length-1
            this.userclass.classnum = this.userclass.classnum.join(',')
            axios.put('http://localhost:8181/users/update', this.userclass).then(function (resp) {
            })
            window.location.reload()
            return
          }
        }

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消退选'
        });
      });
    },
    interfile(){
      this.$message({
        type: 'success',
        message: "归档"
      })
    },
  },
  created(){
    this.$parent.success = false;
    this.$parent.classbegin = true;
    this.userId = this.$route.query.userId
    const _this = this
    axios.get('http://localhost:8181/users/findById/' + _this.userId).then(function (res) {
      _this.userclass = res.data
      if(_this.userclass.role == "老师"){
        _this.myteach = true
      } else if (_this.userclass.role == "学生"){
        _this.myteach = false
      }
      if(!(_this.userclass.classnum == null || _this.userclass.classnum.length == 0)){
        _this.userclass.classnum = res.data.classnum.split(',')
        for(let i = 0; i < _this.userclass.classnum.length; i++){
          axios.get('http://localhost:8181/class/findById/'+_this.userclass.classnum[i]).then(function (resp) {
            _this.classinformation[i] = resp.data
            _this.classinformation[i].assignment = resp.data.assignment.split(',')
          })
        }
      }
      if(!(_this.userclass.myteach == null || _this.userclass.myteach.length == 0)){
        _this.userclass.myteach = res.data.myteach.split(',')
        for(let i = 0; i < _this.userclass.myteach.length; i++){
          axios.get('http://localhost:8181/class/findById/'+_this.userclass.myteach[i]).then(function (resp) {
            _this.teachclass[i] = resp.data
            _this.teachclass[i].assignment = resp.data.assignment.split(',')
          })
        }
      }
    })
  }
}
</script>
<style scoped>

</style>