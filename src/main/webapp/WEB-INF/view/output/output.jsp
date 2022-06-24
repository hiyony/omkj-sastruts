<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic" %>
<%@ page import = "sastruts.omikuji.form.OutputForm" %>
<%@ page import = "sastruts.omikuji.dto.GetaddressDto" %>
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
		display : relative;
		justify-content: center;
	}
	#msg {
		color : red;
	}
	label{
		display: block;
		margin: 20px 0px;
	}
	.modal{
		width: 80%;
		height: 80%;
		padding: 20px;
		background: #fff;
		display: none;
	}
	.modal-content{
		height: 80%;
		padding: 20px 10px;
		overflow: hidden;
		overflow-y: auto;
		-webkit-overflow-scrolling: touch;
	}
	.overlay{
		display: none;
		position: fixed;
		width: 100%;
		height: 100%;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: rgba(0, 0, 0, 0.7);
	}
	.overlay.is-show{
		display: flex;
		justify-content: center;
		align-items: center;
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
		//GetaddressDto gadto = new GetaddressDto();
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
			
			<!-- MODAL AREA -->
			<div id = "js-overlay" class = "overlay">
				<div id = "modal" class = "js-modal modal"></div>
			</div>
			
			
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
	
	function checkmorethan3(){
		var address = document.getElementById("homeaddress").value;
		if(address.length < 3){
			alert('3文字以上で書いてください！');
			document.querySelector('#homeaddress').value = '';
		}
	}
	
	function selectZip(zipcode){
		document.getElementById('zipcode').value = zipcode;
		document.getElementById('js-overlay').classList.remove('is-show');
		document.getElementById('modal').style.display = 'none';
	}
	
	function getZipcode(){
		var address = document.getElementById("homeaddress").value;
		var zipcode = "";
		$.ajax({
			url: "http://localhost:8083/omkj-sastruts/getaddress/",
			type: "POST",
			data: { address : address },
			dataType: "json",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			statusCode:{
				200:function(zipcodelist){
					var count = Object.keys(zipcodelist).length;
					if(count === 0){
						alert('WRONG ADDRESS!');
						document.querySelector('#homeaddress').value = '';
						document.querySelector('#zipcode').value = '';
					} else if(count > 1){
						console.log('more than 1');
						/* $(".modal").fadeIn();
						$(".modal-content").click(function(){
							$(".modal").fadeOut();
						}); */
						
						var html = '<div class = "modal-content">';
						for(key in zipcodelist){
							var htmlParts =  '<label><input type="radio" name="zipcodeList" value="' 
							+ key + '" onchange="selectZip(' + key + ')">　' + key + "：" + zipcodelist[key] + '<label>';
							html += htmlParts;
							
						}
						html += "</div>";
						
						document.getElementById('modal').innerHTML = html;
						document.getElementById('js-overlay').classList.add('is-show');
						document.getElementById('modal').style.display = 'block';
						
					} else{
						console.log('200');
						for(key in zipcodelist){
							if(address.includes(zipcodelist[key])){
								zipcode = JSON.stringify(key);
								zipcode = zipcode.replaceAll('"', '');
								console.log(zipcode);
							}
						}
						$("#zipcode").val(zipcode);
					}
				}
			}
		}).done(function(zipcodelist){
			
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