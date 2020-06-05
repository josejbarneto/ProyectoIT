<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<s:if test="#session.usuario == null">
    <s:action name="redireccionaInicio" executeResult="true">
    </s:action>
</s:if>

<s:if test="#session.usuario == 2">
    <s:action name="redireccionaInicio" executeResult="true">
    </s:action>
</s:if>

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
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaAnunciantes" var="anunciante">
                                    <tr>
                                        <td><s:property value="nombre" /></td>
                                        <td><s:property value="direccion" /></td>
                                        <td><s:property value="email" /></td>
                                        <td>
                                            <s:form action="redirigirAMostrarAnunciante">
                                                <s:hidden name="idAnunciante" value="%{#anunciante.getId()}"></s:hidden>
                                                <s:submit name="btnMostrar" value="Mostrar" cssClass="ui green button"></s:submit>
                                            </s:form>
                                        </td>
                                    </tr>
                                </s:iterator>
                                <s:form action="redirigirACrearAnunciante">
                                    <s:submit name="btnCrear" value="Crear" cssClass="ui green button"></s:submit>
                                </s:form>
                                <s:form action="redirigirACrearAnuncio">
                                    <s:submit name="btnCrear2" value="Crear Anuncio" cssClass="ui green button"></s:submit>
                                </s:form>
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
