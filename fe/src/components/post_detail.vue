<template>
    <div id="postDetail">
        <Header></Header>
        <div id="content">
            <div id="postTitle">
                {{postTitle}}
            </div>
            <mavon-editor
                id="postContent"
                :value="input"
                :subfield = "false"
                :defaultOpen = "'preview'"
                :toolbarsFlag = "false"
                :boxShadow="false"
                :transition="false"
            ></mavon-editor>
        </div>
    </div>
</template>

<script>
    import config from "../config/index.js"
    import axios from 'axios';
    import Header from "./header.vue";

    export default {
        name: "post_detail",
        data:function(){
            return{
                config:config,
                postTitle:'',
                input: ''
            }
        },
        components:{
            Header
        },
        computed:{
            tempName:function(){
                return 0
            },
            // compiledMarkdown: function () {
            //     // marked(this.input, { sanitize: true })
            //     return marked(this.input, { sanitize: true })
            // },
        },
        methods:{
            getPost:function(){
                var id = this.$route.params.id;
                this.id = this.$route.params.id
                var _this = this
                window.console.log("getPostDetail: ",this.config.apis.getPostDetail)
                axios.get(this.config.apis.getPostDetail,{
                    params:{
                        'id':id
                    }
                })
                .then(function(response){
                    _this.input = response.data.content
                    _this.postTitle = response.data.title
                })
                .catch(function(error){
                    window.console.log(error)
                })
            }
        },
        activated: function() {
            this.getPost()
        },
    }
</script>

<style scoped>
    *{
        /*border:0.1px solid black;*/
    }

    #postDetail {
        width:100%;
        height:100%;
    }

    #header{
        height: 5%;
    }

    #content{
        height: 95%;
        width: 60%;
        margin-left: 20%;
    }

    #postTitle {
        font-size: 1.1vw;
        background-color: rgb(251,251,251);
        /*box-shadow: rgba(0, 0, 0, 0.1) 0px 2px 12px 0px;*/
        /*transition:all 0.2s linear 0s;*/
        height:5%;
        text-align:center;

    }
    #postTitle::before{
        color: #24292e;
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }

    #postContent {
        min-height: 95%;
        font-size: 0.7vw;
    }

</style>



