<%-- 
    Document   : registro
    Created on : 26-may-2020, 18:27:48
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <s:form action="registrar" method="post">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="usuario" label="Nombre de usuario"></s:textfield>
            <s:password name="password" label="Contraseña"></s:password>
            <s:textfield name="email" label="Email"></s:textfield>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>
