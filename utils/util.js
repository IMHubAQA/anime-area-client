export const uploadImg=(filePath)=>{
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
			  	return resp.data.downloadUrl
			  }
		  }
	    },
	    fail: (err) => {
	      console.error(err);
		  return ''
	    }
	});
	return ''
}