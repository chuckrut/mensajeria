<%-- 
    Document   : enviarMensaje
    Created on : 11-feb-2014, 10:40:31
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<fmt:setBundle basename="bundle.mensajes" var="mensajes" scope="session" />

<jsp:useBean id="organizacion" class="beans.Organizacion" scope="page" />

<!DOCTYPE html>
<!--Formulario para introducir un mensaje.-->
<html>
    <head>
        <title>
            <fmt:message key="enviarMensaje" bundle="${mensajes}"/>
        </title>
        <link href="./css/centrado.css" type="text/css" title="centrado" rel="stylesheet" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div class="centrado"> <!--align="center" style="margin: auto;"-->
            <h2><fmt:message key="enviarMensaje" bundle="${mensajes}"/></h2>
            <br>
            <form action="guardarMensaje.jsp" method="post">
            <!--<form action="http://172.26.20.106:8000/guardarMensaje.jsp" method="post">-->
                <table>
                    <tr>
                        <td><fmt:message key="nombre" bundle="${mensajes}"/>:</td>
                        <td><input type="text" name="nombre" placeholder='<fmt:message key="nombre" bundle="${mensajes}"/>' maxlength="30" required="required"/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="apellidos" bundle="${mensajes}"/>:</td>
                        <td><input type="text" name="apellidos" placeholder='<fmt:message key="apellidos" bundle="${mensajes}"/>'/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="ocupacion" bundle="${mensajes}"/>:</td>
                        <td><input type="text" name="ocupacion" placeholder='<fmt:message key="ocupacion" bundle="${mensajes}"/>'/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="email" bundle="${mensajes}"/>:</td>
                        <td><input type="email" name="email" placeholder='<fmt:message key="email" bundle="${mensajes}"/>'/></td>
                    </tr>
                    <tr>
                        <td><fmt:message key="destinatario" bundle="${mensajes}"/>:</td>
                        <td><select name="idEmpleado">
                                <c:forEach var="empleado" items="${organizacion.empleados}">
                                    <option value="${empleado.id}">
                                        ${empleado.nombre} 
                                        ${empleado.apellidos} - 
                                        ${empleado.departamento}
                                    </option>
                                </c:forEach>
                            </select></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p><fmt:message key="textoDelMensaje" bundle="${mensajes}"/>:</p>
                            <textarea title="Texto del mensaje" name="mensaje" cols="20" rows="5"></textarea>
                        </td>
                        <td><input type="submit" value="<fmt:message key="enviar" bundle="${mensajes}"/>"/></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>