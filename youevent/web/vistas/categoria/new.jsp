
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
                        <h1>Crear Categoria</h1>
                        <s:form action="accionCrearCategoria" method="post">
                            <s:textfield name="nombre" label="Nombre"></s:textfield>
                            <s:textfield name="descripcion" label="Descripcion"></s:textfield>
                            <s:submit name="btnEnviar" value="Enviar"></s:submit>
                        </s:form>

                        <s:form action="redirigirAListarCategoria" method="post">
                            <s:submit name="btnListarCategoria" value="Listar Categoria"></s:submit>
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