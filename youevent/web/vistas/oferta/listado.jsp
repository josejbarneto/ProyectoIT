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
                                    <th>Evento</th>
                                    <th>Descuento</th>
                                    <th>Fecha inicio</th>
                                    <th>Fecha fin</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaOfertas" var="oferta">
                                    <tr>
                                        <td><s:property value="%{#oferta.getEvento().getNombre()}" /></td>
                                        <td><s:property value="descuento" /></td>
                                        <td><s:property value="TInicio" /></td>
                                        <td><s:property value="TFin" /></td>
                                        <td>
                                            <s:form action="redirigirAMostrarOferta">
                                                <s:hidden name="idOferta" value="%{#oferta.getId()}"></s:hidden>
                                                <s:submit name="btnMostrar" value="Mostrar" cssClass="ui basic green button"></s:submit>
                                            </s:form>
                                            <s:form action="accionEliminarOferta">
                                                <s:hidden name="idOferta" value="%{#oferta.getId()}"></s:hidden>
                                                <s:submit name="btnEliminar" value="Eliminar" cssClass="ui basic red button"></s:submit>
                                            </s:form>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
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