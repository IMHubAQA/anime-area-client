<template>
	<view class="item">
		<image class="tableItem" :src="img"></image>
		<text class="name">{{name}}</text>
	</view>

</template>

<script>

export default {
		props:{
			img:{
				type: String,
				required: true,
			},
			name:{
				type: String,
				required: true
			}
		},
		data() {
			const img = ref(this.$props.get('img'))
			return {
				img
			}
		},
		methods: {
			
		}
	}
</script>

<style scoped>
.tableItem{
	width: 100rpx;
	height: 100rpx;
}
.item{
	width: 100rpx;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.name{
	font-size: 20rpx;
}
</style>