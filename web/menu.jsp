<%--
  Created by IntelliJ IDEA.
  User: wei.ou
  Date: 2019-05-22
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="ShowItemServlet?action=top">Welcome!</a>
<c:forEach items="${categories}" var="category">
    <a href="ShowItemServlet?action=list&code=${category.code}">${category.name}</a>|
</c:forEach>
