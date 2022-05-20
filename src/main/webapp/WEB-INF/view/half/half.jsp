<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Omikuji Web Service</title>
<style>
	body{
		text-align : center;
	}
	table {
		margin-left : auto;
		margin-right : auto;
	}
</style>
</head>
<body>
	<% String bday = request.getParameter("birthday"); %>
	<h1>Omikuji Web Service</h1>
	<h4>~「<%= bday %>」の半年前から今までの結果リスト ~</h4>
	<input type = "button" value = "戻る" onclick = "location.href = '/omkj-sastruts/input/'">
	<br><br>
	<table border = "1">
		<tr>
			<th>占い日</th>
			<th>誕生日</th>
			<th>おみくじのコード</th>
			<th>リニューアルの作成者</th>
			<th>リニューアルの日</th>
			<th>運勢の作成者</th>
			<th>運勢の作成日</th>
		</tr>
		<logic:iterate id = "HalfDto" name = "list">
		<tr>
			<td><bean:write name = "HalfDto" property = "uranaidate" format = "yyyy/MM/dd" /></td>
			<td><bean:write name = "HalfDto" property = "birthday" format = "yyyy/MM/dd" /></td>
			<td><bean:write name = "HalfDto" property = "omikujicode" /></td>
			<td><bean:write name = "HalfDto" property = "renewalwriter" /></td>
			<td><bean:write name = "HalfDto" property = "renewaldate" format = "yyyy/MM/dd"/></td>
			<td><bean:write name = "HalfDto" property = "unseiwriter" /></td>
			<td><bean:write name = "HalfDto" property = "unseiwritedate" format = "yyyy/MM/dd"/></td>
		</tr>
		</logic:iterate>
	</table>
</body>
</html>