<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado Evento</h1>

        <s:iterator value="listaEventos" var="evento">
        <tr>
            <td><s:property value="nombre" /></td>
            <td><s:property value="descripcion" /></td>
            <td><s:property value="lugar" /></td>
            <td>
                <s:form action="redirigirAMostrarEvento">
                    <s:hidden name="idEvento" value="%{#evento.getId()}"></s:hidden>
                    <s:submit name="btnMostrar" value="Mostrar"></s:submit>
                </s:form>
        </tr>
    </s:iterator>

</body>
</html>