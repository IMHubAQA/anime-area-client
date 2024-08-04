<template>
	<view>
		<view class="content">
			<view class="author">
				<view class="author-info">
					<image class="avater" mode="aspectFill" :src="data.author.icon ? data.author.icon : '../static/avatar.png'"></image>
					<text class="name">{{data.author.name}}</text>
				</view>
				<!-- 关注 -->
				<view :class="isConcerned? 'icon-concerned': 'icon-concern'">
					{{ isConcerned? concerned:concern }}
				</view>
			</view>
		</view>
		
	</view>
</template>

<script setup>

import { useRoute } from 'vue-router'
import {reactive, ref} from 'vue'
import {getContentDetail} from '../../utils/util.js'
const contentId = ref(0)
const route = useRoute()
console.log(route.query.id) // 获取页面跳转时传递的 id 参数

const isConcerned = ref(false)
const concerned=ref('已关注')
const concern=ref('+ 关注')
const data=reactive({
 "postId": 0,
 "postType": 0,
 "postTitle": "",
 "postContent": "",
 "media": [],
 "author": {
	 name: '',
	 icon:''
 },
 "LikeCnt": 0,
 "ReplyCnt": 0,
 "collectCnt": 0,
 "createTime": 0,
 "category": [],
 "onDoror": 0,
 "price": 0.1,
 "location": "",
 "mType": 0,
 "picUrl": "",
 "videoUrl": "",
 "uid": 0,
 "name": "",
 "icon": "",
 "id": 0
})


const getContentInfo=async(id)=>{
	let res = await getContentDetail(id)
	data.value = res.data
	console.log(data.value)
}
</script>

<style scoped>
.content{
	padding: 35rpx;
}
.author{
	display: flex;
	align-items: center;
}
.icon-concern{
	width: 80rpx;
	height: 75rpx;
	background-color: #FF5853;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 20rpx;
	font-size: 25rpx;
	flex-grow: 1;
}
.icon-concerned{
	width: 80rpx;
	height: 75rpx;
	background-color: #D9D9D9;
	color: #4D4D4D;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 25rpx;
	border-radius: 20rpx;
	flex-grow: 1;
}
.avater{
	width: 100rpx;
	height: 100rpx;
	border-radius: 50rpx;
}
.author-info{
	display: flex;
	flex-grow: 9;
	align-items: center;
}
.name{
	margin-left: 20rpx;
	color: #000;
}
</style>
