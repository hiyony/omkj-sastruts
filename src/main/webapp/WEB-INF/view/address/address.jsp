<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Web Service</title>
<script>
	window.onunload = function () {
		window.opener.location.reload();
	}
</script>
<style>
	body{
		text-align : center;
	}
	input {
		padding : 5px 10px;
		text-align : center;
	}
</style>
</head>
<body>

	<h3>Omikuji Web Service</h3>
	
	<s:form method = "POST">
		<span>住所 : </span>
		<input type = "text" name = "address"
			   id = "address" onchange="checkNum();"
			   placeholder = "住所を入力してください"/>
		<div id = "addresslist">
			
		</div>
	</s:form>
<script>
	
	function getZipcode(){
		var address = document.getElementById("address").value;
		$.ajax({
			url: "http://localhoset:8083/omkj-sastruts/getaddress/",
			type: "POST",
			data: { homeaddress : address }
		}).done(function(zipcode)){
			$("#addresslist").append("<input type = 'radio' name = 'homeaddress' value = '" + homeaddress + "' >");
		}
	}
	
	function checkNum(){
		var address = document.getElementById("address").value;
		if(address.length < 3){
			alert('3文字以上の住所を入力してください！');
			document.querySelector('#address').value = '';
		}
	}
	
</script>
</body>
</html>