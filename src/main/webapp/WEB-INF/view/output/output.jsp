<%@ page import = "sastruts.omikuji.form.OutputForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<style>
	body {
		text-align : center;
	}
	#list {
		display : flex;
		justify-content : center;
	}
</style>
</head>
<body>
	<% String bday = request.getParameter("birthday"); %>
	<h1>今日の運勢はどうですか？</h1>
	誕生日は<%= bday %>です。<br>
	今日の運勢は「<%= OutputForm.getUnsei() %>」です！
	<div id = "list">
		<ul>
			<li>願い事 : <%= OutputForm.getNegaigoto() %></li>
			<li>商い : <%= OutputForm.getAkinai() %></li>
			<li>学問 : <%= OutputForm.getGakumon() %></li>
		</ul>
	</div>
		<br><input type = "button" value = "戻る" onclick = "location.href = '/omkj-sastruts/input/'">
</body>
</html>