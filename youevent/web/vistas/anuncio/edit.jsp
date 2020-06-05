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
                        <h1>Editar Anuncio</h1>
                        <s:form action="accionEditarAnuncio">
                            <s:textfield name="contenido" label="Contenido" value="%{anuncio.getContenido()}"></s:textfield>
                            <s:textfield name="precio" label="Precio" value="%{anuncio.getPrecio()}"></s:textfield>
                            <s:select cssClass="ui dropdown" label="Anunciante" name="anunciantes" listValue="nombre" listKey="id" list="anunciantesLista" required="true"/>

                            <s:hidden name="id" value="%{anuncio.getId()}"></s:hidden>
                            <s:submit name="btnEnviar" value="Enviar"></s:submit>
                        </s:form>
                    </div>
                </div>
                <aside class="ui four wide column">
                    <%@include file="/vistas/aside.jsp" %>
                </aside>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>