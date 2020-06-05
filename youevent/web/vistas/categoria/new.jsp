<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <%@include file="/vistas/includes.jsp" %>
    </head>
    <body>
        <%@include file="../../vistas/header.jsp" %>
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
                        <s:form action="accionCrearCategoria" method="post" cssClass="ui fluid table form">
                            <s:textfield name="nombre" label="Nombre"></s:textfield>
                            <s:textfield name="descripcion" label="Descripcion"></s:textfield>
                            <s:submit cssClass="ui basic green button" name="btnEnviar" value="Enviar"></s:submit>
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