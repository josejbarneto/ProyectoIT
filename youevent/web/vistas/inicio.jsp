<%-- 
    Document   : inicio
    Created on : 26-may-2020, 18:14:01
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form action="redirigirACrearEvento" method="post">
            <s:submit name="btnCrearEvento" value="Crear Evento"></s:submit>
        </s:form>
        <s:form action="redirigirAListarEvento" method="post">
            <s:submit name="btnListarEvento" value="Listar Evento"></s:submit>
        </s:form>
    </body>
</html>
