<template>
	<view class="page">
		<view class="title">
			<text style="margin-right: 35rpx;line-height: 1.4em;">标题</text>
			<input v-model="title" maxlength="15" type="text" placeholder="最多输入15字" />
		</view>
		
		<textarea class="text" v-model="content" placeholder="[例如]今天猫耳娘出c,有人一起吗?" auto-height></textarea>
		<!-- 图片 -->
		<view class="upload">
			<image class="upload-btn" src="../../static/upload.png"></image>
			<text>上传照片</text>
		</view>
		<view>
			
		</view>
		<button class="register" @click="save">发布ฅ</button>
	</view>
</template>

<script>

	export default {
		data() {
			return {
				title: '',
				content: ''
			}
		},
		watch:{
			
		},
		methods: {
			
		}
	}
</script>

<style scoped>
.title{
	display: flex;
	flex-direction: row;
	align-items: center;
	margin: 40rpx;
}

.page{
	display: flex;
	flex-direction: column;
	width: 100%;
	height: 100vh;
}
.text{
	width: 90%;
	padding: 50rpx;
	min-height: 200rpx;
}
.upload{
	border: 2px solid rgba(151, 151, 151, 0.5);
	border-radius: 20rpx;
	width: 200rpx;
	height: 200rpx;
	margin-left: 50rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	color: rgba(151, 151, 151, 0.9);
}
.upload-btn{
	width: 100rpx;
	height: 100rpx;
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