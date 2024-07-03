<template>
	<view class="item">
		<image class="tableItem" :src="img"></image>
		<text class="name">{{name}}</text>
	</view>

</template>

<script setup>
import {ref} from 'vue'
let props = defineProps({
	img:{
		type: String,
		required: true,
	},
	name:{
		type: String,
		required: true
	}
})

const img = ref(props.img)
console.log(img)
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