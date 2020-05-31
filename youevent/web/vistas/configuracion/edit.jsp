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

                <s:form action="accionEditarConfiguracion">
                    <s:if  test="! configuracion.isModoNocturno()">
                        <s:checkbox label="Modo nocturno" name="modoNocturno" value="false" fieldValue="true"/>
                    </s:if>
                    <s:else>
                        <s:checkbox label="Modo nocturno" name="modoNocturno" value="true" fieldValue="true"/>
                    </s:else>
                    <br/>
                    <s:if  test="! configuracion.isOpenNewTab()">
                        <s:checkbox label="Abrir en pestaña nueva" name="openNewTab" value="false" fieldValue="true"/>
                    </s:if>
                    <s:else>
                        <s:checkbox label="Abrir en pestaña nueva" name="openNewTab" value="true" fieldValue="true"/>
                    </s:else>
                    <br/>
                    <s:select cssClass="ui dropdown" label="Categorias" name="id_categoria" listValue="nombre" listKey="id" value="id" list="listaCategorias" required="true"/>
                        <br/>
                    <s:hidden name="idConfiguracion" value="%{configuracion.getId()}"></s:hidden>
                    <s:hidden name="id_categoriaInicial" value="%{categoria.getId()}"></s:hidden>
                    <s:submit name="btnEditar" value="Editar"></s:submit>
                </s:form>
            </div>
        </div>

        <%@include file="/vistas/footer.html" %>
    </body>
</html>