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
                        <s:form action="accionCrearEvento" cssClass="ui fluid table form">
                            <s:textfield name="nombre" label="Nombre de evento"></s:textfield>
                            <s:textfield name="descripcion" label="Descripcion"></s:textfield>
                            <s:textfield name="lugar" label="Lugar"></s:textfield>
                            <s:select cssClass="ui dropdown" label="Categorias" name="categoriasEvento" listValue="nombre" listKey="id" list="categorias" multiple="true" required="true"/>
                            <s:submit cssClass="ui green button" name="btnEnviar" value="Enviar"></s:submit>
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