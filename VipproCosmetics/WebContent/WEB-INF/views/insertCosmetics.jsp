<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/insertCosmetics.css" />
</head>
<body>
	<div class="container">
            <div class="login-form">
                <form action="${pageContext.request.contextPath}/InsertCosmeticsServlet" method="POST" enctype="multipart/form-data">
                    <h1>THÊM SẢN PHẨM</h1>
                    <div class="input-box">
                        <i>CODE</i>
                        <input type="text" name="code" placeholder="EX:SP01..."><br>
                    </div>
                    <div class="input-box">
                        <i >NAME</i>
                        <input type="text" name="name" ><br>
                    </div>
                    <div class="input-box">
                        <i >TRADEMARK</i>
                        <input type="text" name="trademark" ><br>
                    </div>
                    <div class="input-box">
                        <i >TYPE</i>
                        <input type="text" name="type" ><br>
                    </div>
                    <div class="input-box">
                        <i >DESCRIPTION</i>
                        <textarea rows="5" cols="54" name="description" placeholder="miêu tả sản phẩm"></textarea><br>
                    </div>
                    <div class="input-box">
                        <i >ORIGIN</i>
                        <input type="text" name="origin" ><br>
                    </div>
                    <div class="input-box">
                        <i >EXPERYDATE</i>
                        <input type="date" name="expirydate" ><br>
                    </div>
                    <div class="input-box">
                        <i >DATE OF MANUFACTURE</i>
                        <input type="date" name="dateofmanufacture" ><br>
                    </div>
                    <div class="input-box">
                        <i >QUANTITY</i>
                        <input type="number" name="quantity" ><br>
                    </div>
                    <div class="input-box">
                        <i >PRICE</i>
                        <input type="number" name="price" ><br>
                    </div>
                    <div class="input-box">
                        <i >IMAGE</i>
                       <input type="file" name="image" ><br>
                    </div>
                    <div class="btn-box">
                        <input type="submit" value="ADD" >
                    </div>
                </form>
            </div>
	</div>
</body>
</html>