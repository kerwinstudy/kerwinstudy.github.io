var userName = null;
//var birthday = null;
var email = null;
var userId = null;
//var userRole = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	userName = $("#userName");
	// birthday = $("#birthday");
	// phone = $("#phone");
	//userRole = $("#userLevel");
	email = $("#email");
	saveBtn = $("#save");
	backBtn = $("#back");
	userId=$("#userId");
	userName.next().html("*");
	//birthday.next().html("*");
	//phone.next().html("*");
	//userLevel.next().html("*");
	email.next().html("*");
	userId.next().html("*");

	
	// $.ajax({
	// 	type:"GET",//请求类型
	// 	url:path+"/jsp/user.do",//请求的url
	// 	data:{method:"getrolelist"},//请求参数
	// 	dataType:"json",//ajax接口（请求url）返回的数据类型
	// 	success:function(data){//data：返回数据（json对象）
	// 		if(data != null){
	// 			var rid = $("#rid").val();
	// 			userRole.html("");
	// 			var options = "<option value=\"0\">请选择</option>";
	// 			for(var i = 0; i < data.length; i++){
	// 				//alert(data[i].id);
	// 				//alert(data[i].roleName);
	// 				if(rid != null && rid != undefined && data[i].id == rid ){
	// 					options += "<option selected=\"selected\" value=\""+data[i].id+"\" >"+data[i].roleName+"</option>";
	// 				}else{
	// 					options += "<option value=\""+data[i].id+"\" >"+data[i].roleName+"</option>";
	// 				}
	//
	// 			}
	// 			userRole.html(options);
	// 		}
	// 	},
	// 	error:function(data){//当访问时候，404，500 等非200的错误状态码
	// 		validateTip(userRole.next(),{"color":"red"},imgNo+" 获取用户角色列表error",false);
	// 	}
	// });


	userId.on("focus",function(){
		validateTip(userId.next(),{"color":"#666666"},"* The username length must be characters greater than 1 but less than 10",false);
	}).on("blur",function(){
		if(userId.val() != null && userId.val().length > 0
				&& userId.val().length < 10){
			validateTip(userId.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userId.next(),{"color":"red"},imgNo+" The username number entered does not meet the specifications. Please re-enter it",false);
		}
		
	});
	userName.on("focus",function(){
		validateTip(userName.next(),{"color":"#666666"},"* The username length must be characters greater than 1 but less than 10",false);
	}).on("blur",function(){
		if(userName.val() != null && userName.val().length > 1
			&& userName.val().length < 10){
			validateTip(userName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userName.next(),{"color":"red"},imgNo+" The username entered does not meet the specifications. Please re-enter it",false);
		}

	});
	
	// birthday.on("focus",function(){
	// 	validateTip(birthday.next(),{"color":"#666666"},"* 点击输入框，选择日期",false);
	// }).on("blur",function(){
	// 	if(birthday.val() != null && birthday.val() != ""){
	// 		validateTip(birthday.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(birthday.next(),{"color":"red"},imgNo + " 选择的日期不正确,请重新输入",false);
	// 	}
	// });
	//
	email.on("focus",function(){
		validateTip(email.next(),{"color":"#666666"},"* Please enter your email number",false);
	}).on("blur",function(){
		var patrn=/[a-zA-Z0-9_-]+/;
		if(email.val().match(patrn)){
			validateTip(email.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(email.next(),{"color":"red"},imgNo + " The email format you entered is incorrect",false);
		}
	});
	
	// userLevel.on("focus",function(){
	// 	validateTip(userRole.next(),{"color":"#666666"},"* 请选择用户角色",false);
	// }).on("blur",function(){
	// 	if(userLevel.val() != null && userLevel.val() > 0){
	// 		validateTip(userLevel.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(userLevel.next(),{"color":"red"},imgNo+" 请重新选择用户角色",false);
	// 	}
	//
	// });
	
	saveBtn.on("click",function(){
		userName.blur();
		//userLevel.blur();
		email.blur();
		//userRole.blur();

		if(confirm("Are you sure you want to submit the data?")){
			$("#userForm").submit();
		}

	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
		// if(referer != undefined
		// 	&& null != referer
		// 	&& "" != referer
		// 	&& "null" != referer
		// 	&& referer.length > 4){
		//  window.location.href = referer;
		// }else{
			history.back(-1);
		//}
	});
});