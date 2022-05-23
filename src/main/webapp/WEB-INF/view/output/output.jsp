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
	<% 
		String bday = request.getParameter("birthday"); 
		OutputForm outputForm;
	%>
	<h1>今日の運勢はどうですか？</h1>
	誕生日は<%= bday %>です。<br>
	今日の運勢は「${ dto.getOmikuji() }」です！
	<div id = "list">
		<ul>
			<li>願い事 : ${ dto.getNegaigoto() }</li>
			<li>商い : ${ dto.getAkinai() }</li>
			<li>学問 : ${ dto.getGakumon() }</li>
		</ul>
	</div>
		<br><input type = "button" value = "戻る" onclick = "location.href = '/omkj-sastruts/input/'">
	<br><br>
	<hr>
	<h2>結果を送る！あなたの情報を入力してください〜！</h2>
	<form>
		名前 <input type = text name = "name" />
		郵便番号 <input type = text name = "postnumber" />
		住所 <input type = text name = "homeaddress" />
		メールアドレス <input type = text name = "emailaddress" />
		<input type = "submit" value = "送る" />
	</form>
</body>
</html>