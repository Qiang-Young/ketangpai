<!--论文管理界面-->
<template>
  <div>
    <el-container style="text-align: center">
      <div style="margin: 0 auto">
        <el-menu v-show="classbegin" mode="horizontal" default-active="8" style="width: 100%" router>
          <el-menu-item>
            <img :src="logo1Url" idenxheight="50px" width="125" style="text-align: left" @click="tohome"/>
          </el-menu-item>
          <el-menu-item index="7" style="margin-left: 600px" @click="myclass">我的课堂</el-menu-item>
          <el-menu-item index="8" @click="lunwen">论文管理</el-menu-item>
          <el-menu-item >
            <i class="el-icon-sort" style="color: black;margin-left: 500px" ></i>
            <a href="https://v4.ketangpai.com/" style="margin-left: 0px" target="_blank" >切换旧版本</a>
            <i class="el-icon-message-solid" style="color: #303133"></i>
            <el-avatar icon="el-icon-user-solid"></el-avatar>
          </el-menu-item >
        </el-menu>

          <div style="margin: auto;margin-top: 100px;width: 1150px;text-align: left">
            <span style="font-size: x-large">我的论文管理组织</span>
            <el-button type="primary" plain @click="open()" style="margin-left: 790px">+加入论文管理组织</el-button>
          </div>
          <div style="margin:auto;background-color: honeydew;width: 1150px;margin-top: 30px;text-align: left">
            <div>
              <span style="margin-left: 10px;font-size: x-large;color: #303133">同学您好，欢迎您进入课堂派论文管理系统</span>
            </div>
            <div style="margin-top: 30px">
              <span style="margin-left: 10px;color: #909399">目前您还未加入任何论文管理组织，请点击</span>
              <span style="margin-left: 10px;color: dodgerblue">“加入论文管理组织”</span>
              <span style="margin-left: 10px;color: #909399">，输入邀请码加入论文评审/答辩组织。</span>
            </div>
            <div style="text-align: center;margin-top: 50px">
             <el-row :gutter="20" align="center" style="margin-left: 1%;height: auto;width: auto">

                <el-col :span="3" style="height: 45px;width: 120px;background-color: white;border-radius: 30px" >
                  <div style="margin-top: 12%;font-size: 15px">
                    <span style="color: dodgerblue">加入管理组织</span>
                  </div>
                </el-col>
               <el-col :span="1" style="height: 45px;margin-top: 10px;width: 50px" >
                 <div style="margin-left: 0px">
                   <span style="color: dodgerblue">——</span>
                 </div>
               </el-col>
               <el-col :span="3" style="height: 45px;width: 120px;background-color: white;border-radius: 30px;margin-left: 5px" >
                 <div style="margin-top: 12%;font-size: 15px">
                   <span style="color: dodgerblue">学生上交论文</span>
                 </div>
               </el-col>
               <el-col :span="1" style="height: 45px;margin-top: 10px;width: 50px" >
                 <div style="margin-left: 0px">
                   <span style="color: dodgerblue">——</span>
                 </div>
               </el-col>
               <el-col :span="3" style="height: 45px;width: 120px;background-color: white;border-radius: 30px" >
                 <div style="margin-top: 12%;font-size: 15px">
                   <span style="color: dodgerblue">导师审核</span>
                 </div>
               </el-col>
               <el-col :span="1" style="height: 45px;margin-top: 10px;width: 50px" >
                 <div style="margin-left: 0px">
                   <span style="color: dodgerblue">——</span>
                 </div>
               </el-col>
               <el-col :span="3" style="height: 45px;width: 180px;background-color: white;border-radius: 30px" >
                 <div style="margin-top: 7%;font-size: 15px">
                   <span style="color: dodgerblue">管理人员分配评审/答辩</span>
                 </div>
               </el-col>
               <el-col :span="1" style="height: 45px;margin-top: 10px;width: 50px" >
                 <div style="margin-left: 0px">
                   <span style="color: dodgerblue">——</span>
                 </div>
               </el-col>
               <el-col :span="3" style="height: 45px;width: 170px;background-color: white;border-radius: 30px" >
                 <div style="margin-top: 7%;font-size: 15px">
                   <span style="color: dodgerblue">专家/答辩委员评审</span>
                 </div>
               </el-col>
               <el-col :span="1" style="height: 45px;margin-top: 10px;width: 50px" >
                 <div style="margin-left: 0px">
                   <span style="color: dodgerblue">——</span>
                 </div>
               </el-col>
               <el-col :span="3" style="height: 45px;width: 170px;background-color: white;border-radius: 30px" >
                 <div style="margin-top: 7%;font-size: 15px">
                   <span style="color: dodgerblue">完成论文评审/答辩</span>
                 </div>
               </el-col>

             </el-row>
<!--              <div style="height: 50px;width: 120px;background-color: white;border-radius: 30px">-->
<!--                <div style="height: 20px;width: 100px;margin-top: 20px">-->
<!--                  <span style="font-size: medium;color: dodgerblue;" >加入管理组织</span>-->
<!--               </div>-->
<!--              </div>-->

            </div>
          </div>
      </div>

    </el-container>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  data () {
    return{
      classbegin: true,
      logo1Url: require('../assets/homepageimg/logo.png'),
    }
  },
  methods: {
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
        path: 'lunwen',
        query: {
          userId: this.userId
        }
      })
    },
    open(){
      this.$prompt('加入论文管理组织', {
        confirmButtonText: '立即加入',
        cancelButtonText: '取消',
        inputPattern: true,
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    }
  },
  created() {
    this.userId = this.$route.query.userId
    this.$parent.success = false;
    this.$parent.classbegin = true;
  }
}
</script>
<style scoped>

</style>