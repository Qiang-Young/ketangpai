<!--一个作业-->
<template>
  <div >
    <el-container>
      <div style="margin: 0 auto;box-shadow: 1px 4px 12px 0 rgba(0, 0, 0, 0.1);height: 50px">
        <el-breadcrumb separator="">
          <el-breadcrumb-item>
            <img :src="logo1Url" idenxheight="50px" width="125" style="text-align: left" @click="tohome"/>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px;margin-left: 23px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">我的课堂</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">></a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a style="font-size: medium;font-weight: lighter" @click="tooneclass()">课程内容</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a @click="tomyclass" style="font-size: medium;font-weight: lighter">></a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <a style="font-size: medium;font-weight: lighter">详情</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item style="margin-top: 17px">
            <i class="el-icon-sort" style="color: black;margin-left: 1000px" ></i>
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
    <div>
      <el-container>
        <div style="margin: 0 auto;margin-top: 20px">
          <el-tabs v-model="activeName" style="width: 1150px">
            <el-tab-pane name="first">
              <span style="font-size: 20px" slot="label">详情</span>
              <div style="border: solid 1px lightgray;width: 1100px;height: 220px;
              margin-top: 10px;border-radius: 5px">
                <el-button type="success" size="mini" readonly>作业</el-button>
                <div style="text-align: left; margin-top: 20px;margin-left: 10px">
                  <span>{{workname}}</span>
                </div>
                <div  style="text-align: left;margin-top: 10px;margin-left: 10px">
                  <span style="font-size: 10px;color: #4285f4">截至时间2021/4/22  00:00  |  个人作业</span>
                  <span style=" font-size: 10px;margin-left: 10px;color: #909399">100分</span>
                  <span style="font-size: 10px; margin-left: 10px;color: #909399">查重</span>
                </div>
                <div style="margin-top: 10px">
                  <span  style="margin-left: 10px;font-weight: normal">按照下面的说明</span>
                </div>
                <div style="width: 900px;height:50px;margin-top: 10px;border: solid 1px lightgray;border-radius: 10px">
                  <span class="el-icon-s-order" style="margin-top: 5px;margin-left: 20px;color: #4285f4">按照课堂上的说明提交文档</span>
                </div>
              </div>

            </el-tab-pane>
            <el-tab-pane name="second">
              <span style="font-size: 20px" slot="label">提交作业</span>
              <el-row :gutter="20" align="center" style="margin-left: 0">
                <el-col :span="1" style="height: 90px;width: 90px;margin-top: 20px" >
                  <div>
                    <img src="../assets/class/zuoye.png" style="width: 40px;height: 40px">
                  </div>
                  <div style="margin-top: 10px">
                    <span style="color: #909399">作业</span>
                  </div>
                </el-col>

                <el-col :span="1" style="width: 850px">
                  <div style="text-align: left; margin-top: 20px">
                    <span>{{workname}}</span>
                  </div>
                  <div  style="text-align: left;margin-top: 10px">
                    <span style="font-size: 10px;color: #4285f4">截至时间2021/4/22  00:00  |  个人作业</span>
                    <span style=" font-size: 10px;margin-left: 10px;color: #909399">100分</span>
                    <span style="font-size: 10px; margin-left: 10px;color: #909399">查重</span>
                  </div>
                </el-col>
                <el-col :span="3">
                  <div style="margin-top: 25px">
                    <el-button type="text" class="el-icon-finished" style="font-size: 10px;color: #4285f4">查看谁教了</el-button>
                  </div>
                </el-col>
              </el-row>
              <el-divider></el-divider>
              <div>
                <span style="font-size: 20px;font-weight: lighter">提交内容</span>
                <el-button type="text" class="el-icon-odometer" style="margin-left: 5px;color: #4285f4">提交历史</el-button>
                <el-button type="text" class="el-icon-odometer" style="margin-left: 700px;color: #4285f4">重交作业</el-button>
                <el-button size="mini" style="margin-left: 5px;font-size: small" >查重结果</el-button>
                <el-button size="mini" style="margin-left: 5px;font-size: small" type="primary">更新提交</el-button>
              </div>
              <div style="border-radius: 10px;width: 1100px;height: 350px;
              margin-top: 30px;text-align: center;border: solid 1px lightgray" >
                <div style="text-align: left">
                  <span style="margin-left: 15px;font-size: 23px;font-weight: normal">作业附件</span>
                </div>
                <el-upload
                    class="upload-demo"
                    drag
                    action="https://jsonplaceholder.typicode.com/posts/"
                    multiple>
                  <i class="el-icon-upload"></i>
                  <div class="el-upload__text">将作业文件拖到此处，或<em>点击上传</em></div>
                  <div class="el-upload__tip" slot="tip">支持各类文档、图片、代码、压缩包格式</div>
                </el-upload>
                <div style="text-align: left;margin-top: 20px">
                  <span style="font-size: 17px;font-weight: lighter;margin-left: 15px">作业留言</span>
                  <span style="font-size: 14px;margin-left: 15px;color: #909399">选填</span>
                </div>
                <el-input
                    style="margin-top: 9px;width: 1070px"
                    type="textarea"
                    :autosize="{ minRows: 2, maxRows: 4}"
                    placeholder="请输入内容"
                    v-model="textarea2">
                </el-input>
              </div>
            </el-tab-pane>
          </el-tabs>

        </div>
      </el-container>

    </div>

    <router-view></router-view>
  </div>


</template>

<script>
export default {
  data(){
    return{
      textarea2:'',
      activeName: 'first',
      workname: '',
      classinformation:[],
      classid: '',
      userId: '',
      logo1Url: require('../assets/homepageimg/logo.png'),
    }
  },
  methods: {
    tohome(){
      this.$router.push('/');
      this.$parent.classbegin = false;
      this.$parent.success = true;
    },
    tosetting(){
      this.$router.push({
        path: '/Usersetting',
        query: {
          userId: this.userId
        }
      })
    },
    tooneclass(){
      this.$router.push({
        path: '/Oneclass',
        query: {
          userId: this.userId,
          classid: this.classid,
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
    this.workname = this.$route.query.workname
  }
}
</script>

<style scoped>

</style>