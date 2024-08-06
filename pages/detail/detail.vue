<template>
	<view>
		<view class="content">
			<view class="author">
				<view class="author-info">
					<image class="avater" mode="aspectFill" :src="data.author.icon ? data.author.icon : '../static/avatar.png'"></image>
					<text class="name">{{data.author.name}}</text>
				</view>
				<!-- 关注 -->
				<view :class="isConcerned? 'icon-concerned': 'icon-concern'">
					{{ isConcerned? concerned:concern }}
				</view>
			</view>
			<view class="title">
				<text>{{data.postTitle}}</text>
			</view>
			<!-- 内容 -->
			<view class="neirong">
				{{data.postContent}}
			</view>
			<!-- 图片 -->
			<view class="imgs">
				<view class="list" v-for="media in data.media">
					<image class="imgItem" :src="media.picUrl" mode="aspectFill" @click="showFullImg(media.picUrl)"></image>	
				</view>
			</view>
		</view>
		
		<view class="relation">
			<!-- 点赞 -->
			<view class="item">
				<image class="img" src="/static/like.png" mode="widthFix"></image>
				<view class="num">{{data.LikeCnt}}</view>
			</view>
			<!-- 评论 -->
			<view class="item">
				<image class="img" src="/static/comment.png" mode="widthFix"></image>
				<view class="num">{{data.ReplyCnt}}</view>
			</view>
			<!-- 收藏 -->
			<view class="item">
				<image class="img" src="/static/collect.png" mode="widthFix"></image>
				<view class="num">{{data.collectCnt}}</view>
			</view>
			<!-- 转发 -->
		</view>
		
		<view class="comment-content">
			<textarea class="text-area" placeholder="评论..."></textarea>
		</view>
		
		<!-- 评论 -->
		
	</view>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { getContentDetail } from '../../utils/util.js'
import { onLoad, onShow } from "@dcloudio/uni-app"

const id = ref(0)
const isConcerned = ref(false)
const concerned = ref('已关注')
const concern = ref('+ 关注')

// Change this to a ref
const data = ref(null)

onLoad((options) => {
  id.value = options.id
  console.log(id.value)
  // Call getContentInfo here to ensure it runs after id is set
  getContentInfo(id.value)
})

onShow(() => {
  console.log(id.value)
  // You might not need to call getContentInfo here if it's already called in onLoad
  // But if you do need it, make sure to check if id.value exists
  if (id.value) {
    getContentInfo(id.value)
  }
})

const getContentInfo = async (id) => {
  try {
    let res = await getContentDetail(id)
    console.log('API response:', res)
    if (res.code === 200 && res.data) {
      data.value = res.data
      console.log('data set:', data.value)
	  
    } else {
      console.error('Invalid API response:', res)
    }
   }
   catch (error) {
    console.error('Error fetching content:', error)
  }
}

</script>

<style scoped>
.content{
	width: 100%;
	height: 100%;
}
.author{
	display: flex;
	align-items: center;
	margin: 20rpx;
}
.icon-concern{
	width: 80rpx;
	height: 75rpx;
	background-color: #FF5853;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 20rpx;
	font-size: 25rpx;
	flex-grow: 1;
}
.icon-concerned{
	width: 80rpx;
	height: 75rpx;
	background-color: #D9D9D9;
	color: #4D4D4D;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 25rpx;
	border-radius: 20rpx;
	flex-grow: 1;
}
.avater{
	width: 100rpx;
	height: 100rpx;
	border-radius: 50rpx;
}
.author-info{
	display: flex;
	flex-grow: 9;
	align-items: center;
}
.name{
	margin-left: 20rpx;
	color: #000;
}
.imgs{
	margin-top: 30rpx;
	display:flex;
	width: 100%;
	flex-wrap: wrap;
}
.list{
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}
.imgItem{
	width: 220rpx;
	height: 220rpx;
	margin: 10rpx;
}
.title{
	padding-left: 35rpx;
	margin-top: 25rpx;
	font-size: 40rpx;
	font-weight: 700;
	color: #1A64F4;
}
.neirong{
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
.comment-content{
	margin: 0 20rpx;
	border: 1px solid #D9D9D9;
	border-radius: 20rpx;
	height: 100rpx;
}
.text-area{
	padding: 20rpx;
}

</style>
