<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.thaind.model.*, com.thaind.client.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user editor</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setUsername(request.getParameter("name").toString());
		u.setEmail(request.getParameter("email").toString());
		u.setAddress(request.getParameter("address").toString());
		u.setPhone(request.getParameter("phone").toString());
		u.setPosition(request.getParameter("position").toString());
		boolean kq= UserServiceClient.updateUser(u);
		if(kq==true)
		{
	%>
	<script>
		alert("Cập nhật user thành công");
		window.location="./User.jsp";
	</script>
	<%
		}else{
	%>
	<script>
		alert("Cập nhật user thất bại");
		history.back();
	</script>
	<%} %>
</body>
</html>