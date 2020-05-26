<%-- 
    Document   : login
    Created on : 25-may-2020, 0:41:03
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </body>
</html>
