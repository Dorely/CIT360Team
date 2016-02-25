<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 2/23/2016
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Name Display</h1>
<%-- This syntax gets the attributes that I added to the request in the servlet and prints them here --%>
<p>${name} ${message}</p>
<p>${requestCount} hits to the servlet</p>

</body>
</html>
