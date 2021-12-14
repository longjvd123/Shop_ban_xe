<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/updateCosmetics.css" />
</head>
<body>
	<div id="container">
                <div id="menu">
 					<ul>
   						<li><a href="AdminCosmeticsServlet">SẢN PHẨM</a></li>
					    <li><a href="">HOÁ ĐƠN</a></li>
					</ul>
                </div><!--#menu-->
                <div id="content">
                	 <div class="login-form">
                <form action="${pageContext.request.contextPath}/UpdateServlet" method="POST" enctype="multipart/form-data">
                    <h1>CẬP NHẬT SẢN PHẨM</h1>
                    <input type="text" name="id" value="${cosmetics.id}" hidden="true">
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="code" value="${cosmetics.code}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="name" value="${cosmetics.name}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="trademark" value="${cosmetics.trademark}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="type" value="${cosmetics.type}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="description" value="${cosmetics.description}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" name="origin" value="${cosmetics.origin}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="date" name="expirydate" value="${cosmetics.expirydate}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="date" name="dateofmanufacture" value="${cosmetics.dateofmanufacture}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="number" name="quantity" value="${cosmetics.quantity}" required>
                    </div>
                    <div class="input-box">
                        <i ></i>
                       <input type="number" name="price" value="${cosmetics.price}" required><br>
                    </div>
                     <div class="input-box">
                        <i ></i>
                       <input type="file" name="image" >
                    </div>
                    <div class="btn-box">
                           <input type="submit" value="update">
                    </div>
                </form>
            </div>
                </div>
    </div>
</body>
</html>