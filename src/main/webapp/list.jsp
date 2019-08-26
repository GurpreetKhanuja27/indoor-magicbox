<%--
  Created by IntelliJ IDEA.
  User: ganesh
  Date: 2019-08-20
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bean.User"%>
<%@ page import="com.dao.UserDAO"%>
<%@page import="java.util.Iterator"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Registered Student List</title>
</head>
<body>

	<%-- null --%>
	<%
		List<User> userdata = (List) application.getAttribute("userdata");
	%>
	<table border="1px">
		<tr>
			<th>UNo</th>
			<th>Name</th>
			<th>Sex</th>
		</tr>

		<c:forEach items="${userdata}" var="user">
			<tr>
				<td>${user.universityNumber}</td>
				<td>${user.studentName}</td>
				<td>${user.sex}</td>
			</tr>

		</c:forEach>

		<c:set var="salary" scope="session" value="${2000*2}" />
		<c:out value="${sessionScope.salary}"/>
	</table>
</body>
</html>
