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
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaCategorias" var="categoria">
                                    <tr>
                                        <td><s:property value="nombre" /></td>
                                        <td><s:property value="descripcion" /></td>
                                        <td>
                                            <s:form action="redirigirAMostrarCategoria">
                                                <s:hidden name="idCategoria" value="%{#categoria.getId()}"></s:hidden>
                                                <s:submit name="btnMostrar" value="Mostrar" cssClass="ui green button"></s:submit>
                                            </s:form>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                        <s:if test="#session.usuario != null">
                            <a class="ui basic green button" id="crearEvento" class="item" href="/youevent/vistas/redirigirACrearCategoria.action">Crear</a>
                        </s:if>
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