<template>
	<view class="fullImg" v-show="showImg" @click="close">
		<image class="fullImg2" :src="fullImg" mode="aspectFit"></image>
	</view>
	<view class="index">
		<view class="search">
			<search-item></search-item>
		</view>
		<!-- 帖子列表 -->
		<view class="content-list">
			<view class="content-page" v-for="(item, index) in contentList">
				<!-- {{item}} -->
				<view class="userInfo">
					<!-- 头像 -->
					<view>
						<image class="avater" :src="item.author.icon? item.author.icon:'../static/avatar.png'" mode="aspectFill"></image>
					</view>
					<!-- 昵称 -->
					<text class="nickname">{{ item.author.name }}</text>
				</view>
				<!-- 标题 -->
				<view  @click="toDetail(item.postId)">
					<view class="title">
						<text>{{item.postTitle}}</text>
					</view>
					<!-- 内容 -->
					<view class="content">
						{{item.postContent}}
					</view>
				</view>
				<!-- 图片 -->
				<view class="imgs">
					<view class="list" v-for="media in item.media">
						<image class="imgItem" :src="media.picUrl" mode="aspectFill" @click="showFullImg(media.picUrl)"></image>	
					</view>
				</view>
				
				<view class="relation">
					<!-- 点赞 -->
					<view class="item">
						<image class="img" src="/static/like.png" mode="widthFix"></image>
						<view class="num">{{item.LikeCnt}}</view>
					</view>
					<!-- 评论 -->
					<view class="item">
						<image class="img" src="/static/comment.png" mode="widthFix"></image>
						<view class="num">{{item.ReplyCnt}}</view>
					</view>
					<!-- 收藏 -->
					<view class="item">
						<image class="img" src="/static/collect.png" mode="widthFix"></image>
						<view class="num">{{item.collectCnt}}</view>
					</view>
					<!-- 转发 -->
				</view>
			</view>
		</view>
		
		<view class="publish">
			<publish-btn @click="publish"></publish-btn>
		</view>
	</view>
</template>

<script setup>
import searchItem from '../../component/searchItem.vue'
import publishBtn from '../../component/publishBtn.vue'
import tabItem from '../../component/tabItem.vue'
import {getContentList} from '../../utils/util.js'
import { reactive,onMounted,ref } from 'vue'
import { onLoad, onShow } from "@dcloudio/uni-app"
const publish=()=>{
	uni.navigateTo({
		url: '/pages/publish/publish'
	})
}
const fullImg = ref('')
const showImg = ref(false)
const tempList = ref([])

const close=()=>{
	showImg.value = false;
}
const showFullImg=(item)=>{
	fullImg.value = item;
	showImg.value = true;
}
const contentList=reactive([])
const req=reactive({
	page: 1,
	pageSize: 10,
	postType: 1
})
const queryContentList=async()=>{
	const res = await getContentList(req)
	if (res.data && res.data.postList) {
	    contentList.splice(0, contentList.length, ...res.data.postList)
	}
}
const toDetail=(index)=>{
	uni.navigateTo({
		url: '/pages/detail/detail?id='+index,
	})
}
onLoad(()=>{
	queryContentList()
})
onShow(()=>{
	queryContentList()
})

queryContentList()

</script>

<style scoped>
@import '../../static/css/global.css';
.content-page{
	width: 100%;
	padding: 35rpx;
	height: 100%;
	margin-top: 20rpx;
	box-shadow: 5rpx #979797;
	background-color: white;
}
.content-list{
	background-color: #D9D9D9;
	width:100%;
}
.content{
	padding: 20rpx;
	margin-right: 35rpx;
	height: 100rpx;
	overflow-wrap: break-word;
	white-space: normal;
	word-break: break-word;
	line-height: 45rpx;
	text-overflow:ellipsis;
	overflow:hidden;
}
.index{
	position: relative;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.search{
	background-color: white;
	margin-top: 20rpx;
	margin-bottom: 30rpx;
}
.publish{
	position: fixed;
	right: 30rpx;
	bottom: 30rpx;
}
.avater{
	width: 100rpx;
	height: 100rpx;
	border-radius: 50rpx;
}
.imgItem{
	width: 220rpx;
	height: 220rpx;
	margin: 10rpx;
}
.userInfo{
	display: flex;
	width: 300rpx;
	height: 100rpx;
	align-items: center;
}
.nickname{
	display: flex;
	flex-direction: column;
	margin-left: 20rpx;
}
.title{
	padding-left: 35rpx;
	margin-top: 25rpx;
	font-size: 40rpx;
	font-weight: 700;
	color: #1A64F4;
}
.relation{
	width: 100%;
/* 	height: 75rpx; */
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
.list{
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}
.imgs{
	display:flex;
	width: 100%;
	flex-wrap: wrap;
}
</style>
