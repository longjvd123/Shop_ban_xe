<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/adminOrder.css" />
</head>
<body>
	
	<div id="container">
                <div id="menu">
 					<ul>
   						<li><a href="AdminCosmeticsServlet">SẢN PHẨM</a></li>
					    <li><a href="AdminOrderServlet">HOÁ ĐƠN</a></li>
					    <li><a href="HomeServlet">TRANG CHỦ</a></li>
					</ul>
                </div><!--#menu-->
                <div id="content">
                	<div>
						<h2 style="color:white;background-color:blue">HOÁ ĐƠN</h2>
					</div>
                 	<table border="2">
						<tr>
							<th>STT</th>
							<th>name</th>
							<th>phoneNumber</th>
							<th>address</th>
							<th>totalMoney</th>
							<th>status</th>
							<th>DELETE</th>
						</tr>
						<c:forEach items="${order}" var="order" >
							<tr>
								<td>${order.id}</td>
								<td>${order.name}</td>
								<td>${order.phoneNumber}</td>
								<td>${order.address}</td>
								<td>${order.totalMoney}</td>
								<td>${order.status}</td>
								<td><a href="DeleteOrderServlet?id=${order.id}">DELETE</a></td>
							</tr>
						</c:forEach>
					</table>
                </div>
        </div>
</body>
</html>