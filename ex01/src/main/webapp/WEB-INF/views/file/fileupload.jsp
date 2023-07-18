<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<form method="post" enctype="multipart/form-data" 
			action="/file/fileuploadAction" name="fileuploadForm">
			
	<h2>파일선택</h2>
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>		
	<input type="file" name="files"><br>
	
	<button type="submit">파일업로드</button>		
	
	
	</form>

</body>
</html>