<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.thaind.model.*, com.thaind.client.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div class="text-center text-md-right">
<h1> Demo Restful WebService Project </h1>
</div>
	<div class="container">
		<h2>Thêm mới User</h2>
		<br>
			<form>
				<div class="form-group">
					<label>Name</label> 
					<input type="text" id="name"  class="form-control" > <br>
				</div>
				<div class="form-group">
					<label>Email</label> 
					<input type="text" id="email"  class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Address</label> 
					<input type="text" id="address"  class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Phone</label> 
					<input type="text" id="phone"  class="form-control"> <br>
				</div>
				<div class="form-group">
					<label>Position</label> 
					<input type="text" id="position"  class="form-control"> <br>
				</div>
				<button type="button" class="btn btn-primary" onclick="history.back()">Back </button>
				<button type="button" class="btn btn-primary" onclick="AddUser()">Add </button>
			</form>
		</div>
		<script>
				function AddUser() {
					var name = document.getElementById("name").value;
					var email = document.getElementById("email").value;
					var address = document.getElementById("address").value;
					var phone = document.getElementById("phone").value;
					var position = document.getElementById("position").value;
					
					window.location="./doAdd.jsp?name="+name+"&email="+email+"&address="+address+"&phone="+phone+"&position="+position;
				}
			</script>
</body>
</html>