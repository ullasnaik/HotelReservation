<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
td, th {
	font-family: arial, sans-serif;
}
</style>
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
<script type="text/javascript">
	function validate() {
		if (document.forms["bookingDetails"]["datepicker"].value == "") {
			alert("Please enter last name");
			document.forms["bookingDetails"]["datepicker"].focus();
			return false;
		}
	}
</script>
</head>
<body style="background-color: #FFFFE0;">
	<h2 align="center">
		Welcome
		<c:out value="${hotelDTO.user.firstName }" />
	</h2>
	<form:form method="POST" modelAttribute="hotelDTO" action="/UserAction"
		name="hotelDTO">
		<form:input type="hidden" path="userAction" value="CHECK" />
		<form:hidden path="user" />
		<form:hidden path="bookingDetails" />
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<th>Single Bed Room</th>
				<th>Double Bed Room</th>
				<th>Three Bed Room</th>
				<th>Booking Date</th>
				<th></th>
			</tr>
			<tr>
				<td><form:input path="noOf1BedAvalable" id="noOf1BedAvalable"
						readonly="true" /></td>
				<td><form:input path="noOf2BedAvalable" id="noOf2BedAvalable"
						readonly="true" /></td>
				<td><form:input path="noOf3BedAvalable" id="noOf3BedAvalable"
						readonly="true" /></td>
				<td><fmt:formatDate value="${hotelDTO.bookingDate}"
						pattern="MM/dd/yyyy" var="myDate" /> <form:input
						path="bookingDate" id="datepicker1" value="${myDate}" /></td>
				<td><input type="submit"
					value="<c:out value="Check Availability" />"></td>
			</tr>
			<tr>
			</tr>
		</table>
	</form:form>
	<form:form method="POST" modelAttribute="hotelDTO" action="/UserAction"
		name="bookingDetails">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<td><form:hidden path="user" /></td>
				<td><form:input type="hidden" path="userAction" value="BOOK" />
				</td>
			</tr>
			<tr>
				<td>Book A Room :</td>
				<td>Booking Date :</td>
				<td><fmt:formatDate
						value="${hotelDTO.bookingDetails.bookingDate}"
						pattern="MM/dd/yyyy" var="myDate1" /> <form:input
						path="bookingDetails.bookingDate" id="datepicker"
						value="${myDate1}" /></td>

				<td>Room Type</td>
				<td><form:select path="bookingDetails.roomType">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="SINGLE_BED" label="SINGLE_BED" />
						<form:option value="DOUBLE_BED" label="DOUBLE_BED" />
						<form:option value="THREE_BED" label="THREE_BED" />
					</form:select></td>
				<td colspan="2"><input type="submit"
					value="<c:out value="Book" />" onclick="return validate();">
				</td>
			</tr>

		</table>
	</form:form>

	<h2 align="center">Booking History</h2>
	<table style="margin-left: auto; margin-right: auto; border: 1">
		<tr>
			<th>Booking Id</th>
			<th>Booking Date</th>
			<th>Room Type</th>
			<th>Room Number</th>
			<th>Booking Status</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${hotelDTO.bookingList}" var="booking">
			<form:form method="POST" modelAttribute="hotelDTO"
				action="/UserAction" name="bookingDetails">
				<form:input type="hidden" path="userAction" value="CANCEL" />
				<form:input type="hidden" path="actionId"
					value="${booking.bookigId}" />
				<form:hidden path="user" />
				<form:hidden path="bookingDetails" />
				<tr>
					<td width="60" align="center">${booking.bookigId}</td>
					<td width="60" align="center"><fmt:formatDate
							value="${booking.bookingDate}" pattern="MM/dd/yyyy" var="myDate2" />
						${myDate2}</td>
					<td width="60" align="center">${booking.roomType}</td>
					<td width="60" align="center">${booking.room.roomNum}</td>
					<td width="60" align="center">${booking.status}</td>
					<td colspan="2"><input type="submit"
						value="<c:out value="Cancel" />"></td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
</body>
</html>