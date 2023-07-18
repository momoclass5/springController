<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.addEventListener('load', function(){
		btnList.addEventListener('click', function(){
			getFileList();
		})
	})

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
				content += item.filename + '<br>';
			})
		} else {
			content = '등록된 파일이 없습니다.';
		}
		divFileupload.innerHTML = content;
		
	}
</script>
</head>
<body>
res : ${param.msg }
	<h2>파일 업로드</h2>
	<form method="post" enctype="multipart/form-data" 
			action="/file/fileuploadAction" name="fileuploadForm">
			
	<h2>파일선택</h2>
	bno : <input type="text" name="bno" id="bno" value="83"><br>
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>
	
	<button type="submit">파일업로드</button>		
	
	
	</form>
	
	<h2>파일 리스트 조회</h2>
	<button type="button" id="btnList">리스트 조회</button>
	<div id="divFileupload"></div>
	

</body>
</html>














