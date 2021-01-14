<template>
    <div id="account" v-if="status && active">
        <Header headerType="createPost"></Header>
        <div id="content">
            <div id="content_main">
                <div
                    id="thumbnail_div"
                    v-for="(blog,key) in blogs"
                    v-on:click="openPostDetail(blog.id)"
                    v-bind:key="key"
                >
                    <blog_thumbnail
                        v-bind:postTitle="blog.title"
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
    import Header from "./header.vue";

    import axios from 'axios';

    export default {
        name: "account",
        data:function(){
            return {
                config:config,
                blogs:[],
                status:false,
                active:false,
            }
        },
        components:{
            Header,
            blog_thumbnail,
        },
        methods:{
            openPostDetail:function(id){
                this.$router.push("/postediter/" + id)
            },
            navigator:function(){
                this.$router.push("/createpost")
            },
            getPostList:function(){
                var _this = this
                axios.get(this.config.apis.getPostList)
                .then(function(response){
                    _this.blogs = response.data.posts
                })
                .catch(function(error){
                    window.console.log(error)
                })
            },
            setConfig:function(){
                window.console.log("createpost: ",this.config.apis.createPost)
                window.console.log("updatepost: ",this.config.apis.updatePost)
                this.config.init()
                window.console.log("createpost: ",this.config.apis.createPost)
                window.console.log("updatepost: ",this.config.apis.updatePost)
                this.getPostList()
            }
        },
        created(){
            // window.console.log("createpost: ",this.config.apis.createPost)
            // window.console.log("updatepost: ",this.config.apis.updatePost)
            // this.config.init()
            // this.status = true
            // window.console.log("createpost: ",this.config.apis.createPost)
            // window.console.log("updatepost: ",this.config.apis.updatePost)
            // this.getPostList()
        },
        mounted(){
            window.haytham = this
        }
    }
</script>

<style scoped>
    * {
        /*border:0.1px solid black;*/
    }
    #account {
        height:100%;
        width:100%;
    }
    #logo {
        width:15vw;
        text-align : center;
        margin-left : 5%;
        /*margin-top : 1%;*/
        height: 100%;
        font-weight: 350;
        font-size: 1.5vw;
    }
    #logo::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
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