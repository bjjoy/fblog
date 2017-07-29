$(document).ready(function(){
	var param = {}
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/fblog/auth/findPage",
		async:true,
		data:{
			"sex":"1",
			"startPage":2,
			"pageSize":2
		},
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
