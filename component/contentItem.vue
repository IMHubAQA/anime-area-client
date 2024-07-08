<template>
	<view class="content-page">
		<user-info></user-info>
		<!-- 标题 -->
		<view class="title">
			<text>{{content.title}}</text>
		</view>
		<!-- 内容 -->
		<view class="content">
			{{content.content}}
		</view>
		<!-- 图片 -->
		<view class="list">
			<view class="item" v-for="img in content.imageList">
				<image class="img" :src="img" mode="aspectFill"></image>	
			</view>
		</view>
		<!-- 点赞回复 -->
		<user-relation></user-relation>
	</view>
</template>

<script setup>
import {reactive} from 'vue'
import userInfo from '../component/userInfo.vue'
import userRelation from '../component/userRelation.vue'

let props = defineProps({
	data: {
		type: String,
		required: false
	}
})
	
const content= reactive({
	content: '15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi15zi',
	title: 'hellohellohellohello',
	imageList:['http://pets-shop.oss-cn-beijing.aliyuncs.com/WechatIMG11.jpeg',
	'https://pets-shop.oss-cn-beijing.aliyuncs.com/WechatIMG12.jpeg',
	'https://pets-shop.oss-cn-beijing.aliyuncs.com/WechatIMG13.jpeg']
})
const init=()=>{
	if(props.data){
		const data = JSON.parse(props.data)
		content.value = data
	}
}
	
</script>

<style scoped>
.content-page{
	width: 100%;
	padding: 35rpx;
	height: 100%;
	border-top: 1rpx solid #979797;
	box-shadow: 5rpx #979797;
}
.title{
	padding-left: 35rpx;
	margin-top: 25rpx;
	font-size: 40rpx;
	font-weight: 700;
	color: #1A64F4;
}
.content{
	padding: 35rpx;
	margin-right: 35rpx;
	height: 100rpx;
	overflow-wrap: break-word;
	white-space: normal;
	word-break: break-word;
	line-height: 45rpx;
	text-overflow:ellipsis;
	overflow:hidden;
}
.list{
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: space-around;
	padding-right: 35rpx;
	margin-top: 20rpx;
}
.item{
	width: 30%;
	height: 200rpx;
}
.img{
	width: 100%;
	height: 100%;
}
</style>