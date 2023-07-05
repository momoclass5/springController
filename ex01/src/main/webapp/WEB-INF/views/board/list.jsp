<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// 메세지 처리
	let msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
</script>

</head>
<body>
<h2>게시판 리스트</h2>
${list }
</body>
</html>