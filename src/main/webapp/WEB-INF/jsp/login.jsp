<%--
  Created by IntelliJ IDEA.
  User: 20190712133
  Date: 2019/8/9
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--引用核心标签-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>小春论坛登录</title>
</head>
<body>
<c:if test="${!empty error}">
    <font color="red"><c:out value="${error}"/></font>
</c:if>
<form action="<c:url value="/loginCheck.html" />" method="post">

    用户名：
    <input type="text" name="userName" >
    <br>
    密码：
    <input type="password" name="password" id="userpassid" />
    <br>

    <input type="submit" value="登录" id="check" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
