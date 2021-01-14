<template>
	<div id="home">
<!--		<div v-html="compiledMarkdown"></div>-->
<!--		<mavon-editor v-model="value"/>-->
		<mavon-editor
			class="md"
			:value="input"
			:subfield = "prop.subfield"
			:defaultOpen = "prop.defaultOpen"
			:toolbarsFlag = "prop.toolbarsFlag"
			:editable="prop.editable"
			:scrollStyle="prop.scrollStyle"
		></mavon-editor>
	</div>
</template>

<script>
	// import axios from 'axios'
	import marked from 'marked'
	export default{
		name:'home',
		data:function(){
			return{
				input: '## Title 1\n' +
						'#### Title 4\n' +
						'\n' +
						'```\n'
			}
		},
		computed:{
			tempName:function(){
				return 0
			},
			compiledMarkdown: function () {
				// marked(this.input, { sanitize: true })
				return marked(this.input, { sanitize: true })
			},
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
			submits:function(){
				// 
			},
			apiCall:function(){
				// // let _this = this
				// axios.get('http://127.0.0.1:5000/')
				// 	.then(function(response){
				// 		window.console.log(response.data)
				// 	})
				// 	.catch(function(error){
				// 		window.console.log(error)
				// 	})


				// axios.post('http://10.130.228.110:5000/survey',{
				// 			value:this.value,
				// 		})
				// 	.then(function(response){
				// 		window.console.log(response)
				// 	})
				// 	.catch(function(error){
				// 		window.console.log(error);
				// 	})
				}
		},
		created: function () {

		},

	}
</script>

<style lang="stylus">
	#home
		overflow:scroll
		overflow-x:hidden
		background-color:antiquewhite
</style>
