<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Categoría</h1>
        <s:form action="accionCrearCategoria">
            <s:textfield name="nombre" label="Nombre de la categoría"></s:textfield>
            <s:textfield name="descripcion" label="Descripción"></s:textfield>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>