<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.addEventListener('load', function(){
		// 리스트 조회
		btnList.addEventListener('click', function(){
			getFileList();
		})
		
		// 파일 업로드
		btnFileupload.addEventListener('click', function(){
			// 웹 개발에서 HTML 폼 데이터를 
			// JavaScript로 쉽게 조작하고 전송하는 방법을 제공하는 API입니다
			let formData = new FormData(fileuploadForm);
			formData.append('name', 'momo');
			
			console.log("formData : ", formData);
			// FormData값 확인
			for(var pair of formData.entries()){
				if(typeof(pair[1]) == 'object'){
					let fileName = pair[1].name;
					let fileSize = pair[1].fileSize;
					
					
					
					console.log('fileName', fileName);
					console.log('fileSize', fileSize);
				}
			}
			
			fetch('/file/fileuploadActionFetch'
					, {
						method:'post'
						, body : formData
					})
					// 요청결과 json문자열을 javascript 객체로 반환
					.then(response => response.json())
					// 콜백함수 실행
					.then(map => fileuploadRes(map));
			
				
		});
	})

	function fileuploadRes(map){
		if(map.result == 'success'){
			divFileuploadRes.innerHTML = map.msg;
		}
	}
	
	function getFileList(){
		///file/list/{bno}
		let bno = document.querySelector("#bno").value;
		fetch('/file/list/'+bno)
			.then(response => response.json())
			.then(map => viewFileList(map));
		
	}
	
	function viewFileList(map){
		console.log(map);
		let content = '';
		if(map.list.length > 0){
			map.list.forEach(function(item, index){
				content += item.filename + '/' + item.savePath + '<br>';
			})
		} else {
			content = '등록된 파일이 없습니다.';
		}
		divFileupload.innerHTML = content;
		
	}
</script>
</head>
<body>
	<h2>파일 업로드</h2>
	<form method="post" enctype="multipart/form-data" 
			action="/file/fileuploadAction" name="fileuploadForm">
			
	<h2>파일선택</h2>
	bno : <input type="text" name="bno" id="bno" value="83"><br>
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>
	<br>
	<button type="submit">파일업로드</button>		
	<button type="button" id="btnFileupload">Fetch파일업로드</button>
	res : ${param.msg }
	<div id="divFileuploadRes"></div>
	
	</form>
	
	<h2>파일 리스트 조회</h2>
	<button type="button" id="btnList">리스트 조회</button>
	<div id="divFileupload"></div>
	

</body>
</html>














