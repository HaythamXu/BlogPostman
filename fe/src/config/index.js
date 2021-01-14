/**
	this is a config file for different brand webshop
*/
'use strict'

export default {
	"productionTip":false,

	baseUrl:"http://127.0.0.1:5000",
	
	apis:{
		"getPostList":"/postlist",
		"getPostDetail":"/getpost",
		"updatePost":"/updatepost",
		"createPost":"/createpost",
	},

	init:function(){
		this.apis.getPostList = this.baseUrl + this.apis.getPostList
		this.apis.getPostDetail = this.baseUrl + this.apis.getPostDetail
		this.apis.updatePost = this.baseUrl + this.apis.updatePost
		this.apis.createPost = this.baseUrl + this.apis.createPost
	}	
};
