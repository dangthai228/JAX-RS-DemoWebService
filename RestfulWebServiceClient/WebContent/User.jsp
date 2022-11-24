<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.thaind.model.*, com.thaind.client.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DemoJAX-RS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<%
	ArrayList<User> list = UserServiceClient.getAllUsers();
%>
<div class="text-center text-md-right">
<h1> Demo Restful WebService Project </h1>
</div>
	<div class="container">
		<h2>Danh sách tất cả User</h2>
		<br>
	<table class="table table-bordered">
			<thead>
				<tr>
					<th>STT</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Position</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
			if(list!= null){
			for(int i=0;i<list.size();i++){
			%>
			<tbody>
				<tr>
					<td><%=(i+1)%></td>
					<td><%=list.get(i).getUsername() %></td>
					<td><%=list.get(i).getEmail()%></td>
					<td><%=list.get(i).getAddress() %></td>
					<td><%=list.get(i).getPhone() %></td>
					<td><%=list.get(i).getPosition() %></td>
					<td>
						<div>
							
							<button type="button" class="btn btn-warning" onclick="ToEditView(<%=list.get(i).getId()%>)" >Edit</button>
							<button type="button" class="btn btn-danger"  onclick="doDelete(<%=list.get(i).getId()%>)">Delete</button>
						</div>
					</td>
				</tr>
			</tbody>
			<%
				}
			}
			%>
		</table>
		<button type="button" class="btn btn-success" onclick="ToAddView()" >Add</button>
		<script type="text/javascript">
				function ToEditView(id) {
					window.location="./EditUser.jsp?iduser="+id;
				}
				function ToAddView() {
					window.location="./AddUser.jsp";
				}
				function doDelete(idxoa) {
					if (confirm("Are you sure to delete this User")) {
						window.location="./doDelete.jsp?iddelete="+idxoa;
					  } else {
					    
					  }
				}
		</script>
	</div>
</body>
</html>