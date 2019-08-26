<%--
  Created by IntelliJ IDEA.
  User: ganesh
  Date: 2019-08-20
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.bean.User" %>
<%@ page import="com.dao.UserDAO" %>
<%@page import="java.util.Iterator"%>


<html>
<head>
    <title>Registered Student List</title>
</head>
<body>

<%-- null --%>
<% List<User> userdata = (List)application.getAttribute("userdata");%> 
<table border="1px">
    <tr>
        <th>UNo</th>
        <th>Name</th>
        <th>Sex</th>
    </tr> 
    
    <% for(User u : userdata){%>
    
    <tr>    
    		<td><% out.println(u.getUniversityNumber()); %></td>
    		<td><% out.println(u.getStudentName()); %></td>
    		<td><% out.println(u.getSex()); %></td>
    </tr>
    <%}%>					
    	
    
   	
    
    	
    
    

</table>
</body>
</html>
