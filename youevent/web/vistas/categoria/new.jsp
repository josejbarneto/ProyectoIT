<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <s:form action="accionCrearCategoria" method="post">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion"></s:textfield>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
        
        <s:form action="redirigirAListarCategoria" method="post">
            <s:submit name="btnListarCategoria" value="Listar Categoria"></s:submit>
        </s:form>
    </body>
</html>