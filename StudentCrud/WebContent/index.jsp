<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<div class="container">
	
	<div class="row">
		<div class="col s12 m12">
			<form method="post" action="addstudent.do">
				<div class="input-field col s6">
		          <input type="text" name="name" class="validate" id="name"/>
		          <label for="name" >Name</label>
		        </div>
		        <div class="input-field col s6">
		          <input type="text" name="email" class="validate" id="email"/>
		          <label for="email">Email</label>
		        </div>
		        <div class="input-field col s6">
		          <input type="text" name="phone" class="validate" id="phone"/>
		          <label for="phone">Phone #</label>
		        </div>
		        <div class="input-field col s6">
		          <input type="text" name="address" class="validate" id="address"/>
		          <label for="address">Address</label>
		        </div>
				<button class="btn waves-effect waves-light cyan"  type="submit" name="action">Submit
				    <i class="material-icons right">save</i>
				</button>
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col s12 m6">
			<form method="post" action="findstudent.do">
				Id: <input type="text" name="id" /><br> <input type="submit"
					value="Find" />
			</form>
		</div>
	</div>

	

	<c:if test="${created eq true }">
		<h2>The student details was created successfully.</h2>
	</c:if>
	<c:if test="${created eq false }">
		<h2>The student details was not created.</h2>
	</c:if>
	<c:if test="${students ne null }">
		<table class="highlight responsive-table">
			<thead >
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Phone</th>
					<th colspan="3">Options</th>
				</tr>
			</thead>
			<tbody >
			
			
				<c:forEach var="s" items="${students }">
					<tr>
						<td>${s.id}</td>
						<td>${s.name}</td>
						<td>${s.email}</td>
						<td>${s.address}</td>
						<td>${s.phoneNo}</td>
						<td>
							<a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=V"><i class="material-icons">view_headline</i></a>
						</td>
						<td>
							 <a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=E"><i class="material-icons">edit</i></a>
						</td>
						<td>
							 <a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=D"><i class="material-icons">delete</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${ex eq true }">
		<p>An error occoured while trying to find the student details.
			Please try again later.</p>
	</c:if>
	<c:if test="${npe eq true }">
		<h2>Please make sure the student id is not empty.</h2>
	</c:if>
	<c:if test="${nfe eq true }">
		<h2>Please make sure the student id is a number.</h2>
	</c:if>
	<c:if test="${s ne null }">
		<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Email</td>
				<td>Address</td>
				<td>Phone</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.email}</td>
				<td>${s.address}</td>
				<td>${s.phoneNo}</td>
				<td>
					<a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=V"><i class="material-icons">view_headline</i></a>
				</td>
				<td>
					 <a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=E"><i class="material-icons">edit</i></a>
				</td>
				<td>
					 <a class="btn-floating btn-small cyan  " href="managestudent.do?id=${s.id}&option=D"><i class="material-icons">delete</i></a>
				</td>
			</tr>
		</table>
	</c:if>
</div>

<script>
$(document).ready(function() {
    M.updateTextFields();
  });
</script>
</body>
</html>