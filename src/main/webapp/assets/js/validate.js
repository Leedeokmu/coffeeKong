$(document).ready(function(){
	$('form[name="register"]').validate({
	    rules: {
	        email: { required: true, email:true, remote:{
		        	type:"post",
		        	url:"/register/chkId"
	        	} 
	        },
	        fname: { required: true },
	        lname: { required: true },
	        pwd: { required: true, minlength:4},
	        pwdconfirm: { equalTo: "#uPwd" }
	    },
	    messages: {
	        email: {
	            required: "Check Your Email",
	            email: "Enter Right Email Form",
	            remote: "Duplicated. Enter Another Email"
	        },
	        fname:{ required:"Check Your First Name" },
	        lname:{ required:"Check Your Last Name" },
	        pwd: { required: "Check Your Password" },
	        pwdconfirm: { equalTo: "Password Not Matched" }
	    },
	    submitHandler: function (form) {
	    	event.preventDefault();
			
	    	var form = $('form[name="register"]');
	    	
	    	$.ajax({
	    		type:'POST',
	    		url: '/register',
	    		headers : {
	    			"Content-Type" : "application/json",
	    			"X-HTTP-Method-Override" : "POST"
	    		},
	    		dateType: 'json',
	    		data: JSON.stringify(form_to_json(form)),
	    		success : function(result){
	    			if(result == "Success"){
	    				window.location.replace('/registerSuccess');
	    			}else if(result == "Fail"){
	    				$('#registerModal').show();
	    				$('.errmsg').html('<span>REGISTER FAILED. CHECK YOUR REGISTER FORM</span>').fadeIn('slow').fadeOut('slow');
	    			}
	    		}
	    		,
	    	 	error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
	    	});
	    },
	    success: function (e) {
	    	
	    }
	});
	
	$('form[name="login"]').validate({
	    rules: {
	        email: { required: true, email:true },
	        pwd: { required: true}
	    },
	    messages: {
	        email: { required: "Check Your Email"},
	        pwd: { required: "Check Your Password" }
	        
	    },
	    submitHandler: function(form, event) {
	    	event.preventDefault();
			
	    	var form = $('form[name="login"]');
	    	
	    	$.ajax({
	    		type:'POST',
	    		url: '/login',
	    		headers : {
	    			"Content-Type" : "application/json",
	    			"X-HTTP-Method-Override" : "POST"
	    		},
	    		dateType: 'json',
	    		data: JSON.stringify(form_to_json(form)),
	    		success : function(result){
	    			if(result == "Fail"){
	    				$('#loginModal').modal();
	    				$('.errmsg').html('<span>EMAIL & PASSWORD NOT CORRECT</span>').fadeIn('slow').fadeOut('slow');
	    			}else{
		    			var dest = (result != null ? result : '/index');
		    			window.location.replace(dest);
	    			}
	    		}
	    		,
	    	 	error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
	    	});
	    	
	//    	############# query String method ############
	    	
	//    	event.preventDefault();
	//    	
	//    	$(form).ajaxSubmit({
	//    		type:'POST',
	//    		url: '/login',
	//    		headers : {
	//    			"Content-Type" : "application/x-www-form-urlencoded",
	//    			"X-HTTP-Method-Override" : "POST"
	//			},
	//    		dateType: 'text',
	//    		data: $(form).serialize(),
	//			success : function(result){
	//				
	//				if(result == "Success"){
	//					window.location.reload();
	//				}else if(result == "Fail"){
	//					alert(result);
	//					$('#loginModal').show();
	//				}
	//			}
	//			,
	//    	 	error: function(request,status,error){
	//    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	//    	    }
	//    	});
	    }
	});
	
	$('form[name="mgrlogin"]').validate({
	    rules: {
	        email: { required: true, email:true },
	        pwd: { required: true}
	    },
	    messages: {
	        email: { required: "Check Your Email"},
	        pwd: { required: "Check Your Password" }
	        
	    },
	    submitHandler: function(form) {
			form.submit();
	    }
	});
	
	$('form[name="uupdate"]').validate({
	    rules: {
	        fname: { required: true },
	        lname: { required: true },
	        pwd: { required: true, minlength:4},
	        pwdconfirm: { equalTo: '[name="pwd"]' }
	    },
	    messages: {
	        fname:{ required:"REQUIRED" },
	        lname:{ required:"REQUIRED" },
	        pwd: { required: "Check Your Password" },
	        pwdconfirm: { equalTo: "Password Not Matched" }
	    },
	    submitHandler: function (form) {
	    	form.submit();
	    }
	});
	
	$('form[name="umupdate"]').validate({
	    rules: {
	        fname: { required: true },
	        lname: { required: true },
	        pwd: { required: true, minlength:4}
	    },
	    messages: {
	        fname:{ required:"REQUIRED" },
	        lname:{ required:"REQUIRED" },
	        pwd: { required: "Check Your Password" }
	    },
	    submitHandler: function (form) {
	    	form.submit();
	    }
	});
	
	$('form[name="omupdate"]').validate({
	    rules: {
	        price: { required: true },
	        fname: { required: true },
	        lname: { required: true },
	        phone: { required: true },
	        postcode: { required: true },
	        addr: { required: true }
	    },
	    messages: {
	    	price: { required: "REQUIRED" },
	        fname: { required: "REQUIRED" },
	        lname: { required: "REQUIRED" },
	        phone: { required: "REQUIRED" },
	        postcode: { required: "REQUIRED" },
	        addr: { required: "REQUIRED" }
	    },
	    submitHandler: function (form) {
	    	form.submit();
	    }
	});

	$('form[name="pminsert"]').validate({
		rules: {
	        name: { required: true },
	        category: { required: true },
	        price: { required: true },
	        content: { required: true }
	    },
	    messages: {
	    	name: { required: "REQUIRED" },
	        category: { required: "REQUIRED" },
	        price: { required: "REQUIRED" },
	        content: { required: "REQUIRED" }
	    },
	    submitHandler: function (form,event) {
	    	event.preventDefault();
	    	
	    	var formData = new FormData(form);
	    	formData.append("file", uploadfile);
	    	
	    	$.ajax({
	    		url: '/manage/product/insert',
	    		data: formData,
	    		dataType:'text',
	    		processData: false,
	    		contentType: false,
	    		type: 'POST',
	    		success: function(result){
	    			if(result == "Success"){
	    				$('form[name="afterPmi"]').submit();
	    			}
	    		},
		    	error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
	    	});	
	    }
	});
	
	$('form[name="pmupdate"]').validate({
		rules: {
	        name: { required: true },
	        category: { required: true },
	        price: { required: true },
	        content: { required: true }
	    },
	    messages: {
	    	name: { required: "REQUIRED" },
	        category: { required: "REQUIRED" },
	        price: { required: "REQUIRED" },
	        content: { required: "REQUIRED" }
	    },
	    submitHandler: function (form, e) {
	    	e.preventDefault();
	    	
	    	var formData = new FormData(form);
	    	formData.append("file", uploadfile);
	    	
	    	$.ajax({
	    		url: '/manage/product/update/save',
	    		data: formData,
	    		dataType:'text',
	    		processData: false,
	    		contentType: false,
	    		type: 'POST',
	    		success: function(result){
	    			if(result == "Success"){
	    				$('form[name="afterPmu"]').submit();
	    			}
	    		},
		    	error: function(request,status,error){
	    	        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	    }
	    	});	
	    }
	});
	
	jQuery.validator.addMethod("phone", function(phone_number, element) {
	    phone_number = phone_number.replace(/\s+/g, "");
	    return this.optional(element) || phone_number.length > 9 && 
	    phone_number.match(/[0-9]{10}/);
	}, "Please specify a valid phone number");
	
	$('form[name="order"]').validate({
	    rules: {
	    	fname: { required: true },
	    	lname: { required: true },
	    	postcode: { required: true},
	    	addr: { required: true},
	    	phone: {required: true, phone:true, minlength:10, maxlength:10}
	    },
	    messages: {
	    	fname:{ required:"REQUIRED" },
	    	lname:{ required:"REQUIRED" },
	    	postcode: { required: "REQUIRED" },
	    	addr : { required: "REQUIRED" },
	    	phone: { required:"REQUIRED", phone: "NUMBER EXCLUDE '-' OR SPACE" }
	    },
	    submitHandler: function (form, event) {
	    	form.submit();
	    }
	});
});

function form_to_json (form) {
	var arr = $(form).serializeArray();
	var obj = {};
	for (var i = 0; i < arr.length; i++) obj[arr[i].name] = arr[i].value;
	return obj;
}
