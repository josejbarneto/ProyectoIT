<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar Oferta</h1>

        <s:textfield name="evento" label="Evento" value="%{oferta.getEvento().getNombre()}" readonly="true"></s:textfield>
        <s:textfield name="descuento" label="descuento" value="%{oferta.getDescuento()}" readonly="true"></s:textfield>
        <s:textfield name="fechainicio" label="Fecha inicio de la oferta" value="%{oferta.getTInicio()}" readonly="true"></s:textfield>
        <s:textfield name="fechafin" label="Fecha fin de la oferta" value="%{oferta.getTFin()}" readonly="true"></s:textfield>

        <br/>
        
        <s:form action="redirigirAEditarOferta">
            <s:hidden name="idOferta" value="%{oferta.getId()}" ></s:hidden>
            <s:submit name="btnEditar" value="Editar"></s:submit>
        </s:form>
        
    </body>
</html>