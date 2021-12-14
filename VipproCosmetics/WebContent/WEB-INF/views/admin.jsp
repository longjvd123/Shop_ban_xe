<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" />
</head>
<body>
	<div id="container">
                <div id="menu">
 					<ul>
 						<li>
 							<c:if test="${empty sessionScope.username}">
								<li><a href="LoginServlet" >Login</a></li>
							</c:if>
							<c:if test="${not empty sessionScope.username}">
								<li><a>${sessionScope.username}</a></li>/
								<li><a href="LogoutServlet">logout</a></li>
							</c:if>
 						</li>
   						<li><a href="AdminCosmeticsServlet">SẢN PHẨM</a></li>
					    <li><a href="AdminOrderServlet">HOÁ ĐƠN</a></li>
					     <li><a href="HomeServlet">TRANG CHỦ</a></li>
					</ul>
                </div><!--#menu-->
 
                <div id="content">
                 <img src="imageServlet?imageName=Untitled.png" width="1000px" height="1000px">
                </div>
        </div>
</body>
</html>