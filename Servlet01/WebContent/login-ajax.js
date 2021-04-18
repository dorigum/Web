/**
 *  login-ajax.js
 */

$(document).ready(function(){
	
	$('#frmLogin').on("submit", function(){
		
		$.ajax({
			url:"http://localhost:8080/Servlet01/loginAjax",
			type:"post",
			data: {
				"id": $('#user_id').val(),
				"password": $('#user_pw').val()
			},
			success:function(result, textStatus){
				alert("Data : " + result + " 님~\nStauts : " + textStatus);
			},
			error:function(data, textStatus){
				
			},
			complete:function(data, textstatus){
				
			}						
		});		
	});	
});