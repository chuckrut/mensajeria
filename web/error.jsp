<%-- 
    Document   : error
    Created on : 20-feb-2014, 9:15:13
    Author     : Admin
--%>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="../css/centrado.css" type="text/css" title="centrado" rel="stylesheet" />
    </head>
    <body class="centrado">
        <h1>Mensaje: ${pageContext.exception.cause.cause.message}</h1>
        <h1>Mensaje: <%=exception.getCause().getCause().getMessage()%></h1>
    </body>
</html>
