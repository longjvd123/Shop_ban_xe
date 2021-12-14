<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/review.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<h2 style="color:white;background-color:blue">MÔ TẢ SẢN PHẨM</h2>
	</div>
	<main class="container" >
		  <!-- Left Column / Headphones Image -->
		  <form action="${pageContext.request.contextPath}/ReviewServlet" method="POST" enctype="multipart/form-data">
		  <div class="left-column">
		    <img  src="imageServlet?imageName=${cosmetics.image}"  width="440px" height="445px" alt="!!! ">
		  </div>
		  <!-- Right Column -->
		  <div class="right-column">
			    <!-- Product Description -->
			    <div class="product-description">
			      <span >${cosmetics.type}</span>
			      <h1 >${cosmetics.name}</h1>
			      <p>${cosmetics.description}</p>
			    </div>
			    <!-- Product Pricing -->
			    <div class="product-price">
			      	 <span  >${cosmetics.price}VNĐ</span>
				</div>
				<div>
					<a href="${pageContext.request.contextPath }/cart?&action=buy&id=${cosmetics.id}">
					<img class="img-prd" src="imageServlet?imageName=2.png" width="100px" height="45px"></a>
				</div>
			</div>
			</form>
	</main>
	<div style="margin-bottom: 300px"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>