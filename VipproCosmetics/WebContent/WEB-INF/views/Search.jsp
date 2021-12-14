<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/search.css" />
</head>
<body>
	<div class="content-nav">
		<form action="${pageContext.request.contextPath}/SearchCosmeticsServlet" method="POST">
			<input type="search" name="name" placeholder="Tìm kiếm sản phẩm..." />
			<button type="submit"><img src="imageServlet?imageName=OIP.jpg" width="35px" height="29px"></button>
		</form>
	</div>
</body>
</html>