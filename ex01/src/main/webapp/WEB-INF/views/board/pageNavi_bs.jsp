<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="pageNo" value="${param.pageNo}" />
	<c:if test="${empty pageNo}">
		<c:set var="pageNo" value="1"/>
	</c:if>
	
	
	<c:set var="count" value="${total}"/>
	<c:if test="${not empty searchWord}" >
		<c:set var="count" value="${totalNow}"/>
	</c:if>
	
	
	<c:set var="pages" value="${count/10}"/>
	
	<c:set var="pageNumber" value="${pages+(1-(pages%1))%1}"/>
	<fmt:parseNumber var= "pageNumber" integerOnly= "true" value= "${pageNumber}" />
	
	<c:set var="make_endNo1" value="${pageNo/10.0}"/>
	<c:set var="make_endNo2" value="${make_endNo1+(1-(make_endNo1%1))%1}"/>
	<c:set var="endNo" value="${make_endNo2*10}"/>
	<c:set var="startNo" value="${endNo-9}"/>
	
	<fmt:parseNumber var="startNo" integerOnly="true" value="${startNo}" />
	
	<c:set var="endNo" value="${endNo>pageNumber ? pageNumber:endNo}"/>


	<nav aria-label="Page navigation example">
	<ul class="pagination">

	<%-- 앞으로 가기 버튼 --%>
	<c:if test="${pageNo ne pageNumber}">	
    	<li class="page-item"><a class="page-link" href="/board/list_bs?searchField=${param.searchField}&searchWord=${param.searchWord}&pageNo=${pageNumber}">&lt;&lt;</a></li>
		<li class="page-item"><a class="page-link" href="/board/list_bs?searchField=${param.searchField}&searchWord=${param.searchWord}&pageNo=${pageNo+1}">&lt;</a></li>
	</c:if>
	
	<%-- 버튼 생성 --%>
	<c:forEach begin="${startNo}" end="${endNo}" var="i" step="1">
		<li class="page-item"><a class="page-link" href="/board/list_bs?searchField=${param.searchField}&searchWord=${param.searchWord}&pageNo=${endNo - i+1}">${endNo - i+1}</a></li>
	</c:forEach>
	
		<%-- 첫페이지면 뒤로가기 버튼 안보여주기 --%>
	<c:if test="${pageNo ne 1}" var="res">
    	<li class="page-item"><a class="page-link" href="/board/list_bs?searchField=${param.searchField}&searchWord=${param.searchWord}&pageNo=${pageNo-1}">&gt;</a></li>
	    <li class="page-item"><a class="page-link" href="/board/list_bs?searchField=${param.searchField}&searchWord=${param.searchWord}&pageNo=1">&gt;&gt;</a></li>
	</c:if>
	
	</ul>
	</nav>
	

</body>
</html>