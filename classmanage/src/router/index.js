import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Enrol from "../views/Enrol.vue";
import Class from "../views/Class.vue";
import Lunwen from "../views/Lunwen.vue";
import Usersetting from "../views/Usersetting.vue";
import Oneteachclass from "@/views/Oneteachclass";

Vue.use(VueRouter)
import Oneclass from "../views/Oneclass.vue";
import Mywork from "../views/Mywork.vue";
const routes = [
    {
        path: '/Mywork',
        name: 'Mywork',
        component: Mywork,
    },
  {
    path: '/oneteachclass',
    name: '所教的一堂课',
    component: Oneteachclass
  },
    {
      path: '/Oneclass',
      name: 'Oneclass',
      component: Oneclass
    },
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/lunwen',
    name: 'Lunwen',
    component: Lunwen
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/Enrol',
    name: 'Enrol',
    component: Enrol,
  },
  {
    path: '/Class',
    name: 'Class',
    component: Class
  },
  {
    path: '/Usersetting',
    name: 'Usersetting',
    component: Usersetting,
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   //route level code-splitting
  //   //this generates a separate chunk (about.[hash].js) for this route
  //   //which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  routes
})

export default router
