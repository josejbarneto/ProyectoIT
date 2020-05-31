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
                        <table class="ui stripped table">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Lugar</th>
                                    <th>Aforo</th>
                                    <th>Precio</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="listaEntradas" var="entrada">
                                    <tr>
                                        <td><s:property value="nombre" /></td>
                                        <td><s:property value="descripcion" /></td>
                                        <td><s:property value="lugar" /></td>
                                        <td><s:property value="aforo" /></td>
                                        <td><s:property value="precio" />€</td>
                                        <td>
                                            <s:form action="accionEliminarEntrada">
                                                <s:hidden name="idEntrada" value="%{#entrada.getId()}"></s:hidden>
                                                <s:submit name="btnDevolver" value="Devolver"></s:submit>
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