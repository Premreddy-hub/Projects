<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply leave | EMS</title>
</head>
<body>
	<p id="page">Apply Leave</p>
	<form method="get" action="Apply.jsp">
	Employee ID : 
	<input type="text" readonly="readonly"  value=<%=session.getAttribute("EMP_ID") %> name="empId"/>
	<table>
		<tr>
			<th >Start Date</th>
			<td>
				<input type='date' name="startDate"  />
            </td>
		</tr>
		<tr>
			<th>End Date</th>
			<td>
				<input type='date' name="endDate"  />
            </td>
		</tr>
		<tr>
			<th>Number of Days</th>
			<td>
				<input type="text" name="noDays"/>
			</td>
		</tr>
		<tr>
			<th>Leave Type</th>
			<td>
				<select name="type">
					<option>EL</option>
					<option>2</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>Leave Reason</th>
			<td>
				<input type="text" name="reason"/>
			</td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Apply" name="apply"/></td>
			<td><input class="btn btn-primary" type="reset" onClick="javascript:window.location.href='dashboard.jsp'" value="Cancel" name="cancel"/></td>
		</tr>
	</table>
	</form>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</body>
</html>