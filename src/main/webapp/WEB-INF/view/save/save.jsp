<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Omikuji Web Service</title></head>
<style>
	body{
		text-align : center;
	}
	table{
		margin-left : auto;
		margin-right : auto;
	}
</style>

<body>
	<h1>Omikuji Web Service</h1>
	<h4>~ Database List ~</h4>
	<input type = "button" value = "最初の画面へ" onclick = "location.href = '/omkj-sastruts/input/'" />
	<br><br>
	<table border = "1">
		<tr>
			<th>名前</th>
			<th>郵便番号</th>
			<th>住所</th>
			<th>メール</th>
		</tr>
		<logic:iterate id = "SaveDto" name = "list">
			<tr>
				<td><bean:write name = "SaveDto" property = "name" /></td>
				<td><bean:write name = "SaveDto" property = "zipcode" /></td>
				<td><bean:write name = "SaveDto" property = "homeaddress" /></td>
				<td><bean:write name = "SaveDto" property = "emailaddress" /></td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>