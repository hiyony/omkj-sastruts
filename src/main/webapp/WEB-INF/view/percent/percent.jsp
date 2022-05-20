<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Omikuji Web Service</title>
</head>
<body>
	<% String bday = request.getParameter("birthday"); %>
	<h1>Omikuji Web Service</h1>
	<h4>~ 「<%= bday %>」の運勢結果割合 ~</h4>
	<input type = "button" value = "戻る" onclick = "location.href = '/omkj-sastruts/input/'">
	<br><br>
	<table border = "1">
		<tr>
			<th>運勢名</th>
			<th>運勢数</th>
			<th>運勢の割合</th>
		</tr>
	</table>
</body>
</html>