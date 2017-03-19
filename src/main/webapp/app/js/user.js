$(document).ready(function(){
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/fblog/auth/find",
		async:true,
		data:"userName=a",
		success:function(data){
			userInfo(data.r);
		}
	});
})

function userInfo(userList){
	var rHtml="<tr><th>id</th><th>name</th><th>sex</th><th>age</th></tr>";
	for(var i=0; i<userList.length;i++){
		rHtml += "<tr>";
		rHtml += "<td>"+userList[i].id+"</td>";
		rHtml += "<td>"+userList[i].username+"</td>";
		rHtml += "<td>"+userList[i].sex+"</td>";
		rHtml += "<td>"+userList[i].age+"</td>";
		rHtml += "<tr>";
	}
	$("#userTable").html(rHtml);
}
