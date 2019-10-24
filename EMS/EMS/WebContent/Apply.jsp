<%@page import="com.hcl.ems.EmsBal"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.hcl.ems.Leaves"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Leaves leaves=new Leaves();
	leaves.setEmpId(Integer.parseInt(request.getParameter("empId")));
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date sDate=sdf.parse(request.getParameter("startDate"));
	leaves.setStartDate(sDate);
	
	Date endDate=sdf.parse(request.getParameter("endDate"));
	leaves.setEndDate(endDate);
	leaves.setNoDays(Integer.parseInt(request.getParameter("noDays")));
	leaves.setReason(request.getParameter("reason"));
	out.println(EmsBal.applyLeaveBal(leaves));
%>
	<%-- <jsp:useBean id="b1" class="com.hcl.ems.Leaves"></jsp:useBean>
	<jsp:setProperty property="empId" name="b1"/>
	<jsp:setProperty property="startDate" name="b1"/>
	<jsp:setProperty property="endDate" name="b1"/>
	<jsp:setProperty property="noDays" name="b1"/>
	<jsp:setProperty property="reason" name="b1"/>
	<jsp:setProperty property="type" name="b1"/>
	<%
		out.println(b1.applyLeave());
	%> --%>
</body>
</html>