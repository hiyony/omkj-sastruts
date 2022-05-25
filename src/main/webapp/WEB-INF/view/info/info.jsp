<%@ page import = "sastruts.omikuji.form.InfoForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<title>Omikuji Web Service</title>
<style>
	body {
		text-align : center;
	}
</style>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String zipcode = request.getParameter("postnumber");
		String homeaddress = request.getParameter("homeaddress");
		String emailaddress = request.getParameter("emailaddress");
	%>
	<h1>確認をお願いします！</h1>
	名前 : <%= name %><br>
	郵便番号 : <%= zipcode %><br>
	住所 : <%= homeaddress %><br>
	メールアドレス : <%= emailaddress %><br><br>
	<input type = "submit"
		   value = "送る" />

</body>
</html>