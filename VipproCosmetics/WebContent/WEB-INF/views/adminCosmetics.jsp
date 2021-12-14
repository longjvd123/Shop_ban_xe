<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/adminCosmetics.css" />
</head>
<body>
	<div id="container">
                <div id="menu">
 					<ul>
   						<li><a href="AdminCosmeticsServlet">SẢN PHẨM</a></li>
					    <li><a href="">HOÁ ĐƠN</a></li>
					    <li><a href="HomeServlet">TRANG CHỦ</a></li>
					</ul>
                </div><!--#menu-->
                <div id="content">
                	<div>
						<h2 style="color:white;background-color:blue">SẢN PHẨM</h2>
					</div>
                 	<table border="2">
						<tr>
							<th>STT</th>
							<th>image</th>
							<th>code</th>
							<th>name</th>
							<th>trademark</th>
							<th>Type</th>
							<th>description</th>
							<th>origin</th>
							<th>expirydate</th>
							<th>dateofmanufacture</th>
							<th>quantity</th>
							<th>price</th>
							<th>DELETE</th>
							<th>UPDATE</th>
						</tr>
						<c:forEach items="${cosmetics}" var="cosmetics" >
							<tr>
								<td>${cosmetics.id}</td>
								<td><img src="imageServlet?imageName=${cosmetics.image}" width="100px" height="100px"></td>
								<td>${cosmetics.code}</td>
								<td>${cosmetics.name}</td>
								<td>${cosmetics.trademark}</td>
								<td>${cosmetics.type}</td>
								<td>${cosmetics.description}</td>
								<td>${cosmetics.origin}</td>
								<td>${cosmetics.expirydate}</td>
								<td>${cosmetics.dateofmanufacture}</td>
								<td>${cosmetics.quantity}</td>
								<td>${cosmetics.price}</td>
								<td><a href="DeleteServlet?id=${cosmetics.id}">DELETE</a></td>
								<td><a href="UpdateServlet?id=${cosmetics.id}">UPDATE</a></td>
							</tr>
						</c:forEach>
					</table>
                </div>
                <div>
					<h2 style="color:white;background-color:blue">THÊM SẢN PHẨM</h2>
				</div>
				<jsp:include page="insertCosmetics.jsp"></jsp:include>
        </div>
        
</body>
</html>