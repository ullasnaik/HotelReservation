<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Booking</title>
<style>
td, th {
	font-family: arial, sans-serif;
}
</style>
<script type="text/javascript">
	function validate() {
		if (document.forms["bookingDetails"]["datepicker"].value == "") {
			alert("Please enter last name");
			document.forms["bookingDetails"]["datepicker"].focus();
			return false;
		}
		if (document.forms["bookingDetails"]["datepicker"].value == "") {
			alert("Please enter blood group");
			document.forms["bookingDetails"]["datepicker"].focus();
			return false;
		}

	}
</script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$.datepicker.setDefaults({
			onClose : function(date, inst) {
				$("#selectedDtaeVal").html(date);
			}
		});

		$("#datepicker").datepicker();
	});
</script>
<script>
	$(function() {
		$.datepicker.setDefaults({
			onClose : function(date, inst) {
				$("#selectedDtaeVal").html(date);
			}
		});

		$("#datepicker1").datepicker();
		
	});
</script>
</head>
<body style="background-color: #FFFFE0;">
	<div style="margin-top: 50px; margin-left: 250px; height: 50px;">
		<h2>BookingDetails</h2>
	</div>
	<form:form method="POST" modelAttribute="bookingDetails"
		action="/bookRoom" name="bookingDetails">
		<table style="vertical-align: center; margin-left: 20%;">

			<tr>
				<td><form:hidden path="status" /></td>
			</tr>
			<tr>
				<td><form:hidden path="user.id" /></td>
			</tr>
			<tr>
				<td><form:hidden path="numOfDays" /></td>
			</tr>
			<tr>
				<td>Check In Date :</td>
				<td><form:input path="checkInDate" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Check Out Date :</td>
				<td><form:input path="checkOutDate" id="datepicker1" /></td>
			</tr>
			<tr>
				<td>Room Type</td>
				<td><form:select path="room.roomType">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="SINGLE_BED" label="SINGLE_BED" />
						<form:option value="DOUBLE_BED" label="DOUBLE_BED" />
						<form:option value="THREE_BED" label="THREE_BED" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<c:out value="Book" />" onclick="return validate();">
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>