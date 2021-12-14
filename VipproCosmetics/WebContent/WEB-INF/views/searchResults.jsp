<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/searchResult.css" />
</head>
<body>
	<section class="wrapper">
	        <div class="products">
	            <ul>
	            	<c:forEach items="${cosmetics}" var="cosmetics" >
		                <li class="main-product">
		                    <div class="img-product">
		                        <img class="img-prd"
		                           src="imageServlet?imageName=${cosmetics.image}"
		                            alt="">
		                    </div>
		                    <div class="content-product">
		                        <h3 class="content-product-h3">${cosmetics.name}</h3>
		                        <div class="content-product-deltals">
		                            <div class="price">
		                                <span class="money">${cosmetics.price}</span>
		                            </div>
		                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
		                        </div>
		                    </div>
		                </li>
		             </c:forEach>
				</ul>
			</div>	
	</section>		
</body>
</html>