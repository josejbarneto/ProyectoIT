<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Evento</h1>
        <s:form action="accionEditarEvento">
            <s:textfield name="nombre" label="Nombre de evento" value="%{evento.getNombre()}"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion" value="%{evento.getDescripcion()}"></s:textfield>
            <s:textfield name="lugar" label="Lugar" value="%{evento.getLugar()}"></s:textfield>   
            <s:textfield name="aforo" label="Aforo" value="%{evento.getAforo()}"></s:textfield>    
            <s:textfield name="precio" label="Precio" value="%{evento.getPrecio()}"></s:textfield>  
            <s:textfield name="fecha" label="Fecha" value="%{evento.getFecha()}"></s:textfield> 
            <s:hidden name="id" value="%{evento.getId()}"></s:hidden>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>