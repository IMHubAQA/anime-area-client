<template>
	<!-- 点击放大图 -->
	<view class="fullImg" v-show="showImg">
		<image :src="fullImg" ></image>
	</view>
	<view class="page">
		<uni-forms ref="formRef" class="uni-form" :modelValue="data" :rules="formRules">
			<uni-forms-item name="title">
				<view class="title">
					<text style="margin-right: 35rpx;line-height: 1.4em;">标题</text>
					<input v-model="data.title" maxlength="15" type="text" placeholder="最多输入15字" />
				</view>
			</uni-forms-item>		
			<uni-forms-item name="content">
				<textarea class="text" v-model="data.content" placeholder="[例如]今天猫耳娘出c,有人一起吗?" auto-height></textarea>
			</uni-forms-item>
		</uni-forms>

	
		<!-- 图片列表预览 -->
		<view class="imgList">
			<view class="img" v-for="(item, index) in tempList" :key="index">
				<image class="icon" src="../../static/icon/del.png" @click="deleteImg(item)"></image>
				<image class="imgItem" :src="item" mode="scaleToFill" @click="showFullImg(item)"></image>
			</view>
			<!-- 图片 -->
			<view :class="tempList.length === 0 ? 'upload': 'upload-hasimg'" @click="upload">
				<image class="upload-btn" src="../../static/upload.png"></image>
				<text>上传照片</text>
			</view>
		</view>
		<!-- 标签分类 -->
		<view>
			
		</view>
		<button class="register" @click="save">发布ฅ</button>
	</view>
</template>

<script setup>
import {reactive,ref} from 'vue'
import {uploadImg} from '../../utils/util.js'
const IMG_MAX_COUNT = 9;
const formRef = ref(null)
const data = reactive({
	postType: 1,
	title: '',
	content:'',
	category:[],
	media:[]
})
const fullImg = ref('')
const showImg = ref(false)
const tempList = ref([])

const chooseImg=()=>{
	uni.chooseImage({
		count: IMG_MAX_COUNT, // 最多可以选择的图片数量
		sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		success: (resp) => {
			console.log(resp.tempFilePaths)
			for(let i=0;i<resp.tempFilePaths.length;i++){
				tempList.value.push(resp.tempFilePaths[i]);
				console.log(tempList)
			}
		
		}
	})
}

const showFullImg=(item)=>{
	fullImg.value = item;
	showImg.value = true;
}

const deleteImg=(item)=>{
	var list = []
	tempList.value.forEach((value)=>{
		if(value !== item){
			list.push(value);
		}
	});
	tempList.value = list;
}

const upload=()=>{
	chooseImg()
}

const formRules = reactive({
  // 表单验证规则
  title: {
  	rules: [{
				required: true,
				errorMessage: '请输入标题呀～',
			},
			{
				minLength: 3,
				maxLength: 15,
				errorMessage: '请输入3-15个字的标题',
			}]
  },
  content: {
		rules: [{
				required: true,
				errorMessage: '请输入内容呀～',
			},
			{
				minLength: 15,
				maxLength: 500,
				errorMessage: '请输入至少15字内容，不超过500字',
			}
		]
	}
})

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
	width: 220rpx;
	height: 220rpx;
	margin-left: 50rpx;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	color: rgba(151, 151, 151, 0.9);
}
.upload-hasimg{
	border: 2px solid rgba(151, 151, 151, 0.5);
	border-radius: 20rpx;
	width: 220rpx;
	height: 220rpx;
	margin: 10rpx;
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
.img{
	position: relative;
}
.imgList{
	width: 100%;
	flex-wrap: wrap;
	display: flex;
	align-items: center;
}
.imgItem{
	width: 220rpx;
	height: 220rpx;
	margin: 10rpx;
}
.icon{
	width: 50rpx;
	height: 50rpx;
	position: absolute; 
	top: 10rpx;
	right: 10rpx;
	z-index: 8888;
}

</style>