<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>YOUEVENT</title>
        <s:head/>
        <%@include file="/vistas/includes.jsp" %>
    </head>
    <body>
        <%@include file="/vistas/header.jsp" %>
        <div class="ui section hidden divider"></div>
        <div id="main" class="ui very wide container">
            <div class="ui basic segment">
                <s:form action="redirigirACrearAnunciante" method="post">
                    <s:submit name="btnCrearEvento" value="Crear Evento"></s:submit>
                </s:form>
                <s:form action="redirigirAListarAnunciante" method="post">
                    <s:submit name="btnListarEvento" value="Listar Evento"></s:submit>
                </s:form>
                <s:form action="redirigirAMostrarConfiguracion" method="post">
                    <s:submit name="btnCrearAnuncio" value="Crear Anuncio"></s:submit>
                </s:form>
                <s:form action="redirigirAListarUsuario" method="post">
                    <s:submit name="btnListarUsuario" value="Listar usuarios"></s:submit>
                </s:form>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>
