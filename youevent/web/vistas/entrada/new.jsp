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
                        <h3>El precio de las <s:property value="numEntradas" /> entradas seleccionadas es de un total de <s:property value="precioTotal" />€</h3>
                            <s:form action="accionCrearEntrada">
                                <s:hidden name="numEntradas" value="numEntradas" ></s:hidden>
                                <s:hidden name="idEvento" value="idEvento" ></s:hidden>
                                <s:submit cssClass="ui green button" name="btnConfirmar" value="Confirmar compra"></s:submit>
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