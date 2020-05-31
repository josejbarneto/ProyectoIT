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
                <s:textfield name="modoNocturno" label="Modo nocturno" value="%{configuracion.getModoNocturno()}" readonly="true"></s:textfield>
                <s:textfield name="openNewTab" label="Abrir en una nueva pestaña" value="%{configuracion.getOpenNewTab()}" readonly="true"></s:textfield>
                <s:textfield name="categoriaInicial" label="Categoria de Inicio" value="%{#nombreCategoria}" readonly="true"></s:textfield>
                <br/>
                <s:form action="redirigirAEditarConfiguracion">
                    <s:hidden name="idConfiguracion" value="%{configuracion.getId()}" ></s:hidden>
                    <s:submit name="btnEditar" value="Editar"></s:submit>
                </s:form>
            </div>
        </div>

        <%@include file="/vistas/footer.html" %>
    </body>
</html>