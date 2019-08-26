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
    <title>login</title>
</head>
<body>

<form action="/IndoorMagicBox_war_exploded/LoginServlet" method="post">

    <div style="margin-top: 20%">
    <table align="center">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"> </td>
        </tr>
    </table>
    </div>

</form>

</body>
</html>
