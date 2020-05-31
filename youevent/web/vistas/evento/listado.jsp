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
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Lugar</th>
                                    <th>Aforo</th>
                                    <th>Precio</th>
                                    <th>Fecha</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaEventos" var="evento">
                                    <tr>
                                        <td><s:property value="nombre" /></td>
                                        <td><s:property value="descripcion" /></td>
                                        <td><s:property value="lugar" /></td>
                                        <td><s:property value="aforo" /></td>
                                        <td><s:property value="precio" />€</td>
                                        <td><s:property value="fecha" /></td>
                                        <td>
                                            <s:form cssClass="ui form" action="redirigirAMostrarEvento" theme="simple">
                                                <s:hidden name="idEvento" value="%{#evento.getId()}"></s:hidden>
                                                <s:submit cssClass="ui basic button" name="btnMostrar" value="Mostrar"></s:submit>
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