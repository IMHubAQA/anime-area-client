<template>
	<view class="index">
		<view class="search">
			<search-item></search-item>
		</view>
		<view class="publish-btn">
			<publish-btn @click="publish"></publish-btn>
		</view>
		
	</view>
</template>

<script setup>
import searchItem from '../../component/searchItem.vue'
import publishBtn from '../../component/publishBtn.vue'
import tabItem from '../../component/tabItem.vue'
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
}
.publish-btn{
	position: absolute;
	top: 98vh;
	right: 0vw;
}
</style>
