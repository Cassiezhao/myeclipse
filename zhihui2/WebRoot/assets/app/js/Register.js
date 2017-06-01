function checkCompanyNumber(){
				var str = document.getElementById("form-companyNumber").value;
				var flag = str.match(/\D/)==null;
				
				if(str.length != 10 ){
					document.getElementById("userNumErr").innerHTML = "<font color='red'>长度为10位数字</font>";
					form1.form-companyNumber.focus();
					return false;
				}
				
				if(!flag == true ){
					document.getElementById("userNumErr").innerHTML = "<font color='red'>必须由数字组成</font>";
					form1.form-companyNumber.focus();
					return false;
				}
				
				
				document.getElementById("userNumErr").innerHTML = "";
				return true;
				
			}
			
function checkpassword(){
				var str = document.getElementById("form-password").value;
				var flag = str.match(/\D/)==null;
				
				if(str.length != 6 ){
					document.getElementById("passwordErr").innerHTML = "<font color='red'>长度为6位数字</font>";
					form1.form-password.focus();
					return false;
				}
				
				
				if(!flag == true ){
					document.getElementById("passwordErr").innerHTML = "<font color='red'>必须由数字组成</font>";
					form1.form-password.focus();
					return false;
				}
				
				
				document.getElementById("passwordErr").innerHTML = "";
				return true;
				
			}

function checkRepassword(){
				
				var str1 = document.getElementById("form-password").value;
				var str2 = document.getElementById("password2").value;
				
				
				if(str1 != str2){
					document.getElementById("passwordErr2").innerHTML = "<font color='red'>两次输入密码不同</font>";
					form1.password2.focus();
					return false;
				}
				
				
				document.getElementById("passwordReErr").innerHTML = "";
				return true;
			}


	