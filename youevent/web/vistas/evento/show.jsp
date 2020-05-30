<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar Evento</h1>

        <s:textfield name="nombre" label="Nombre de evento" value="%{evento.getNombre()}" readonly="true"></s:textfield>
        <s:textfield name="descripcion" label="Descripcion" value="%{evento.getDescripcion()}" readonly="true"></s:textfield>
        <s:textfield name="lugar" label="Lugar" value="%{evento.getLugar()}" readonly="true"></s:textfield>
        <s:textfield name="aforo" label="Aforo" value="%{evento.getAforo()}" readonly="true"></s:textfield>
        <s:textfield name="precio" label="Precio" value="%{evento.getPrecio()}" readonly="true"></s:textfield>

        <br/>
        
        <s:iterator value="listaCategorias" var="categoria">
        <tr>
            <td>Categoria:   <s:property value="nombre" /></td>
            <td>Descripcion: <s:property value="descripcion" /></td>
        </tr>
        <br/>
        </s:iterator>
        
        <s:form action="redirigirAEditarEvento">
            <s:hidden name="idEvento" value="%{evento.getId()}" ></s:hidden>
            <s:submit name="btnEditar" value="Editar"></s:submit>
        </s:form>
        <s:form action="accionEliminarEvento">
            <s:hidden name="idEvento" value="%{evento.getId()}"></s:hidden>
            <s:submit name="btnEliminar" value="Eliminar"></s:submit>
        </s:form>


    </body>
</html>