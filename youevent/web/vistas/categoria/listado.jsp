<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="#session.usuario == null">
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
                        <h1>Listado Categorias</h1>

                        <s:iterator value="listaCategorias" var="categoria">
                            <tr>
                                <td><s:property value="nombre" /></td>
                                <td><s:property value="descripcion" /></td>
                                <td><s:property value="lugar" /></td>
                                <s:form action="redirigirAMostrarCategoria">
                                    <s:hidden name="idCategoria" value="%{#categoria.getId()}"></s:hidden>
                                    <s:submit name="btnMostrar" value="Mostrar"></s:submit>
                                </s:form>
                            </tr>
                        </s:iterator>

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