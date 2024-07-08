<template>
	<!--用户互动  -->
	<view class="relation">
		<!-- 点赞 -->
		<view class="item">
			<image class="img" src="/static/like.png" mode="widthFix"></image>
			<view class="num">1001</view>
		</view>
		<!-- 评论 -->
		<view class="item">
			<image class="img" src="/static/comment.png" mode="widthFix"></image>
			<view class="num">1002</view>
		</view>
		<!-- 收藏 -->
		<view class="item">
			<image class="img" src="/static/collect.png" mode="widthFix"></image>
			<view class="num">1002</view>
		</view>
		<!-- 转发 -->
	</view>
	
	
</template>

<script setup>
import {reactive} from 'vue'
const data=reactive({
	
})

</script>

<style scoped>
.relation{
	width: 100%;
	height: 75rpx;
	padding: 20rpx;
	display: flex;
	align-items: center;
	flex: 1;
	border-top: 1rpx solid #979797;
	margin-top: 30rpx;
}
.item{
	width: 20%;
	/* padding: 20rpx; */
	display: flex;
	align-items: center;
}
.img{
	width: 30%;
}
.num{
	margin-left: 10rpx;
}
</style>