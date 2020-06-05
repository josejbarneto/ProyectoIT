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
                        <s:form action="accionCrearOferta" cssClass="ui fluid table form">
                            <s:textfield name="descuento" label="Descuento"></s:textfield>
                            <s:textfield name="fechainicio" label="Fecha inicio de la oferta"></s:textfield>
                            <s:textfield name="fechafin" label="Fecha fin de la oferta"></s:textfield>
                            <s:hidden name="idEvento" value="%{idEvento}" ></s:hidden>
                            <s:submit cssClass="ui green button" name="btnCrear" value="Crear"></s:submit>
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