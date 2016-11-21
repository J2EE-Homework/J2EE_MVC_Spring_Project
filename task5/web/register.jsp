<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: JuN
  Date: 16/11/20
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form method="post" action="/task5/registerAction.action" validate="true">
        账号:<input type="text" name="register_name">
            <s:fielderror fieldName="register_name"/> <br>
        密码:<input type="password" name="register_password">
            <s:fielderror fieldName="register_password"/> <br>
        确认密码:<input type="password" name="register_password2">
            <s:fielderror fieldName="register_password2"/> <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
