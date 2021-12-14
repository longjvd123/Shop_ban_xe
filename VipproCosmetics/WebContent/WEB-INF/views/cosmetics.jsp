<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/cosmetics.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<h2 style="color:white;background-color:blue">SẢN PHẨM</h2>
	</div>
	<section class="wrapper">
	        <div class="products">
	            <ul>
	            	<c:forEach items="${cosmetics}" var="cosmetics" >
		                <li class="main-product">
		                    <div class="img-product">
		                        <img class="img-prd"
		                           src="imageServlet?imageName=${cosmetics.image}" width="350px" height="200px"
		                            alt="!!!">
		                    </div>
		                    <div class="content-product">
		                        <h3 class="content-product-h3"><a href="ReviewServlet?id=${cosmetics.id}">${cosmetics.name}</a></h3>
		                        <div class="content-product-deltals">
		                            <div class="price">
		                                <span class="money">${cosmetics.price}VNĐ</span>
		                            </div>
		                           <a href="${pageContext.request.contextPath }/cart?&action=buy&id=${cosmetics.id}">
		                           <img class="img-prd" src="imageServlet?imageName=2.png" width="100px" height="45px"></a>
		                        </div>
		                    </div>
		                </li>
		             </c:forEach>
				</ul>
			</div>	
	</section>
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>