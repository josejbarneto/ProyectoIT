<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Categoria</h1>
        <s:form action="accionEditarCategoria">
            <s:textfield name="nombre" label="Nombre " value="%{categoria.getNombre()}"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion" value="%{categoria.getDescripcion()}"></s:textfield>   
            <s:hidden name="id" value="%{categoria.getId()}"></s:hidden>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>