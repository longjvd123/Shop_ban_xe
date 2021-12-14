<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/header.css" />
</head>
<body>
	<header>
        <nav>
            <div class="img-nav">
               <img src="imageServlet?imageName=Screenshot 2021-04-18 143016.png" width="331px" height="121px">
            </div>
            <div class="content-nav">
                <ul>
                    <li><a href="HomeServlet">Trang Chủ</a></li>
                    <li><a href="ProductServlet">Sản Phẩm</a></li>
                    <li><a href="IntroduceServlet">Giới Thiệu</a></li>
                    <li><a href="AdminServlet">Admin</a></li>
                    <c:if test="${empty sessionScope.username}">
						<li><a href="LoginServlet" >Login</a></li>
					</c:if>
					<c:if test="${not empty sessionScope.username}">
						<li><a>${sessionScope.username}</a></li>/
						<li><a href="LogoutServlet">logout</a></li>
					</c:if>
                </ul>
            </div>
            <!-- The Modal -->
            <button id="cart">
                <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                <a href="cart"><img src="imageServlet?imageName=qw.png" width="83px" height="49px"></a> 
            </button>
        </nav>
        <nav>
        	<jsp:include page="Search.jsp"></jsp:include>
        </nav>
	</header>
</body>
</html>