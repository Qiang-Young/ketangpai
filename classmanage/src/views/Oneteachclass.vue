<!--用户所选择的一堂课的详细信息-->
<template>
  <div>
    <el-container>
      <div style="margin: 0 auto;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1);height: 50px">
        <el-breadcrumb separator="">
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 15px">
            <i class="el-icon-s-operation"></i>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 23px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">我的课堂</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">></a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a style="font-size: medium;font-weight: lighter">课程内容</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <i class="el-icon-sort" style="color: black;margin-left: 1200px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px;font-weight: inherit" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
          </el-breadcrumb-item>
          <el-dropdown trigger="click">
            <img src="../assets/class/tou.png" width="32px" height="32px" style="margin-top: 10px">
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item icon="el-icon-arrow-down">开通vip</el-dropdown-item>
              <el-dropdown-item icon="el-icon-paperclip">机构用户认证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">
                <span @click="tosetting">个人设置</span></el-dropdown-item>
              <el-dropdown-item icon="el-icon-setting">学术存证</el-dropdown-item>
              <el-dropdown-item icon="el-icon-close">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-breadcrumb>
      </div>
    </el-container>

    <div style="margin-top: 10px">
      <el-container style="margin: 0 auto;width: 1230px;height: 264px;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)">
        <div style="margin: 0 auto;height: 200px;width: 1224px;border-radius: 10px 10px 0px 0px;" :style="backimg">
          <div style="margin-top: 20px;margin-left: 20px">
            <span style="font-size: 40px;font-weight: normal;color: beige">{{this.classinformation.classname}}</span>
          </div>
          <div style="margin-left: 20px;margin-top: 30px">
            <img src="../assets/class/ma.svg" width="13" height="13" >
            <span style="color: beige">加课码:</span>
            <span style="color: beige">{{this.classinformation.classid}}</span>
            <span style="color: beige;margin-left: 20px" >已有57人加入</span>
          </div>
          <div style="margin-top: 20px;margin-left: 20px">
            <el-button type="primary" round>
              <i class="el-icon-video-play"></i>
              <span>暂无课堂</span>
            </el-button>
          </div>
          <div style="height: 64px">
            <div style="margin-top: 30px">
              <!--              <el-button round>课程学习</el-button>-->
              <!--              <el-button round>学情分析</el-button>-->
              <!--              <el-button round>成绩管理</el-button>-->
              <!--              <el-button round>课程介绍</el-button>-->
              <el-tabs style="text-align: center">
                <el-tab-pane>
                  <span slot="label">课程学习</span>
                  <div  style="width: 1230px;margin-top: 20px">
                    <el-container style="text-align: center">
                      <div >
                        <el-tabs type="card" style="width: 1230px">
                          <el-tab-pane>
                            <span slot="label"><i class="el-icon-tickets"></i>章节</span>
                            <div style="text-align: left;margin-top: 10px">
                              <span style="font-size: 12px">共有0个活动</span>
                            </div>
                            <div style="margin-top: 200px">
                              <img src="../assets/class/nodata.svg">
                            </div>
                            <div>
                              <span style="color: #909399;font-size: 20px">暂无数据</span>
                            </div>
                          </el-tab-pane>

                          <el-tab-pane>
                            <span slot="label">互动课件</span>
                            <div style="text-align: left;margin-top: 10px">
                              <span style="font-size: 12px">共有0个活动</span>
                            </div>
                            <div style="margin-top: 200px">
                              <img src="../assets/class/img_empty.png" style="height: 150px">
                            </div>
                            <div>
                              <span style="color: #909399;font-size: 20px">暂无数据</span>
                            </div>
                          </el-tab-pane>
                          <el-tab-pane>
                            <span slot="label">作业</span>
                            <div style="text-align: left;margin-top: 10px">
                              <span style="font-size: 20px">共有{{this.classinformation.assignment.length}}个活动</span>
                              <el-button style="margin-left: 700px"  class="el-icon-files">批量操作</el-button>
                              <el-dropdown style="margin-left: 20px">
                                <span style="color: #4285f4"  class="el-icon-bottom">
                                下载所有作业
                                </span>
                                <el-dropdown-menu slot="dropdown">
                                  <el-dropdown-item>下载所有作业内容</el-dropdown-item>
                                  <el-dropdown-item>下载所有作业内容(含批注)
                                    <span style="color: red;font-weight: bold">vip</span>
                                  </el-dropdown-item>
                                </el-dropdown-menu>
                              </el-dropdown>
                              <i style="color: #4285f4" class="el-icon-arrow-down el-icon--right"></i>

                              <el-button style="margin-left: 20px" type="success" @click="assignmentflag = true"
                                         class="el-icon-plus" plain>添加作业</el-button>
                              <el-dialog title="添加作业" :visible.sync="assignmentflag" width="47%" >
                                <el-form  :model="ruleForm" :rules="rules" ref="ruleForm"
                                         label-width="90px" class="demo-ruleForm">
                                  <el-form-item label="作业标题" prop="assignmentname">
                                    <el-input maxlength="16" show-word-limit v-model="ruleForm.assignmentname"></el-input>
                                  </el-form-item>
                                </el-form>
                                <span slot="footer" class="dialog-footer">
                                  <el-button @click="assignmentflag = false">取 消</el-button>
                                  <el-button type="primary" @click="addassignment('ruleForm')">确 定</el-button>
                                  </span>
                              </el-dialog>

                            </div>

                            <div style="width: 1230px;margin-top: 20px;border-radius: 10px 10px 0 0 ;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1)">
                              <div v-for="(item, key) in this.classinformation.assignment">
                                <el-row :gutter="20" align="center" style="margin-left: 0">
                                  <el-col :span="1" style="height: 90px;width: 90px;margin-top: 20px" >
                                    <div>
                                      <img src="../assets/class/zuoye.png" style="width: 40px;height: 40px">
                                    </div>
                                    <div style="margin-top: 10px">
                                      <span style="color: #909399">作业</span>
                                    </div>
                                  </el-col>

                                  <el-col :span="1" style="width: 1000px">
                                    <div style="text-align: left; margin-top: 20px">
                                      <span>{{item}}</span>
                                    </div>
                                    <div  style="text-align: left;margin-top: 10px">
                                      <span style="font-size: 10px;color: #909399">截至时间2021/4/22  00:00  |  个人作业</span>
                                    </div>
                                    <div  style="text-align: left;margin-top: 10px">
                                      <span style="font-size: 15px">已提交</span>
                                    </div>
                                  </el-col>
                                  <el-col :span="1" style="width: 100px">
                                    <div style="margin-top: 30px">
                                      <el-button>已提交</el-button>
                                    </div>
                                  </el-col>
                                </el-row>
                                <el-divider></el-divider>
                              </div>
                            </div>

                          </el-tab-pane>

                          <el-tab-pane label="测试">测试</el-tab-pane>

                          <el-tab-pane >
                            <span slot="label">资料</span>
                            <div style="text-align: left;margin-top: 0px">
                              <span style="font-size: 12px">共有0个活动</span>
                            </div>
                            <div>
                              <el-tabs>
                                <el-tab-pane >
                                  <span slot="label">学习资料</span>
                                  <div style="margin-top: 200px">
                                    <img src="../assets/class/img_empty.png" style="height: 150px">
                                  </div>
                                  <div>
                                    <span style="color: #909399;font-size: 20px">暂无数据</span>
                                  </div>
                                </el-tab-pane>
                                <el-tab-pane >
                                  <span slot="label">慕课资料</span>
                                  <div style="margin-top: 200px">
                                    <img src="../assets/class/img_empty.png" style="height: 150px">
                                  </div>
                                  <div>
                                    <span style="color: #909399;font-size: 20px">暂无数据</span>
                                  </div>
                                </el-tab-pane>
                                <el-tab-pane >
                                  <span slot="label">录屏录像</span>
                                  <div style="margin-top: 200px">
                                    <img src="../assets/class/img_empty.png" style="height: 150px">
                                  </div>
                                  <div>
                                    <span style="color: #909399;font-size: 20px">暂无数据</span>
                                  </div>
                                </el-tab-pane>
                                <el-tab-pane >
                                  <span slot="label">直播录像</span>
                                  <div style="margin-top: 200px">
                                    <img src="../assets/class/img_empty.png" style="height: 150px">
                                  </div>
                                  <div>
                                    <span style="color: #909399;font-size: 20px">暂无数据</span>
                                  </div>
                                </el-tab-pane>
                              </el-tabs>

                            </div>
                          </el-tab-pane>

                          <el-tab-pane label="腾讯会议">腾讯会议</el-tab-pane>
                          <el-tab-pane label="公告">公告</el-tab-pane>
                          <el-tab-pane label="互动">互动</el-tab-pane>
                          <el-tab-pane label="互动答题">互动答题</el-tab-pane>
                        </el-tabs>
                      </div>
                    </el-container>
                  </div>
                </el-tab-pane>
                <el-tab-pane label="学情分析">学情分析</el-tab-pane>
                <el-tab-pane label="成绩管理">成绩管理</el-tab-pane>
                <el-tab-pane label="课程设置">课程介绍</el-tab-pane>
              </el-tabs>
            </div>
          </div>

        </div>


      </el-container>

    </div>
    <router-view></router-view>
  </div>


</template>

<script>
import { quillEditor } from 'vue-quill-editor'
export default {
  data(){
    return{
      ruleForm: {
        assignmentname: '',
      },
      finish: [],
      rules: {
        assignmentname: [
          {required: true, message: '请输入作业名称', trigger: 'blur'},
          {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
        ],
      },
      assignmentflag: false,
      classinformation:[],
      backimg:{
        backgroundImage: "url(" + require("../assets/class/4.png") + ")",
        backgroundRepeat: 'no-repeat',
        backgroundSize: '1224px 200px ',
      }
    }
  },
  components:{
    quillEditor
  },
  methods: {
    tooneclass(){
      this.$router.push({
        path: '/Mywork',
        query: {
          userId: this.userId,
        }
      })
    },
    addassignment(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
          this.assignmentflag = false
        } else {
          console.log('error submit!!');
          return false;
        }
      });

    },
    tosetting(){
      this.$router.push({
        path: '/Usersetting',
        query: {
          userId: this.userId
        }
      })
    },
    tomyclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.userId
        }
      })
    },
  },
  created() {
    this.$parent.classbegin = false;
    this.$parent.success = false;
    this.userId = this.$route.query.userId
    this.classid = this.$route.query.classid
    const _this = this

    axios.get('http://localhost:8181/class/findById/' + _this.classid).then(function (resp) {
      _this.classinformation = resp.data
      _this.classinformation.assignment = resp.data.assignment.split(',')
    })
  }
}
</script>

<style scoped>

</style>