<%-- 
    Document   : recuperarClave
    Created on : 28-may-2020, 17:27:56
    Author     : eugen
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
        <s:form action="recuperarClave" method="post">
            <s:textfield name="correo" label="Email"></s:textfield>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>
