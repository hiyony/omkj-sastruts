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
	.modal{
		background-color : #fff;
		display : none;
		width : 350px;
		padding : 15px;
		text-align : center;
		border : 2px solid #333;
		
		opacity : 0.8;
		-moz-border-radius : 6px;
		-webkit-border-radius: 6px;
		-moz-box-shadow : 0 0 50px #ccc;
		-webkit-box-shadow : 0 0 50px #ccc;
	}
	
</style>
<script src = "https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
 

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
			住所 <input type = text name = "homeaddress" class = "js-modalinput" data-modal = "address"
							id = "homeaddress" onchange="checkmorethan3();getZipcode()"/>
			<a class = "btn" href = "#addresslist">検索</a><br>
			
			<!-- MODAL AREA -->
			<div id = "addresslist" class= "modal">
				<h4>住所リストの中であなたの住所を選んでください。</h4>
				<input type = "radio" name = "addresslist" value = "hey">
				<input type = "radio" name = "addresslist" value = "안녕">
				<p><button class="close"> 確定 </button></p>				
			</div>
			
			
			メールアドレス <input type = text name = "emailaddress" /><br><br>
	 		<input type = "submit" 
				   name = "submitbtn"
				   value = "保存する" 
				   formaction = "/omkj-sastruts/save/"
				   formmethod = "POST" />
		</div>
	</s:form>
	<script type = "text/javascript">
	$('a[href = "#addresslist"]').click(function(event){
		
	})
	
	function checkmorethan3(){
		var address = document.getElementById("homeaddress").value;
		if(address.length < 3){
			alert('3文字以上で書いてください！');
			document.querySelector('#homeaddress').value = '';
		}
	}
	
	function getZipcode(){
		var address = document.getElementById("homeaddress").value;
		$.ajax({
			url: "http://localhost:8083/omkj-sastruts/getaddress/",
			type: "POST",
			data: { address : address},
			statusCode:{
				200:function(zipcode){
					if(zipcode==null || zipcode==undefined || zipcode=="null"){
						alert('WRONG ADDRESS!');
						document.querySelector('#homeaddress').value = '';
						document.querySelector('#zipcode').value = '';
					} else{
						console.log('200');
					}
				}
			}
		}).done(function(zipcode){
			$("#zipcode").val(zipcode);
		}).fail(function(){
			console.log("fail..");
		}).always(function(){
			console.log("It works!");
		});
	}
		
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