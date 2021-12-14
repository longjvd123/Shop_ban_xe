<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/Register.css" />
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
            <div class="login-form">
                <form action="${pageContext.request.contextPath}/RegisterServlet" method="POST">
                    <h1>ĐĂNG KÝ</h1>
                    <div class="input-box">
                        <i >USER NAME</i>
                        <input type="text" placeholder="Nhập username" name="username">
                    </div>
                    <div class="input-box">
                        <i >PASS WORD</i>
                        <input type="password" placeholder="Nhập mật khẩu" name="password">
                    </div>
                    <div class="btn-box">
                        <button type="submit">
                           	XÁC NHẬN
                        </button>
                    </div>
                </form>
				<div style="color:red">${errorMessage}</div>
            </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>