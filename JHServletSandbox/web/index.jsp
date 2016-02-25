<%--
  Created by IntelliJ IDEA.
  User: Jonathan
  Date: 2/23/2016
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Test Forms</title>
</head>
<body>
<h1>Test Form for get and post to servlet from web</h1>
<form action="/http" method="post">
  <input type="text" name="name">
  <input type="submit" value="Submit">
</form>
<a href="/http?name=Bob">Test Get</a>

</body>
</html>
