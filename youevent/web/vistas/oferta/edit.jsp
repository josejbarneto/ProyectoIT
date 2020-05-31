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
        <s:form action="accionEditarOferta">
            <s:textfield name="descuento" label="Descuento" value="%{oferta.getDescuento()}"></s:textfield>
            <s:textfield name="fechainicio" label="Fecha inicio" value="%{oferta.getTInicio()}"></s:textfield>
            <s:textfield name="fechafin" label="Fecha fin" value="%{oferta.getTFin()}"></s:textfield>
            <s:hidden name="idOferta" value="%{oferta.getId()}"></s:hidden>
            <s:submit name="btnEditar" value="Editar"></s:submit>
        </s:form>
    </body>
</html>