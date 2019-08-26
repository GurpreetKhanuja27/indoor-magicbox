<%--
  Created by IntelliJ IDEA.
  User: ganesh
  Date: 2019-08-20
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <style>
        input, button, submit { border:none;
        color:blue;
        text-decoration: underline;
            cursor: pointer;
            -webkit-appearance:none}
        a {
            color:blue;
        }

        div{
            margin-top: 20%;
        }

    </style>
</head>
<body>
 

<jsp:include page="header.html"></jsp:include>


<div align="center">
    <p style="font-size:1.17rem"><a href="UniversityController?action=register"><b>Register New Student</b></a></p>
  
	<p style="font-size:1.17rem"><a href="UniversityController?action=list"><b>Registered Students list</b></a></p>
	       
</div>
</body>
</html>
