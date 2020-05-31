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

        <s:textfield name="contenido" label="Contenido" value="%{anuncio.getContenido()}" readonly="true"></s:textfield>
        <s:textfield name="precio" label="Precio" value="%{anuncio.getPrecio()}" readonly="true"></s:textfield>
        <s:textfield name="nombre_anunciante" label="Nombre anunciante" value="%{anunciante.getNombre()}" readonly="true"></s:textfield>
        <s:textfield name="id_anunciante" label="Id del anunciante" value="%{anunciante.getId()}" readonly="true"></s:textfield>

        <br/>
        
        <s:form action="redirigirAEditarAnuncio">
            <s:hidden name="idAnuncio" value="%{anuncio.getId()}" ></s:hidden>
            <s:submit name="btnEditar" value="Editar"></s:submit>
        </s:form>
        
        <s:form action="accionEliminarAnuncio">
            <s:hidden name="idAnuncio" value="%{anuncio.getId()}"></s:hidden>
            <s:submit name="btnEliminar" value="Eliminar"></s:submit>
        </s:form>
    </body>
</html>