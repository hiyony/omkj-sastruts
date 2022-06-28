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
	
	function selectZip(zipcode, listaddress){
		if(listaddress.includes("以下に掲載がない場合")){
			//nothing happens 
		} else{
			document.getElementById('homeaddress').value = listaddress;
		}
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
						var html = '<div class = "modal-content">';
						var listaddress = "";
						for(key in zipcodelist){
							listaddress = zipcodelist[key];
							var htmlParts =  '<label><input type="radio" name="zipcodeList" value="' 
							+ key + '" onchange="selectZip(' + key + ', &quot' + listaddress + '&quot)" />' 
							+ key + "：" + listaddress + '<label>';
							html += htmlParts;
						}
						html += '</div>';
						
						document.getElementById('modal').innerHTML = html;
						document.getElementById('js-overlay').classList.add('is-show');
						document.getElementById('modal').style.display = 'block';
						
					/* 	var thisislist = document.getElementsByName("zipcodeList");
						var value = "";
						
						for(var i = 0; i<thisislist.length; i++){
							console.log(thisislist);
							if(thisislist[i].checked == true){
								value = thisislist[i].value;
							}
						}
						console.log("3##2");
					 	for(var i = 0; i < zipcodelist.size; i++){
							console.log("!!!!!!");
							
							if(value === zipcodelist[i].key){
								var selectaddress = zipcodelist[i].value;
								$("#homeaddress").val(selectaddress);
							} else if(zipcodelist[i].value.includes("以下に掲載がない場合")){
								//nothing changes 
								console.log("nothing is behind of address!");
							} else{
								console.log("nothing happens!");
							}
						} */
						
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
		} 
	} 
	</script>
	
</body>
</html>