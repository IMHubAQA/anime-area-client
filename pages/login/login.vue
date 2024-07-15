<template>
	<view class="page">
		<view class="title-banner">
			<text>萌喵酱</text>
		</view>
		<uni-forms ref="formRef" class="uni-form login" :modelValue="data" :rules="formRules">
			<uni-forms-item name="email">
				<view class="input-group">
					<image class="icon" src="../../static/email.png" mode="aspectFit"></image>
					<input class="input" v-model="data.email" placeholder="请输入邮箱"/>
				</view>
			</uni-forms-item>
			<uni-forms-item name="password">
				<view class="input-group">
					<image class="icon" src="../../static/passwd.png" mode="aspectFit"></image>
					<input class="input" v-model="data.password" type="password" placeholder="密码"/>
				</view>
			</uni-forms-item>
		</uni-forms>
		<view class="subtab">
			<view>去注册</view>
			<view>?忘记密码</view>
		</view>
		<button class="register" @click="login">登录ฅ</button>
	</view>
</template>

<script setup>
import {reactive,ref} from 'vue'
const data = reactive({
	email: '',
	password:''
})
const formRef = ref(null)

const formRules = reactive({
  // 表单验证规则
  // 对email字段进行必填验证
  email: {
  	rules: [{
				required: true,
				errorMessage: '请填写邮箱',
			},
			{
				format: 'email',
				errorMessage: '请输入正确的邮箱地址',
			}]
  },
	password: {
			rules: [{
					required: true,
					errorMessage: '请输入密码',
				},
				{
					minLength: 6,
					maxLength: 10,
					errorMessage: '请输入6-10位密码',
				}
			]
		},
})
const saveStorage=(v)=>{
	let prefix = 'userInfo'
	uni.setStorage({
		key: prefix,
		value: JSON.stringify(v)
	})
}
const login=()=>{
	formRef.value.validate().then((res)=>{
		//接口请求
			const requestTask = uni.request({
				url: 'http://122.51.70.205:8000/user/v1/login', //仅为示例，并非真实接口地址。
				data: data,
				method:'POST',
				success: function(res) {
					console.log(res.data);
					if(res.data.code===200){
						uni.showToast({
							title:'🐱登录成功～',
							duration: 1000,
							width: '50%'
						})
						saveStorage(res.data.data)
						//成功跳转详细信息
						uni.navigateTo({
							url: '/pages/index/index'
						})
					}else{
						uni.showToast({
							title:'😯'+res.data.msg,
							duration: 1000,
							icon:'error'
						})
					}
					
				}
			});
			return true;
		}).catch((err)=>{
			console.log("校验失败,",err)
			return false;
		})
}
</script>

<style scoped>
@import '../../static/css/global.css';

.title-banner{
	width: 100%;
	height: 30%;
	background-color: #FF5853;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 50rpx;
	font-weight: 900;
	color: white;
}
.login{
	margin-top: 100rpx;
}
.subtab{
	display: flex;
	width: 65%;
	justify-content: space-between;
	color: #979797;
}
</style>
