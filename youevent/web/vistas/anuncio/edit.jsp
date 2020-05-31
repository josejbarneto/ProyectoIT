<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Anuncio</h1>
        <s:form action="accionEditarAnuncio">
            <s:textfield name="contenido" label="Contenido" value="%{anuncio.getContenido()}"></s:textfield>
            <s:textfield name="precio" label="Precio" value="%{anuncio.getPrecio()}"></s:textfield>
            <s:select cssClass="ui dropdown" label="Anunciante" name="anunciantes" listValue="nombre" listKey="id" list="anunciantesLista" required="true"/>
            
            <s:hidden name="id" value="%{anuncio.getId()}"></s:hidden>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>