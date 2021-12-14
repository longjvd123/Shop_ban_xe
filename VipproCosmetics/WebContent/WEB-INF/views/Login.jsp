<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/login.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
            <div class="login-form">
                <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
                    <h1>ĐĂNG NHẬP</h1>
                    <div class="input-box">
                        <i >USER NAME</i>
                        <input type="text" placeholder="Nhập username" name="username">
                    </div>
                    <div class="input-box">
                        <i >PASS WORD</i>
                        <input type="password" placeholder="Nhập password" name="password">
                    </div>
                    <div class="btn-box">
                        <button type="submit">
                            LOGIN
                        </button>
                    </div>
                </form>
                <div class="btn-box">
                	<a href="RegisterServlet">
						<button>REGISTER</button>
					</a>
                </div>
				<div style="color:red">${errorMessage}</div>
            </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>