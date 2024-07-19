import CryptoJS from "crypto-js";
export const uploadImg=(filePath)=>{
	const uploadUrl = 'http://122.51.70.205:9081/anime-common/upload-image';
	const fileName = 'file'; // 文件参数的名称
	console.log('rrrrrr', filePath)
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
		  console.log('res===',resp)
		  if(resp){
			  if(resp.code === 200){
			  	return resp.data.downloadUrl
			  }
		  }
	    },
	    fail: (err) => {
			
	      console.error('errr',err);
		  return ''
	    }
	});
	return ''
}

export const batchUploadImgs=(filePathList)=>{
	let list = []
	for(let i=0;i<filePathList.length;i++){
		let url = uploadImg(filePathList[i])
		console.log('url====',url, url.length)
		if(url.length > 0){
			list.push(url)
		}
	}
	return list
}
export const getUserInfo=()=>{
	let key = "userInfo"
	const userInfoJson = uni.getStorageSync(key)
	if(userInfoJson){
		const userInfo = JSON.parse(userInfoJson)
		return userInfo
	}
	return ""
}

export const calSign=(data, timeStr, uId)=>{
	let dataJson = JSON.stringify(data)
	let str = uId + timeStr + dataJson
	return CryptoJS.SHA256(str)
}