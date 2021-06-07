<template>
  <div>
    <el-container style="text-align: center">
    <div style="margin: 0 auto">
      <el-menu v-show="success" class="el-menu-demo"  mode="horizontal" default-active="1" style="width: 100%" router>
        <el-menu-item>
          <img :src="logoUrl" idenxheight="50px" width="125"/>
        </el-menu-item>
        <el-menu-item index="1" style="margin-left: 100px" @click="tomain()">首页</el-menu-item>
        <el-menu-item index="2">产品功能</el-menu-item>
        <el-menu-item index="3">机构版</el-menu-item>
        <el-menu-item index="4">渠道合作</el-menu-item>
        <el-menu-item index="5">会员权益</el-menu-item>
        <el-menu-item index="6">帮助中心</el-menu-item>
        <el-menu-item >
          <i class="el-icon-sort" style="color: black;margin-left: 280px" ></i>
          <a href="https://v4.ketangpai.com/" style="margin-left: 0px" target="_blank" >切换旧版本</a>
        </el-menu-item >

        <el-menu-item>
          <el-button v-show="login" type="primary" plain @click="logining">登录</el-button>
          <el-button v-show="login" type="primary" @click="enrol">注册</el-button>
          <el-button v-show="islogin" type="primary" style="margin-top: 14px" @click="enterclass" size="mini" >进入课堂</el-button>
        </el-menu-item>
      </el-menu>
    </div>
    </el-container>
    <router-view></router-view>

  </div>
</template>

<script>

export default {
  data() {
    return {
      success: true,
      logoUrl: require('./assets/homepageimg/logo.png'),
      islogin: false,
      login: true,
      userId: '',
    };
  },
  methods: {
    tomain() {
      this.$router.push({
        path: '/'
      })
    },
    logining(){
      this.$router.push({
        path: '/login'
      });
    },
    enterclass(){
      this.$router.push({
        path: '/Class',
        query: {
          userId: this.$route.query.userId
        }
      }),
      this.success = false
    },
    enrol(){
      this.$router.push('/Enrol')
    }
  },
  created() {
    this.success = true;
    this.userId = this.$route.query.userId
  }
}
</script>

