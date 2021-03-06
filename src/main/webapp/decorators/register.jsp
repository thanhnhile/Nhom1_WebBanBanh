<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link href="<c:url value="/assets/css/login.css"/>" rel="stylesheet"
	type="text/css" />
<title>Register Form</title>
</head>
<body>
<div id="logreg-forms">
		<form class="form-signin" action="register" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Sign up</h1>
			<p id="message" class="text-danger">${mess}</p>
			<input name="user" value="${username}" type="text" id="inputEmail"
				class="form-control" placeholder="Username" required autofocus maxlength="50">
			<input name="pass" value="${password}" type="password"
				id="inputPassword" class="form-control" placeholder="Password"
				required maxlength="50">
			<input name="repass" value="${repassword}" type="password"
				id="inputRePassword" class="form-control" placeholder="Repeat Password" 
				required maxlength="50">
			<button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
			<a href="/BanBanhNgot/home"><i class="fas fa-angle-left"></i>
				required>
			<input type="hidden" name="<csrf:tokenname/>" value="<csrf:tokenvalue uri="register"/>"/>
			<button class="btn btn-primary btn-block" type="submit" id="btnSignup"><i class="fas fa-user-plus"></i> Sign Up</button>
			<a href="${pageContext.request.contextPath}/home"><i class="fas fa-angle-left"></i>
				Back</a>
		</form>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $( () => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
        </script>
        
        <script>
   document.getElementById('inputPassword').onkeyup=function(){
      
	   var format = /[!@#$%^&*()_+\-=\[\]{}:\\|,.<>\/?]+/;
	   var formatAlphabetCap = /[ABCDEFGHIJKLMNOPQRSTUVWXYZ]+/;
	   var formatAlphabet = /[abcdefghijklmnopqrstuvwxyz]+/;
	   var formatNumber = /[1234567890]+/;
       var pw = document.getElementById("inputPassword").value;  
       
       //check empty password field  
       if(pw == "") {  
          document.getElementById("message").innerHTML = "**Kh??ng ????? tr???ng !";  
          document.getElementById("btnSignup").disabled = true;
          
       } 
       else
    
      //minimum password length validation  
       if(pw.length < 8) {  
          document.getElementById("message").innerHTML = "**M???t kh???u t???i thi???u 8 k?? t???";  
          document.getElementById("btnSignup").disabled = true;
         
       }
       
     else
       if(formatNumber.test(pw) == false){
    	 
    	   document.getElementById("message").innerHTML = "**C???n c?? ??t nh???t m???t ch??? s??? ";  
           document.getElementById("btnSignup").disabled = true;
       }
       
       else if(pw.length > 15) {  
           document.getElementById("message").innerHTML = "**????? d??i m???t kh???u t???i ??a l?? 15 k?? t???";  
           document.getElementById("btnSignup").disabled = true;
          
        }
     
       else
           if(formatAlphabet.test(pw) == false){
        	 
        	   document.getElementById("message").innerHTML = "**C???n c?? ??t nh???t m???t ch??? c??i ";  
               document.getElementById("btnSignup").disabled = true;
           }
       
           else if(pw.length > 15) {  
               document.getElementById("message").innerHTML = "**????? d??i m???t kh???u t???i ??a l?? 15 k?? t???";  
               document.getElementById("btnSignup").disabled = true;
              
            }
         
  
       else
         if(formatAlphabetCap.test(pw) == false){
      	 
      	   document.getElementById("message").innerHTML = "**C???n c?? ??t nh???t m???t ch??? c??i in hoa ";  
             document.getElementById("btnSignup").disabled = true;
         }
       
         else if(pw.length > 15) {  
             document.getElementById("message").innerHTML = "**????? d??i m???t kh???u t???i ??a l?? 15 k?? t???";  
             document.getElementById("btnSignup").disabled = true;
            
          }
       
         else
             if(format.test(pw) == false){
          	 
          	   document.getElementById("message").innerHTML = "**C???n c?? m???t k?? t??? ?????c bi???t ";  
                 document.getElementById("btnSignup").disabled = true;
             }
       //maximum length of password validation  
       else if(pw.length > 15) {  
           document.getElementById("message").innerHTML = "**????? d??i m???t kh???u t???i ??a l?? 15 k?? t???";  
           document.getElementById("btnSignup").disabled = true;  
        }
     
       else
       { 
    	   document.getElementById("message").innerHTML = "**Password syntax correct";  
	       document.getElementById("btnSignup").disabled = false;
       }
  
   }
   
   </script>
   
   <script>
   document.getElementById('inputRePassword').onkeyup=function(){
	   var pw = document.getElementById("inputPassword").value;
	   var repw = document.getElementById("inputRePassword").value;
	   if (pw != repw) {
		   document.getElementById("message").innerHTML = "**Password and confirm password does not match";  
	       document.getElementById("btnSignup").disabled = true;
	   }
	   else {
		   document.getElementById("message").innerHTML = "**Password and confirm password correct";  
	       document.getElementById("btnSignup").disabled = false;
	   }
   }
   </script>
</body>
</html>