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
	<jsp:include page="header.jsp"></jsp:include>
	<div >
		<h1 style="color:#ff8000;font-weight: 700;">KẾT QUẢ TÌM KIẾM</h1>
	</div>
	<jsp:include page="searchResults.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>