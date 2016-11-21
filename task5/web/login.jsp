<%--
  Created by IntelliJ IDEA.
  User: JuN
  Date: 16/11/10
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <form action="/task5/loginAction.action" method="post">
        账号：<input name="account" type="text"><br/>
        密码: <input name="password" type="password"><br/>
        <input type="submit" value="登录"><br>
        <input type="button" value="注册" onclick="location.href='register.jsp'">
      </form>
  </body>
</html>
