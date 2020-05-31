

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
            <div class="ui grid">
                <div class="ui twelve wide column">               
                    <div class="ui segment">
                        <h1>Mostrar Categoria</h1>

                        <s:textfield name="nombre" label="Nombre " value="%{categoria.getNombre()}" readonly="true"></s:textfield>
                        <s:textfield name="descripcion" label="Descripcion" value="%{categoria.getDescripcion()}" readonly="true"></s:textfield>
                        <s:textfield name="id" label="Id" value="%{categoria.getId()}" readonly="true"></s:textfield>

                        <s:form action="redirigirAEditarCategoria">
                            <s:hidden name="idEvento" value="%{categoria.getId()}" ></s:hidden>
                            <s:submit name="btnEditar" value="Editar"></s:submit>
                        </s:form>

                        <s:form action="accionEliminarCategoria">
                            <s:hidden name="idCategoria" value="%{categoria.getId()}"></s:hidden>
                            <s:submit name="btnEliminar" value="Eliminar"></s:submit>
                        </s:form>

                    </div>
                </div>
                <aside class="ui four wide column">
                    <%-- OFERTAS/ANUNCIOS --%>
                </aside>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>