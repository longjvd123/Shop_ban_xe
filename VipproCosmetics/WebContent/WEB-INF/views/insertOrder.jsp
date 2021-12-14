<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/insertOrder.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="modal-body">
	    <div class="cart-row">
	        <span class="cart-item cart-header cart-column">Sản Phẩm</span>
	        <span class="cart-price cart-header cart-column">Giá</span>
	        <span class="cart-quantity cart-header cart-column">Số Lượng</span>
	    </div>
	    <c:set var="total" value="0"></c:set>
	    <c:forEach var="item" items="${sessionScope.cart }">
	    <c:set var="total" value="${total + item.cosmetics.price * item.quantity }"></c:set>
	    <div class="cart-items">
	        <div class="cart-row">
	        	<div class="cart-item cart-column">
	        	<img src="imageServlet?imageName=${item.cosmetics.image}" width="119px" height="112px">
	            <span class="cart-item-title">${item.cosmetics.name}</span>
	        	</div>
	        <span class="cart-price cart-column">${item.cosmetics.price}VNĐ</span>
	        <div class="cart-quantity cart-column">
	            <input type="text" class="cart-quantity-input" value="${item.quantity }" readonly>
	            <button class="btn btn-danger" type="button"><a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.cosmetics.id }"
						onclick="return confirm('Are you sure?')">Remove</a></button>
	        </div>
	    </div>
	    </c:forEach>
	    <div class="cart-total">
	        <strong class="cart-total-title">Total</strong>
	        <span class="cart-total-price">${total }VNĐ</span>
	    </div>
	</div>
	<button ><a href="${pageContext.request.contextPath }/HomeServlet">Tiếp tục mua hàng</a></button>
	<div class="container">
            <div class="login-form">
                <form action="${pageContext.request.contextPath}/InsertOrderServlet" method="POST" enctype="multipart/form-data">
                    <h1>THÔNG TIN MUA HÀNG</h1>
                    <div class="input-box">
                        <i >FULL-NAME</i>
                        <input type="text" name="name" ><br>
                    </div>
                    <div class="input-box">
                        <i >PHONE-NUMBER</i>
                        <input type="number" name="phoneNumber" ><br>
                    </div>
                    <div class="input-box">
                        <i >ADDRESS</i>
                        <input type="text" name="address" ><br>
                    </div>
                    <div class="input-box">
                        <i >TOTAL MONEY</i>
                        <input type="text" name="totalMoney" value="${total }" readonly="readonly"><br>
                    </div>
                    <div class="btn-box">
                        <input type="submit" value="Xác nhận" >
                    </div>
                </form>
            </div>
	</div>
	<div style="margin-top: 300px"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>