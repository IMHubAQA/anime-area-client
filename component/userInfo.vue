<template>
	<view class="userInfo">
		<!-- 头像 -->
		<view>
			<image class="avater" :src="userInfo.avater"></image>
		</view>
		
		<view class="name">
			<!-- 昵称 -->
			<text class="nickname">{{userInfo.name}}</text>
			<!-- 性别 -->
			<image :src="genderSrc" class="gender"></image>
		</view>
	
	</view>
</template>

<script setup>
import {reactive, ref} from 'vue'
const genderSrc = ref('../static/man.png')
let props = defineProps({
	data: {
		type: String,
		required: false
	}
})
const userInfo = reactive({
	name: 'sss',
	gender: 1, //0男1女
	avater: 'http://pets-shop.oss-cn-beijing.aliyuncs.com/WechatIMG15.jpeg', //头像
})
const init=()=>{
	if(props.data){
		const data = JSON.parse(props.data)
		console.log(data)
		if(data){
			userInfo.name = data.name
			userInfo.avater = data.avater
			userInfo.gender = Number(data.gender)
			console.log(userInfo)
		}
	}
	if(userInfo.gender === 1){
		genderSrc.value='../static/woman.png'
	}
}
init()

</script>

<style scoped>
.avater{
	width: 100rpx;
	height: 100rpx;
	border-radius: 50rpx;
}
.userInfo{
	display: flex;
	width: 100rpx;
	height: 100rpx;
	border-radius: 50rpx;
	border: 1px solid black;
	align-items: center;
}
.gender{
	width: 50rpx;
	height: 50rpx;
	
}
.nickname{
	
}
.name{
	display: flex;
	flex-direction: column;
	margin-left: 20rpx;
}
</style>