<template>
	<!-- 点击放大图 -->
	<view class="fullImg" v-show="showImg" @click="close">
		<image class="fullImg2" :src="fullImg" mode="aspectFit"></image>
	</view>
	<view class="page">
		<uni-forms ref="formRef" class="uni-form" :modelValue="data" :rules="formRules">
			<uni-forms-item name="title">
				<view class="title">
					<view style="flex-grow: 1; display: flex; justify-content: center;align-items: center;">
						<text style="line-height: 1.4em;">标题</text>
					</view>
					<view style="flex-grow: 9;">
						<input v-model="data.title" maxlength="15" type="text" placeholder="最多输入15字" />
					</view>
					
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
import {uploadImg,batchUploadImgs, getUserInfo, calSign} from '../../utils/util.js'
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

const close=()=>{
	showImg.value = false;
}
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



//发布
const save=()=>{
	formRef.value.validate().then((res)=>{
		const userInfo = getUserInfo()
		console.log(userInfo)
		if(userInfo === ""){
			uni.showToast({
				title:'😯请先登录～',
				duration: 1000,
				icon:'error'
			})
			uni.navigateTo({
				url: '/pages/login/login'
			})
			return false;
		}
		let timestamp = new Date().getTime()
		console.log(timestamp.toString())
		let sign = calSign(data, timestamp.toString(), userInfo.userId.toString())
		console.log(sign)
		//上传图片
		if(tempList.value.length > 0){
			let urlList = batchUploadImgs(tempList.value)
			console.log('urlList====', urlList)
			let mediaList = []
			for(let i=0;i<urlList.length;i++){
				mediaList.push({
					mType: 1,
					picUrl: urlList[i],
					videoUrl: ''
				})
			}
			console.log(mediaList)
			data.media.value = mediaList;
		}
		console.log('data-----',data)
		uni.request({
			url: 'http://122.51.70.205:8102/acomm/post/create',
			data: data,
			method:'POST',
			header:{
				uid: userInfo.userId,
				uToken: userInfo.token,
				timeStr: timestamp.toString(),
				sign: sign
			},
			success: function(res) {
				console.log(res.data);
				if(res.data.code===200){
					uni.showToast({
						title:'🐱发送成功～',
						duration: 1000,
						width: '50%'
					})
					uni.switchTab({
						url: '/pages/index/index'
					})
				}else{
					uni.showToast({
						title: res.data.msg,
						duration: 1000,
						icon:'error'
					})
				}
			},
		});
		return true;
	}).catch((err)=>{
		console.log(err)
		uni.showToast({
			title: err,
			duration: 1000,
			icon:'error'
		})
		return false;
	})
}

</script>

<style scoped>
.title{
	display: flex;
	flex-direction: row;
	align-items: center;
	margin: 35rpx;
	width: 100%;
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
	z-index: 8;
}
.fullImg{
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 200;
}
.fullImg2{
	width: 100%;
	height: 100%;
	z-index: 9999;
}

</style>