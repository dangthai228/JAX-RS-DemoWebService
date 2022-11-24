<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.thaind.model.*, com.thaind.client.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add user</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%
	int id= Integer.parseInt(request.getParameter("iddelete"));
	boolean kq= UserServiceClient.deleteUser(id);
		if(kq==true)
		{
	%>
	<script>
		alert("Xóa user thành công");
		window.location="./User.jsp";
	</script>
	<%
		}else{
	%>
	<script>
		alert("Xóa user thất bại");
		history.back();
	</script>
	<%} %>
</body>
</html>