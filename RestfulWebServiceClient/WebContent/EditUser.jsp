<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.thaind.model.*, com.thaind.client.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%
	int iduser = Integer.parseInt(request.getParameter("iduser"));
	session.setAttribute("iduser", iduser);
	User u = UserServiceClient.getUser(iduser);
	%>
	<div class="text-center text-md-right">
<h1> Demo Restful WebService Project </h1>
</div>
	<div class="container">
		<h2>Chỉnh sửa User</h2>
		<br>
			<form>
			<div class="form-group">
					<label>Id</label> 
					<input type="text" id="id" value="<%=iduser %>" class="form-control"  readonly> <br>
				</div>
				<div class="form-group">
					<label>Name</label> 
					<input type="text" id="name" value="<%=u.getUsername() %>" class="form-control" > <br>
				</div>
				<div class="form-group">
					<label>Email</label> 
					<input type="text" id="email" value="<%=u.getEmail() %>" class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Address</label> 
					<input type="text" id="address" value="<%=u.getAddress()%>" class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Phone</label> 
					<input type="text" id="phone" value="<%=u.getPhone() %>" class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Position</label> 
					<input type="text" id="position" value="<%=u.getPosition() %>" class="form-control"> <br>
				</div>
				<button type="button" class="btn btn-primary" onclick="history.back()">Back </button>
				<button type="button" class="btn btn-primary" onclick="UpdateUser()">Save </button>
			</form>
		</div>
		
		<script>
				function UpdateUser() {
					var id= document.getElementById("id").value;
					var name = document.getElementById("name").value;
					var email = document.getElementById("email").value;
					var address = document.getElementById("address").value;
					var phone = document.getElementById("phone").value;
					var position = document.getElementById("position").value;
					
					window.location="./doUpdate.jsp?id="+id+"&name="+name+"&email="+email+"&address="+address+"&phone="+phone+"&position="+position;
				}
			</script>
</body>
</html>