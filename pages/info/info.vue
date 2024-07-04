<template>
	<view class="body">
		<view class="title">
			<text style="color:#fff; font-size: 50rpx;font-weight: 700;">萌喵酱</text>
		</view>
		<image class="avatar"  src="../../static/avatar.png" mode="aspectFit"></image>
		<view class="input-group">
			<text>出生日期</text>
			<view class="date-picker">
				<uni-datetime-picker type="date" :clear-icon="false" v-model="date" @maskClick="change" />
			</view>
		</view>
		<view class="input-group">
			<text>性别</text>
			<view class="radio-select">
				<uni-data-checkbox v-model="selectedValue" :localdata="options" />
			</view>
		</view>
		<view class="input-group">
			<text style="width: 100rpx;">昵称</text>
			<input class="input" placeholder="小主请填昵称~"/>
		</view>
		<button class="register" @click="save">保存ฅ</button>
	</view>
</template>

<script setup>

import {reactive, ref} from 'vue'
const date = ref('')
const selectedValue = ref(1)
const options=reactive([
	{ value: 1, text: '男' },
	{ value: 2, text: '女' },
  ])
const save=()=>{
	console.log("-------")
	uni.switchTab({
		url: '/pages/index/index'
	})
}
const change=()=>{
	console.log("**")
}
</script>

<style scoped>
.title{
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	background-image: linear-gradient(to bottom, #FF5853, #fff);
	height: 20%;
	color: #fff;
}
.date-picker{
	width: 400rpx;
	margin-left: 30rpx;
}
.picker{
	display: flex;
	align-items: center;
	width: 90%;
}
.input{
	width: 250rpx;
	padding-left: 20rpx;
	margin-left: 35rpx;
	border: 1rpx solid gray;
	height: 50rpx;
	border-radius: 10rpx;
	padding: 20rpx;
}
.avatar{
	margin-top: 50rpx;
	width: 200rpx;
	height: 200rpx;
	margin-bottom: 50rpx;
}
.body{
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100%;
	height: 100vh;
}
.input-group{
	display: flex;
	flex-direction: row;
	width: 80%;
	height: 100rpx;
	align-items: center;
	margin-top: 30rpx;
}
.icon{
	width: 100rpx;
	height: 75rpx;
/* 	border:1px solid #979797; */
}
.input{
	width: 500rpx;
	padding-left: 20rpx;
}
.btn{
	width: 150rpx;
	height: 80rpx;
	margin-left: -200rpx;
	background-color: #FF5853;
	border-radius: 30rpx;
	color: #fff;
	text-align: center;
}
.radio-select{
	width: 50%;
	margin-left: 100rpx;
	display: flex;
}
.register{
	width: 500rpx;
	height: 100rpx;
	margin-top: 75rpx;
	text-align: center;
	border-radius: 50rpx;
	background-color: #FF5853;
	color: #fff;
	font-size: 40rpx;
}
</style>
