<template>
	<view class="content">
		<user-info></user-info>
		<!-- 标题 -->
		<view>
			
		</view>
		<!-- 内容 -->
		<view>
			
		</view>
		<!-- 图片 -->
		<view>
			
		</view>
	</view>
</template>

<script setup>
import userInfo from '../component/userInfo.vue'

let props = defineProps({
	data: {
		type: String,
		required: false
	}
})


	
</script>

<style scoped>
.content{
	width: 100%;
	padding: 35rpx;
	background-color: bisque;
	height: 200rpx;
}
	
</style>