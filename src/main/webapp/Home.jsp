<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
td, th {
  font-family: arial, sans-serif;
}
</style> 
<script type="text/javascript">
	function validate() {
		if (document.forms["user"]["id"].value == "") {
			alert("Please User Id");
			document.forms["user"]["id"].focus();
			return false;
		}

		if (document.forms["user"]["userType"].value == "NONE") {
			alert("Select User Type");
			document.forms["user"]["address"].focus();
			return false;
		}

	}
</script>
</head>
<body style="background-color: #FFFFE0;">
	<div style="margin-top: 50px; margin-left: 250px; height: 50px;">
		<h2 align="center">
			Identify Yourself
		</h2>
	</div>
	<form:form method="POST" modelAttribute="user" action="/UserHome"
		name="user">
		<table  style="margin-left: auto; margin-right: auto;">

			<tr>
				<td>User Id :</td>
				<td><form:input path="id" id="id" /></td>
			</tr>
			<tr>
				<td>Login As :</td>
				<td><form:select path="userType">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="USER" label="USER" />
						<form:option value="ADMIN" label="ADMIN" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<c:out value="Login" />" onclick="return validate();">
					<a href="/registration">Registration</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>