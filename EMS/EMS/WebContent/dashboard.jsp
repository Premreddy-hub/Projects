<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard | EMS</title>
</head>
<body>
	Welcome to <%=(String)session.getAttribute("EMP_ID") %>
	<div id="mainSec">
		
		<div id="myProfile">
		
			<jsp:include page="MyAccount.jsp" />
		
		</div>
		<div id="mngrProfile">
		
			<jsp:include page="ManagerAccount.jsp" />
		
		</div>
		<div id="myLeave">
		
			<jsp:include page="MyLeaves.jsp" />
	
		</div>
		<div id="empLeave">
		
			<jsp:include page="EmpLeaves.jsp" />
		
		</div>
	</div>
</body>
</html>