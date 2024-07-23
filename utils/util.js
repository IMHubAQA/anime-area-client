import CryptoJS from "crypto-js";
export const uploadImg=async(filePath)=>{
	const uploadUrl = 'http://122.51.70.205:9081/anime-common/upload-image';
	const fileName = 'file'; // 文件参数的名称
	const res = await uni.uploadFile({
		url: uploadUrl,
		filePath: filePath,
		name: fileName,
		formData: {
		  // 其他表单数据
		  'userId': 'test'
		}
	});
	const datas = JSON.parse(res.data)
	return datas.data.downloadUrl;
}


export const batchUploadImgs=async(filePathList)=>{
	let list = []
	for(let i=0;i<filePathList.length;i++){
		let url = await uploadImg(filePathList[i])
		console.log(url.length)
		if(url.length > 0){
			list.push(url)
		}
	}
	console.log(list)
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

export const calSign = (data, timeStr, uId) => {
  const dataJson = JSON.stringify(data);
  const str = uId + timeStr + dataJson;
  return CryptoJS.SHA256(str).toString();
}