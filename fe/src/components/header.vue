<template>
    <div id="Header">
        <div v-if="headerType=='createPost'"  >
            <!-- <span id="logo2" @click="navigator('/')">Haytham Blog2</span> -->
            <span id="createPostDiv" @click="navigator('createpost')">Create Post</span>
        </div>
        <div v-else-if="headerType=='back'" id="backDiv" @click="navigator('back')">
            <span>Back</span>
        </div>
        <div v-else id="logo" @click="navigator('/')">
            <span>Haytham Blog</span>
            <!-- <span>Login</span> -->
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data:function(){
            return {
            }
        },
        props:{
            headerType:{    // normal, back, createPost
                type:String,
                default:"normal",
            },
        },
        methods:{
            navigator:function(targetPath){
                var currentPath = this.$route.name
                window.console.log("currentPath: ",currentPath)
                window.console.log("targetPath: ",targetPath)
                if(targetPath != currentPath){
                    if(targetPath == 'back'){
                        this.$router.back(-1)
                    }else{
                        this.$router.push(targetPath)
                    }
                }
            }
        },
        components:{
        },
        created() {
            window.console.log("headerType: ",this.headerType)
        }
    }
</script>

<style scoped>
    * {
        /*border:0.1px solid black;*/
    }
    #Header {
        height:3.5vh;
        box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 4px 0px;
    }
    #logo {
        height: 100%;
        width:15vw;
        text-align : center;
        margin-left : 5vw;
        font-size: 1.3vw;
        font-weight: 3500;
        /*background-color: green;*/
    }
    #logo::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
    #createPostDiv{
        width:15vw;
        text-align : center;
        /*margin-left : 5vw;*/
        float: right;
        height: 100%;
        font-size: 1.3vw;
        font-weight: 3500;
        /*background-color: green;*/
        height: 3.5vh;
    }
    #createPostDiv::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
    #backDiv{
        width:15vw;
        text-align : center;
        margin-left : 5vw;
        height: 100%;
        font-size: 1.3vw;
        font-weight: 3500;
    }
    #backDiv::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
    #logo2{
        height: 3.5vh;
        width:15vw;
        text-align : center;
        margin-left : 5vw;
        font-size: 1.3vw;
        font-weight: 3500;
        /*background-color: green;*/
    }
    #logo2::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
</style>