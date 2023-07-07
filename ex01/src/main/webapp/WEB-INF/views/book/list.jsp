<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    


<%@include file="./header.jsp" %>
	<!-- 게시판 -->
	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header"></h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    	도서목록
	                </div>
	                <!-- 검색폼 -->
	                <!-- 검색폼끝 -->
	                <!-- /.panel-heading -->
	                <div class="panel-body">
	                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
	                        <thead>
	                            <tr>
	                                <th></th>
	                                <th>번호</th>
	                                <th>도서명</th>
	                                <th>작가</th>
	                                <th>대여여부</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                        
	                        <c:forEach items="${list }" var="vo">
	                            <tr class="odd gradeX">
	                                <td><input type="checkbox"></td>
	                                <td>${vo.no }</td>
	                                <td>${vo.title }</td>
	                                <td>${vo.author }</td>
	                                <td class="center">${vo.rentynStr }</td>
	                            </tr>
	                        </c:forEach>
	                        </tbody>
	                    </table>
	           <%@include file="../common/pageNavi.jsp" %>
	                    <!-- /.table-responsive -->
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    
	    
	</div>
	<!-- 게시판 끝-->
	
<%@include file="./footer.jsp" %>