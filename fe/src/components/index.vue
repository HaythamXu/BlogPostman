<template>
    <div id="index">
 <!--        <div id="header">
            <div id="logo">Haytham Blog 1</div>
        </div> -->
        <Header></Header>
        <div id="content">
            <div id="content_main">
                <div
                    id="thumbnail_div"
                    v-for="(blog,key) in blogs"
                    v-on:click="openPostDetail(blog.id)"
                    v-bind:key="key"
                >
                    <blog_thumbnail
                        v-bind:postTitle="blog.title|postTitleEllipsis"
                        v-bind:post-date="blog.date"
                    ></blog_thumbnail>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import config from "../config/index.js"
    import blog_thumbnail from "./blog_thumbnail";
    import Header from "../components/header.vue";

    import axios from 'axios';
    export default {
        name: "index",
        data:function(){
            return {
                config:config,
                blogs:[]
            }
        },
        methods:{
            openPostDetail:function(id){
                this.$router.push("/postdetail/" + id)
            }
        },
        components:{
            blog_thumbnail,
            Header,
        },
        filters:{
            postTitleEllipsis:function(value){
                if(value.length >= 46){ 
                    window.console.log(value)
                    window.console.log(value.slice(0,36))
                    return value.slice(0,33) + ' ...'
                }else{
                    return value
                }
            }
        },
        created() {
            // call api here to get post list
            var _this = this
            this.config.init()
            window.console.log("getPostList: ",this.config.apis.getPostList)
            axios.get(this.config.apis.getPostList)
            .then(function(response){
                _this.blogs = response.data.posts
            })
            .catch(function(error){
                window.console.log(error)
            })
        },
        mounted(){
            // window.vue = this
        }
    }
</script>

<style scoped>
    * {
        /*border:0.1px solid black;*/
    }

    #index {
        height:100%;
        width:100%;
    }

    #header {
        height:5%;
    }

    #logo {
        width:15%;
        text-align : center;
        margin-left : 5%;
        margin-top : 1%;
    }

    #content {

        /*background-color aqua*/
        height : 95.5%;
        margin-top: 0.5%;
    }

    #content_main{
        box-shadow: rgba(0, 0, 0, 0.1) 0px 2px 3px 0px;
        width : 50%;
        height : 100%;
        margin-left : 25%;
        text-align : center;
    }
    #thumbnail_div{
        /*height: 50px;*/
    }

</style>