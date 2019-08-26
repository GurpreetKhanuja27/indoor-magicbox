<%--
  Created by IntelliJ IDEA.
  User: ganesh
  Date: 2019-08-20
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>


<head>
    <title>Registration</title>

    <style>
        a:link, a:visited {
            text-decoration: none;

            cursor: pointer;
        }
        .subButtton{
            cursor: pointer;
        }

    </style>
</head>
<body>
<%--<div>--%>
<%--    <%--%>
<%--    boolean message = (Boolean)request.getAttribute("regStuStatus");--%>
<%--    if(message){--%>
<%--    out.println("<h3>You have successfully registered your details</h3>");--%>
<%--    }--%>
<%--    %>--%>
<%--</div>--%>


<jsp:include page="header.html"></jsp:include>
<div>
    <form action="UniversityController" method="post">

        <table align="center">
            <tr>
                <td>University Number</td>
                <td><input type="text" name="universityNumber"></td>
                <td>
                		<%
                			if(request.getAttribute("errormessage") !=null){
                				out.println(request.getAttribute("errormessage"));
                			}
                		
                		%>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="studentName" value="<%=request.getParameter("studentName")%>"/></td>
            </tr>
            <tr>
                <td>Sex</td>
                <td><input type="text" name="sex" value = <%=request.getParameter("sex")%>/>
                	 <input type="hidden" name="action" value="new" ></input>
                </td>
            </tr>
            
           
            <tr>
                <td><input class="subButtton" type="submit" name="Register"></td>
                
                <td><button type="button" onclick="">Cancel</button></td>
            </tr>
        </table>

    </form>


</div>


</body>
</html>
