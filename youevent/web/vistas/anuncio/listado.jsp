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
                        <table class="ui stripped table">
                            <thead>
                                <tr>
                                    <th>Contenido</th>
                                    <th>Precio</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaAnuncios" var="anuncio">
                                    <tr>
                                        <td><s:property value="contenido" /></td>
                                        <td><s:property value="precio" /></td>
                                        <td>
                                            <s:form action="redirigirAMostrarAnuncio">
                                                <s:hidden name="idAnuncio" value="%{#anuncio.getId()}"></s:hidden>
                                                <s:submit name="btnMostrar" value="Mostrar"></s:submit>
                                            </s:form>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </div>
                </div>
                <aside class="ui four wide column">

                </aside>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>