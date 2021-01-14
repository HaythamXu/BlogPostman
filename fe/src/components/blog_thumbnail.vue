<template>
    <div id="blogThumbnail">
        <Row id="grid">
            <i-col id="postTitle" span="18">
                <span ref="titleWidth">{{postTitle|postTitleEllipsis}}</span>
            </i-col>
            <i-col id="postDate" span="6">
                <span>{{postDate|dateEllipsis}}</span>
            </i-col>
        </Row>
    </div>
</template>

<script>
    export default {
        name: "blog_thumbnail",
        props:{
            postTitle:String,
            postDate:String,
        },
        filters:{
            postTitleEllipsis:function(value){
                if(value.length >= 42){ 
                    return value.slice(0,42) + ' ...'
                }else{
                    return value
                }
            },
            dateEllipsis:function(value){
                return value.split(" ")[0]
            },
        },
        methods: {

        },
        mounted(){
            // var height= this.$refs.titleWidth.offsetHeight;
            // var tWidth = this.$refs.titleWidth.offsetWidth;
            // window.console.log(" height: ",height," width: ",tWidth)
        },
    }
</script>

<style scoped>
    * {
        /*border:0.1px solid black;*/
    }

    #blogThumbnail {
        /*height:100%;*/
        height: 35px;
        width:100%;
        /*background-color:chartreuse;*/
    }
    #grid {
        height: 100%;
        width: 90%;
        margin-left: 5%;
        border-bottom: 0.1px solid rgb(231,231,231);
        /*border-bottom-width: 2px;*/
    }
    #postTitle{
        height: 100%;
        display: inline-block;
        text-align: left;
        padding-left: 20px;
        font-size: 0.8vw;
    }
    #postTitle::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
    #postDate{
        /*text-align: right;*/
        height: 100%;
        display: inline-block;
        font-size: 0.8vw;
        /*background-color: green;*/
    }
    #postDate::before{
        display: inline-block;
        content: "";
        height: 100%;
        vertical-align: middle;
    }
</style>