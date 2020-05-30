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
            <div class="ui basic segment">
                <s:form action="accionCrearAnunciante" cssClass="ui fluid table form">
                    <s:textfield name="nombre" label="Nombre del anunciante"></s:textfield>
                    <s:textfield name="direccion" label="Direccion"></s:textfield>
                    <s:textfield name="email" label="Email"></s:textfield>
                    <s:submit cssClass="ui green button" name="btnEnviar" value="Enviar"></s:submit>
                </s:form>
            </div>
        </div>
        

        <%@include file="/vistas/footer.html" %>
    </body>
</html>
