import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home"
import Teacher from "../components/Teacher";
import Student from "../components/Student";
import TeacherAdd from "../components/TeacherAdd";
import StudentAdd from "../components/StudentAdd";

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', redirect: '/home'},
    {path: '/home', name: 'home', component: Home},
    {
      path: '/teacher', name: 'teacher', component: Teacher,
      children: [
        {path: '/add', name: 'teacheradd', component: TeacherAdd}
      ]
    },
    {
      path: '/student', name: 'student', component: Student,
      children: [
        {path: '/add', name: 'studentadd', component: StudentAdd}
      ]
    }
  ]
})
