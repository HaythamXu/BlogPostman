<template>
    <div id="createPost">
        <Header headerType="back"></Header>
        <div id="content">
            <div id="createTitle">
                <Input v-model="title" placeholder="Enter something..." style="width: 80%" />
                <Button style="width: 20%" @click="callAPIs">Submit</Button>
            </div>
            <div id="createContent">
                <mavon-editor 
                    id="mavonEditor" 
                    v-model="value"
                >   
                </mavon-editor>
            </div>
        </div>
    </div>
</template>

<script>
    import config from "../config/index.js"
    import axios from 'axios';
    import Header from "./header.vue";
    export default {
        name: "create_post",
        data:function () {
            return{
                path:'',
                value:'',
                title:'',
                config:config,
            }
        },
        components:{
            Header,
        },
        computed:{
            tempName:function(){
                return 0
            },
            // compiledMarkdown: function () {
            //     // marked(this.input, { sanitize: true })
            //     return marked(this.input, { sanitize: true })
            // },
            prop () {
                let data = {
                    subfield: false,// 单双栏模式
                    defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
                    editable: false,
                    toolbarsFlag: false,
                    scrollStyle: true
                }
                return data
            }
        },
        methods:{
            getPost:function(){
                var id = this.$route.params.id;
                this.id = this.$route.params.id;
                var _this = this;
                axios.get(this.config.apis.getPostDetail,{
                    params:{
                        'id':id,
                    }
                })
                .then(function(response){
                    // _this.input = response.data.content
                    // _this.postTitle = response.data.title
                    _this.title = response.data.title
                    _this.value = response.data.content
                })
                .catch(function(error){
                    window.console.log(error)
                })
            },
            updatePost:function(){
                // var _this = this
                // _this.config.init()
                var id = this.$route.params.id;
                axios.post(this.config.apis.updatePost,{
                        'id':id,
                        'title':this.title,
                        'content':this.value,
                        'author':'Haytham Xu',
                     })
                 .then(function(response){
                     window.console.log(response)
                 })
                 .catch(function(error){
                     window.console.log(error);
                 })
            },
            createPost:function(){
                axios.post(this.config.apis.createPost,{
                        'title':this.title,
                        'content':this.value,
                        'author':'Haytham Xu',
                     })
                 .then(function(response){
                     window.console.log(response)
                 })
                 .catch(function(error){
                     window.console.log(error);
                 })   
            },
            callAPIs:function(){
                if(this.path == "createpost"){
                    this.createPost()
                }else if(this.path == "postediter"){
                    this.updatePost()
                }else{
                    window.console.log("404")
                }
                this.$router.push("/account")
            },
        },
        activated: function() {
            // this.config.init()
            this.title = ''
            this.value = ''
            window.console.log("createpost: ",this.config.apis.createPost)
            window.console.log("updatepost: ",this.config.apis.updatePost)
            this.path = this.$route.name   // createpost      
            if(this.path == "createpost"){
                window.console.log("This is /createpost")
            }else if(this.path == "postediter"){
                this.getPost()
            }else{
                window.console.log("404")
            }
        },
        // created:function(){
        //     // this.config.init()
        //     this.getPost()
        //     window.console.log("created")
        // },
    }
</script>

<style scoped>
    #createPost{
        height: 100%;
        width: 100%;
    }

    #content{
        height: 95%;
    }

    #createTitle{
        background-color: chartreuse;
    }

    #createContent{
        background-color: aqua;
        height: 95%;
        /*position: absolute;*/
        /*top: 5%;*/
        /*width: 100%;*/
    }

    #mavonEditor{
        height:100%;
        width :100%;
    }
</style>