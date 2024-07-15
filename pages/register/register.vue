<template>
	<view class="page">
		<view class="title">
			<text style="color:#fff; font-size: 50rpx;font-weight: 700;">萌喵酱</text>
		</view>
		<image class="avatar" :src="data.avatar" mode="aspectFill" @click="chooseImg"></image>
		<uni-forms ref="formRef" class="uni-form" :modelValue="data" :rules="formRules">
			<uni-forms-item name="email">
				<view class="input-group">
					<image class="icon" src="../../static/email.png" mode="aspectFit"></image>
					<input class="input" v-model="data.email" placeholder="请输入邮箱"/>
				</view>
			</uni-forms-item>
			<uni-forms-item name="code">
				<view class="input-group">
					<image class="icon" src="../../static/yanzhengma.png" mode="aspectFit"></image>
					<input class="input" v-model="data.code" placeholder="验证码"/>
					<button class="btn" @click="getVerifyCode" :disabled="countDownData.verifyCodeText !== '发送'">{{countDownData.verifyCodeText}}</button>
				</view>
			</uni-forms-item>
			<uni-forms-item name="password">
				<view class="input-group">
					<image class="icon" src="../../static/passwd.png" mode="aspectFit"></image>
					<input class="input" v-model="data.password" type="password" placeholder="密码"/>
				</view>
			</uni-forms-item>
		</uni-forms>

		<button class="register" @click="info">注册ฅ</button>
	</view>
</template>

<script setup>
import {reactive,ref} from 'vue'
const countDownData=reactive({
	verifyCodeText: '发送',
})
let timer = null;
const formRef = ref(null)
let countdown = 60;
const data=reactive({
	email: '',
	code: '',
	password:'',
	avatar: '../../static/avatar.png'
})
const chooseImg=()=>{
	uni.chooseImage({
		count: 1, // 最多可以选择的图片数量
		sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		success: (resp) => {
			console.log(resp.tempFilePaths[0])
			const filePath = resp.tempFilePaths[0] //图片临时路径
			const res = uploadImg(filePath)
		}
	})
}

const uploadImg=(filePath)=>{
	const uploadUrl = 'http://122.51.70.205:9081/anime-common/upload-image';
	const fileName = 'file'; // 文件参数的名称
	uni.uploadFile({
	    url: uploadUrl,
	    filePath: filePath,
	    name: fileName,
	    formData: {
	      // 其他表单数据
	      'userId': 'test'
	    },
	    success: (res) => {
	      console.log(res.data); // 服务器返回的响应数据
		  const resp = JSON.parse(res.data)
		  console.log(resp)
		  if(resp){
			  if(resp.code === 200){
			  	data.avatar = resp.data.downloadUrl
			  }
		  }
	    },
	    fail: (err) => {
	      console.error(err);
	    }
	});
}
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
  code: {
		rules: [{
				required: true,
				errorMessage: '请填写邮箱验证码!',
			},
			{
				minLength: 1,
				maxLength: 6,
				errorMessage: '请输入6位邮箱验证码',
			}
		]
	},

	password: {
			rules: [{
					required: true,
					errorMessage: '请设置密码!',
				},
				{
					minLength: 6,
					maxLength: 10,
					errorMessage: '请输入6-10位密码',
				}
			]
		},
})
const validateForm = () => {
  formRef.value.validate().then((res)=>{
		return true;
	}).catch((err)=>{
		console.log("校验失败,",err)
		return false;
	})
}
const info=()=>{
	formRef.value.validate().then((res)=>{
		//接口请求
			const requestTask = uni.request({
				url: 'http://122.51.70.205:8000/user/v1/register', //仅为示例，并非真实接口地址。
				data: data,
				method:'POST',
				success: function(res) {
					console.log('rrrrr',res);
					console.log(res.data);
					if(res.data.code===200){
						uni.showToast({
							title:'🐱注册成功～',
							duration: 1000,
							width: '50%'
						})
						//成功跳转详细信息
						uni.navigateTo({
							url: '/pages/info/info'
						})
						stopCountDown()
					}else{
						uni.showToast({
							title:'😯注册失败:'+res.data.msg,
							duration: 1000,
							icon:'fail'
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
const validateEmail=()=>{
	formRef.value.validateField('email').then((res)=>{
		return true;
	}).catch((err)=>{
		console.log("校验失败,",err)
		return false;
	})
}
const getVerifyCode = () => {
  if (timer) {
    // 正在倒计时
    return;
  }

  formRef.value.validateField('email').then((res) => {
    console.log(data.email);
    const requestTask = uni.request({
      url: 'http://122.51.70.205:8000/user/v1/verifyCode', //仅为示例,并非真实接口地址。
      data: {
        email: data.email,
      },
      success: function (res) {
        console.log(res.data);
        if (res.data.code !== 200) {
          console.log('-----');
          uni.showToast({
            title: res.data.msg,
            duration: 1000,
			icon:'error'
          });
          return; // 这里直接返回,不执行后续的倒计时逻辑
        }
        startCountDown(); // 只有在请求成功且code为200时,才开始倒计时
      },
      fail: function (res) {
        console.log(res);
        uni.showToast({
          title: '😯网络请求失败',
          duration: 1000,
          icon:'fail'
        });
        return; // 这里直接返回,不执行后续的倒计时逻辑
      },
    });
  }).catch((err) => {
    console.log('校验失败,', err);
    return false;
  });
};

const startCountDown = () => {
  timer = setInterval(() => {
    console.log(countdown);
    countdown--;
    countDownData.verifyCodeText = `${countdown}s`;
    if (countdown === 0) {
      stopCountDown();
    }
  }, 1000);
};
const stopCountDown=()=>{
	clearInterval(timer)
	timer = null;
	countdown=60;
	countDownData.verifyCodeText = '发送'
}

</script>

<style scoped>
@import '../../static/css/global.css';
.title{
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	background-image: linear-gradient(to bottom, #FF5853, #fff);
	height: 20%;
	color: #fff;
}

.avatar{
	margin-top: 75rpx;
	width: 200rpx;
	height: 200rpx;
	border-radius: 100rpx;
	margin-bottom: 80rpx;
}

</style>
