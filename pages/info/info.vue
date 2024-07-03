<template>
	<scroll-view class="page">
		<view class="title">
			<text style="color:#fff; font-size: 50rpx;font-weight: 700;">萌喵酱</text>
		</view>
		<image class="avatar" src="../../static/avatar.png" mode="aspectFit"></image>
		<view class="pickers">
		
		</view>
		
		
		<button class="register" @click="info">保存ฅ</button>
	</scroll-view>
</template>

<script>
	export default {
		data() {
			return {
				date:'2021-2-12'
			}
		},
		methods: {
			info(){
				uni.navigateTo({
					url: '/pages/info/info'
				})
			},
			maskClick(e:any){
				console.log('maskClick事件:', e);
			}
		},
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
.pickers{
	width: 300rpx;
	height: 100rpx;
	background-color: #FF5853;
}

.avatar{
	margin-top: 75rpx;
	width: 200rpx;
	height: 200rpx;
	border-radius: 100rpx;
	margin-bottom: 80rpx;
}
.page{
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100%;
	height: 100%;
}
.input-group{
	display: flex;
	flex-direction: row;
	width: 75%;
	height: 90rpx;
	align-items: center;
	border: 1px solid #979797;
	border-radius: 20rpx;
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
.register{
	width: 500rpx;
	height: 100rpx;
	margin-top: 75rpx;
	text-align: center;
	border-radius: 50rpx;
/* 	background-image: linear-gradient(to bottom, #FF5853, #FF5853 80%); */
	background-color: #FF5853;
	color: #fff;
	font-size: 40rpx;
}
</style>
