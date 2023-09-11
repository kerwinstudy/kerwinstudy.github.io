var userId = null;
var userName = null;
var userPassword = null;
var ruserPassword = null;
// var phone = null;
// var birthday = null;
// var userRole = null;
var userLevel = null;
var email = null;
var addBtn = null;
var backBtn = null;


$(function(){
	userId = $("#userId");
	userName = $("#userName");
	userPassword = $("#userPassword");
	ruserPassword = $("#ruserPassword");
	userLevel = $("#userLevel");
	email = $("#email");
	// userRole = $("#userRole");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	userId.next().html("*");
	userName.next().html("*");
	userPassword.next().html("*");
	ruserPassword.next().html("*");
	userLevel.next().html("*");
	email.next().html("*");
	// userRole.next().html("*");

	// $.ajax({
	// 	type:"GET",//请求类型
	// 	url:path+"/jsp/user.do",//请求的url
	// 	data:{method:"getrolelist"},//请求参数
	// 	dataType:"json",//ajax接口（请求url）返回的数据类型
	// 	success:function(data){//data：返回数据（json对象）
	// 		if(data != null){
	// 			userRole.html("");
	// 			var options = "<option value=\"0\">请选择</option>";
	// 			for(var i = 0; i < data.length; i++){
	// 				//alert(data[i].id);
	// 				//alert(data[i].roleName);
	// 				options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
	// 			}
	// 			userRole.html(options);
	// 		}
	// 	},
	// 	error:function(data){//当访问时候，404，500 等非200的错误状态码
	// 		validateTip(userRole.next(),{"color":"red"},imgNo+" 获取用户角色列表error",false);
	// 	}
	// });
	
	
	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	userId.bind("blur",function(){
		//ajax后台验证--userCode是否已存在
		//user.do?method=ucexist&userCode=**
		$.ajax({
			type:"GET",//请求类型
			url:path+"/jsp/user.do",//请求的url
			data:{method:"ucexist",userId:userId.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.userCode == "exist"){//账号已存在，错误提示
					validateTip(userCode.next(),{"color":"red"},imgNo+ " The user account already exists",false);
				}else{//账号可用，正确提示
					validateTip(userCode.next(),{"color":"green"},imgYes+" This account can be used",true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(userId.next(),{"color":"red"},imgNo+" The page you visited does not exist",false);
			}
		});
		
		
	}).bind("focus",function(){
		//显示友情提示
		validateTip(userId.next(),{"color":"#666666"},"* The user code is the account you logged into the system with",false);
	}).focus();
	
	userName.bind("focus",function(){
		validateTip(userName.next(),{"color":"#666666"},"* The username length must be characters greater than 1 but less than 10",false);
	}).bind("blur",function(){
		if(userName.val() != null && userName.val().length > 1
				&& userName.val().length < 10){
			validateTip(userName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userName.next(),{"color":"red"},imgNo+" The username entered does not meet the specifications. Please re-enter it",false);
		}
		
	});
	
	userPassword.bind("focus",function(){
		validateTip(userPassword.next(),{"color":"#666666"},"* The password length must be greater than 6 but less than 20",false);
	}).bind("blur",function(){
		if(userPassword.val() != null && userPassword.val().length > 6
				&& userPassword.val().length < 20 ){
			validateTip(userPassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userPassword.next(),{"color":"red"},imgNo + " The password input does not meet the specifications. Please re-enter it",false);
		}
	});
	
	ruserPassword.bind("focus",function(){
		validateTip(ruserPassword.next(),{"color":"#666666"},"* Please enter a password that matches the one above",false);
	}).bind("blur",function(){
		if(ruserPassword.val() != null && ruserPassword.val().length > 6
				&& ruserPassword.val().length < 20 && userPassword.val() == ruserPassword.val()){
			validateTip(ruserPassword.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(ruserPassword.next(),{"color":"red"},imgNo + " The two password entries do not match. Please re-enter",false);
		}
	});


	userLevel.bind("focus",function(){
		validateTip(userLevel.next(),{"color":"#666666"},"* ",false);
	}).bind("blur",function(){
		if(userLevel.val() != null && userLevel.val() != ""){
			validateTip(userLevel.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(userLevel.next(),{"color":"red"},imgNo + " ",false);
		}
	});

	email.bind("focus",function(){
		validateTip(email.next(),{"color":"#666666"},"* Please enter your email number",false);
	}).bind("blur",function(){
		var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
		if(email.val().match(patrn)){
			validateTip(email.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(email.next(),{"color":"red"},imgNo + " Please enter your email number",false);
		}
	});
	//
	// userRole.bind("focus",function(){
	// 	validateTip(userRole.next(),{"color":"#666666"},"* 请选择用户角色",false);
	// }).bind("blur",function(){
	// 	if(userRole.val() != null && userRole.val() > 0){
	// 		validateTip(userRole.next(),{"color":"green"},imgYes,true);
	// 	}else{
	// 		validateTip(userRole.next(),{"color":"red"},imgNo + " 请重新选择用户角色",false);
	// 	}
	// });
	
	addBtn.bind("click",function(){
		if(userId.attr("validateStatus") != "true"){
			userId.blur();
		}else if(userName.attr("validateStatus") != "true"){
			userName.blur();
		}else if(userPassword.attr("validateStatus") != "true"){
			userPassword.blur();
		}else if(ruserPassword.attr("validateStatus") != "true"){
			ruserPassword.blur();
		}else if(userLevel.attr("validateStatus") != "true"){
			userLevel.blur();
		}else if(email.attr("validateStatus") != "true"){
			email.blur();
		}else{
			if(confirm("Are you sure to submit the data")){
				$("#userForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});