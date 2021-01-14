import Vue from 'vue';
import Router from 'vue-router';

import index from '../components/index';
import post_editer from "../components/post_editer.vue";
import post_detail from "../components/post_detail";
import account from "../components/account.vue";

Vue.use(Router)

export default new Router({
    mode:'history',
    routes:[
        {
            path:'/',
            component:index,
            name:'/',
        },
        {
            path:'/postediter/:id',
            component:post_editer,
            name:'postediter',
        },
        {
            path:'/postdetail/:id',
            component:post_detail,
            name:'postdetail',
        },
        {
            path:'/account',
            component:account,
            name:'account',
        },
        {
            path:'/createpost',
            component:post_editer,
            name:'createpost',
        },
    ]
})