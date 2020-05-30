<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Evento</h1>
        <s:form action="accionCrearEvento">
            <s:textfield name="nombre" label="Nombre de evento"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion"></s:textfield>
            <s:textfield name="lugar" label="Lugar"></s:textfield>
                
            <s:select label="Categorias" name="id_categories" listValue="nombre" list="categorias" multiple="true" required="true"/>
                        
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>