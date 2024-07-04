<template>
	<view class="search-item">
		<view class="search">
			<input class="search-box" placeholder="客观你想要搜什么～" />
			<view class="btn">搜索</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {	
				
			}
		},
		methods: {
			
		}
	}
</script>

<style scoped>
.search{
	display: flex;
	flex-direction: row;
	align-items: center;
}
.search-item{
	width: 100%;
	display: flex;
	align-items: center;
}
.search-box{
	width: 500rpx;
	height: 65rpx;
	padding: 20rpx 20rpx;
	border: 1rpx solid #D9D9D9;
	border-radius: 20rpx;
	align-items: center;
	display: flex;
	justify-content: center;
}
.btn{
	margin-left: 20rpx;
}
</style>