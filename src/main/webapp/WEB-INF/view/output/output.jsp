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
	#sendform {
		display : block;
		justify-content: center;
	}
/* 	#list {
		display : flex;
		justify-content : center;
	} */
	#msg {
		color : red;
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
		<br><input type = "button" 
				   value = "戻る" 
				   onclick = "location.href = '/omkj-sastruts/input/'">
	<br><br>
	<hr>
	<br>
	<h1>結果を送る！あなたの情報を入力してください〜！</h1>
	<s:form>
		<div id = "sendform">
			名前 <input type = text name = "name" /><br>
			郵便番号 〒<input type = text name = "postnumber" 
							id = "zipcode" onchange = "checkNum();changetoAddress()" />
					<div id = "msg"></div>
			住所 <input type = text name = "homeaddress" /><br>
			メールアドレス <input type = text name = "emailaddress" /><br><br>
	 		<input type = "submit" 
				   name = "submitbtn"
				   value = "確認する" 
				   formaction = "/omkj-sastruts/info/"
				   formmethod = "POST" />
		</div>
	</s:form>
	
	<script language = "javascript" type = "text/javascript">
		/* Event Handler */
		
		function checkNum(){
			var zipcode = document.getElementById("zipcode").value;
			var msg = "7文字の郵便番号を入力してください！";
			if(zipcode.length < 7 || zipcode.length > 7){
				//document.getElementById("msg").innerHTML = msg;
				alert('7文字の郵便番号を入力してください！');
				document.querySelector('#zipcode').value = '';
			}
		}
		
		function changetoAddress(){
			var zipcode = document.getElementById("zipcode").value;
			
			if(zipcode.length == 7){
				
			}
		}
		
	</script>
</body>
</html>