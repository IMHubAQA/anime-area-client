<template>
	<scroll-view class="index">
		<view>
			<search-item></search-item>
		</view>
		<publish-btn @click="publish"></publish-btn>
		<tab-item img="../static/cute.png" name="vv"></tab-item>
	</scroll-view>
</template>

<script>
import searchItem from '../../component/searchItem.vue'
import publishBtn from '../../component/publishBtn.vue'
import tabItem from '../../component/tabItem.vue'
export default {
	components:{
		searchItem,
		publishBtn,
		tabItem
	},
	data() {
		return {
			
		}
	},
	methods: {
		publish(){
			uni.navigateTo({
				url: '/pages/publish/publish'
			})
		}
	}
}
</script>

<style scoped>
.index{
	position: relative;
}
</style>
