<template>
	<view class="page">
		<view class="head">
			<view class="group" @click="chat">
				<image class="icon" :src="iconImg.chat" mode="aspectFit"></image>
				<text>聊天</text>
			</view>
			<view class="group" @click="like">
				<image class="icon" :src="iconImg.like" mode="aspectFit"></image>
				<text>点赞</text>
			</view>
			<view class="group" @click="comment">
				<image class="icon" :src="iconImg.comment" mode="aspectFit"></image>
				<text>评论</text>
			</view>
		</view>
		<!-- 聊天 -->
		<view class="chat-group" v-show="iconImg.selected === 0" v-for="item in userList">
			<!-- 用户信息 -->
			<view class="user-info">
				<!-- 头像 -->
				<view class="ava">
					<image class="avatar" :src="item.avatar" mode="aspectFill"></image>
				</view>
				
				<!-- 昵称 -->
				<view class="names">
					<text class="nickname">{{item.name}}</text>
					<text class="msg">{{item.shortMsg}}</text>
				</view>
				<!-- 时间 -->
				<view class="time">
					<text>11:20 a.m.</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script setup>
import {reactive, ref} from 'vue'
const icons = {
	chat: [
		'../../static/icon/message/chat.png',
		'../../static/icon/message/chat_s.png'
	],
	like: [
		'../../static/icon/message/like.png',
		'../../static/icon/message/like_s.png'
	],
	comment: [
		'../../static/icon/message/comment.png',
		'../../static/icon/message/comment_s.png'
	]
}
const iconImg=reactive({
	chat: icons.chat[1],
	like: icons.like[0],
	comment: icons.comment[0],
	selected: 0
})
const chat=()=>{
	iconImg.chat = icons.chat[1]
	iconImg.like = icons.like[0]
	iconImg.comment =  icons.comment[0]
	iconImg.selected = 0;
}
const like=()=>{
	iconImg.like = icons.like[1]
	iconImg.comment = icons.comment[0]
	iconImg.chat = icons.chat[0]
	iconImg.selected = 1;
}
const comment=()=>{
	iconImg.comment = icons.comment[1]
	iconImg.chat = icons.chat[0]
	iconImg.like = icons.like[0]
	iconImg.selected = 2;
}
const userList=reactive([
	{
		"avatar": 'http://anime-area.oss-cn-beijing.aliyuncs.com/test/1720603252323-WechatIMG3.jpeg',
		"name": '猫猫',
		"shortMsg": 'hello，今晚可以...'
	},
	{
		"avatar": 'http://anime-area.oss-cn-beijing.aliyuncs.com/test/1720603594163-WechatIMG4.jpeg',
		"name": '狗狗',
		"shortMsg": 'hello，今晚可以...'
	},
	{
		"avatar": 'http://anime-area.oss-cn-beijing.aliyuncs.com/test/1720603252323-WechatIMG3.jpeg',
		"name": '猫猫',
		"shortMsg": 'hello，今晚可以...'
	}
])


</script>

<style scoped>
@import '../../static/css/global.css';
.head{
	width: 100%;
	height: 120rpx;
	display: flex;
	justify-content: space-evenly;
	padding-top: 50rpx;
	border-bottom: 1rpx solid #979797;
}
.group{
	width: 100rpx;
	height: 100rpx;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	
}
.icon{
	width: 80rpx;
	height: 80rpx;
}
.chat-group{
	width: 100%;
	display: flex;
	flex-direction: column;
}
.user-info{
	width: 100%;
	display: flex;
	height: 150rpx;
	padding: 10rpx;
	align-items: center;
	border-bottom: 1rpx solid #979797;
}
.ava{
	flex-grow:1;
	display: flex;
	justify-content: center;
	align-items: center;
}
.avatar{
	width: 120rpx;
	height: 120rpx;
	border-radius: 60rpx;
}
.names{
	display: flex;
	flex-direction: column;
	flex-grow: 3;
}
.msg{
	margin-top: 10rpx;
	font-size: 35rpx;
	color: #979797;
}
.nickname{
	color: black;
	font-size: 40rpx;
}
.time{
	flex-grow:1;
	color: #4D4D4D;
}
</style>
