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
<script src = "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
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
							id = "zipcode" /><br>
			住所 <input type = text name = "homeaddress" /><br>
			メールアドレス <input type = text name = "emailaddress" /><br><br>
	 		<input type = "submit" 
				   name = "submitbtn"
				   value = "確認する" 
				   formaction = "/omkj-sastruts/info/info.jsp"
				   formmethod = "POST" />
		</div>
	</s:form>
	<script type = "text/javascript">
	$(function(){
		$("zipcode").on('change', function(){
			var zipcode = document.getElementById("zipcode").value;
			
			if(zipcode.length < 7 || zipcode.length > 7){
				alert('7文字の郵便番号を入力してください！');
				document.querySelector('#zipcode').value = '';
			} else {
				$.ajax({
					url: "/info/",
					type: "POST",
					data: {zcode : $("#zipcode").val()}
				}).done(function(result){
					$("#homeaddress").val(result);
				}).fail(function(){
					alert("fail");
				}).always(function(result){
				}
			}
		});
	});
				
	/* function checkNum(){
		var zipcode = document.getElementById("zipcode").value;
		var msg = "7文字の郵便番号を入力してください！";
		if(zipcode.length < 7 || zipcode.length > 7){
			//document.getElementById("msg").innerHTML = msg;
			alert('7文字の郵便番号を入力してください！');
			document.querySelector('#zipcode').value = '';
		} else {
			$("#zipcode").on('change', function(){		
				$.ajax({
					url: "/info/", //서버 측에서 가져올 페이지 
					type: "POST", //GET 또는 POST 
					data: {
					zipcode : $("#zipcode").val() //서버 측에 전달할 파라미터 
					//homeaddress : homeaddress 
				},  
					datatype: "text" //html, javascript, text, xml, json 등이 있음 
									 //받아올 데이터의 데이터타입 
				}).done(function(result){
					$("#homeaddress").load(result);
				}).fail(function(){
					alert("失敗！！！！！");
				}).always(function(result){
					
				});
			});
		}
	} */	
	</script>
</body>
</html>