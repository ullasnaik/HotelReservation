<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style>
td, th {
  font-family: arial, sans-serif;
}
</style>
<script type="text/javascript">
    function validate() {
         if (document.forms["user"]["fname"].value == "") {
              alert("Please enter first name");
              document.forms["user"]["fname"].focus();
              return false;
         }
         if (document.forms["user"]["lname"].value == "") {
              alert("Please enter last name");
              document.forms["user"]["lname"].focus();
              return false;
         }
         if (document.forms["user"]["address"].value == "") {
              alert("Please enter blood group");
              document.forms["user"]["address"].focus();
              return false;
         }
         
   }
</script>
</head>
<body style="background-color: #FFFFE0;">
<div style="margin-top:50px; margin-left:250px; height:50px;"><h2>User <c:out value="${user.id != null ? 'Update' : 'Registration' }" /></h2></div>
  <form:form method="POST" modelAttribute="user" action="/AddUser" name="user">
     <table style="vertical-align: center; margin-left:20%;">
 
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td><form:input path="firstName" id="fname" /></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName" id="lname"/></td>
        </tr>
        <tr>
            <td>Address :</td>
            <td><form:input path="address" id="address" /></td>
        </tr>
        <tr>
            <td>Contact Number</td>
            <td><form:input path="contactNumber" id="contactNumber" /></td>
        </tr>
        <tr>
             <td colspan="2"><input type="submit" value="<c:out value="${user.id != null ? 'Update' : 'Register' }" />"
             onclick="return validate();">
            <c:if test="${user.id ne null}"><b>|</b>&nbsp;<a href="/registration">Registration</a></c:if>
         </td>
    </tr>
</table>
</form:form>

</body>
</html>