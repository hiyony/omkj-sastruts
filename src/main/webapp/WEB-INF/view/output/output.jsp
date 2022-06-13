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
							id = "zipcode" onchange="checkNum();getHomeaddress()" /><br>
			住所 <input type = text name = "homeaddress"
							id = "homeaddress" />
			<button type = "button"
					id = "addressbtn">住所を探す</button>
			<br>
			メールアドレス <input type = text name = "emailaddress" /><br><br>
	 		<input type = "submit" 
				   name = "submitbtn"
				   value = "保存する" 
				   formaction = "/omkj-sastruts/save/"
				   formmethod = "POST" />
		</div>
	</s:form>
	<script type = "text/javascript">
	
	$("#addressbtn").click(function(){
		var ww = 800;
		var wh = 500;
		
		var top = (screen.availHeight - wh) / 2;
		var left = (screen.availWidth - ww) / 2;
		
		window.open("/omkj-sastruts/address/", "window", "width=" + ww +", height=" + wh +", top="+ top 
				+", left=" + left +", toolbar=no, menubar=no, scrollbars=no, resizable=no");
	})
		
	function getHomeaddress(){
		var zipcode = document.getElementById("zipcode").value;
		$.ajax({
			url: "http://localhost:8083/omkj-sastruts/info/",
			type: "POST",
			data: { zcode : zipcode }
		}).done(function(homeaddress){
			$("#homeaddress").val(homeaddress);
		}).fail(function(){
			console.log("fail..");
		}).always(function(){
			console.log("It works!");
		});
	}

				
	function checkNum(){
		var zipcode = document.getElementById("zipcode").value;
		if(zipcode.length != 7){
			alert('7文字の郵便番号を入力してください！');
			document.querySelector('#zipcode').value = '';
		} /* else {
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
		} */
		
		/* $(document).ready(function(){
		$("zipcode").on('keyup', function(){
			var zipcode = document.getElementById("zipcode").value;
			console.log(zipcode);
			if(zipcode.length == 7){
				$.ajax({
					url: "http://localhost:8083/omkj-sastruts/info/",
					type: "POST",
					data: {zcode : $("#zipcode").val()}
				}).done(function(result){
					console.log(result);
					$("#homeaddress").val(result);
				}).fail(function(){
					console.log("fail");
				}).always(function(result){
					console.log("It works!");
				});
			} else { 
				alert('7文字の郵便番号を入力してください！');
				document.querySelector('#zipcode').value = '';
			}  
		});
	}); */
	} 
	</script>
</body>
</html>