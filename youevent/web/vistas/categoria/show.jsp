<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar Categoria</h1>

        <s:textfield name="nombre" label="Nombre " value="%{categoria.getNombre()}" readonly="true"></s:textfield>
        <s:textfield name="descripcion" label="Descripcion" value="%{categoria.getDescripcion()}" readonly="true"></s:textfield>
        <s:textfield name="id" label="Id" value="%{categoria.getId()}" readonly="true"></s:textfield>
        
        <s:form action="redirigirAEditarCategoria">
            <s:hidden name="idEvento" value="%{categoria.getId()}" ></s:hidden>
            <s:submit name="btnEditar" value="Editar"></s:submit>
        </s:form>
        
        <s:form action="accionEliminarCategoria">
            <s:hidden name="idCategoria" value="%{categoria.getId()}"></s:hidden>
            <s:submit name="btnEliminar" value="Eliminar"></s:submit>
        </s:form>

    </body>
</html>