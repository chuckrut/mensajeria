<%-- 
    Document   : guardarMensaje
    Created on : 11-feb-2014, 12:34:14
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="mensaje" class="beans.Mensaje" scope="page">
    <jsp:setProperty name="mensaje" property="ip" value="${pageContext.request.remoteAddr}"/>
    <jsp:setProperty name="mensaje" property="fechaYhora" value="<%=new java.util.Date()%>"/>
</jsp:useBean>
<%-- Guardamos el mensaje en la base de datos --%>
<jsp:setProperty name="mensaje" property="guardar" value="true"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guardar Mensaje</title>
        <link href="../css/centrado.css" type="text/css" title="centrado" rel="stylesheet" />
    </head>
    <body class="centrado">
        <c:choose>
            <c:when test="${empty(mensaje.error)}">
            <h1>El mensaje se ha registrado</h1>
            <h2>Mensaje: </h2>
            <h3>${param.mensaje}</h3>
            </c:when>
            <c:otherwise>
                <h2 style="color:red;">${mensaje.error}</h2>
            </c:otherwise>
        </c:choose>
    </body>
</html>
