<%-- 
    Document   : login
    Created on : 25-may-2020, 0:41:03
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <s:form action="comprobarLogin">
            <s:textfield name="usuario" label="Nombre de usuario"></s:textfield>
            <s:password name="password" label="Contraseña"></s:password>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
        <s:form action="redirigirARegistrar">
            <s:submit name="btnRegistrar" value="Registrar"></s:submit>
        </s:form>
        <s:form action="redirigirARecuperarClave">
            <s:submit name="btnRecuperarClave" value="Recuperar contraseña"></s:submit>
        </s:form>
    </body>
</html>
