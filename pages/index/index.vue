<template>
	<view class="index">
		<view class="search">
			<search-item></search-item>
		</view>
		<view class="publish-btn">
			<publish-btn @click="publish"></publish-btn>
		</view>
	
		<view class="content">
			<content-item></content-item>
		</view>
	</view>
</template>

<script setup>
import searchItem from '../../component/searchItem.vue'
import publishBtn from '../../component/publishBtn.vue'
import tabItem from '../../component/tabItem.vue'
import contentItem from '../../component/contentItem.vue'
const publish=()=>{
	uni.navigateTo({
		url: '/pages/publish/publish'
	})
}
</script>

<style scoped>
.index{
	position: relative;
	display: flex;
	flex-direction: column;
	align-items: center;
	/* height: 100vh; */
}
.search{
	margin-top: 20rpx;
	margin-bottom: 30rpx;
}
.publish-btn{
	position: absolute;
	top: 98vh;
	right: 0vw;
}
.content{
	width: 100%;
}
</style>
