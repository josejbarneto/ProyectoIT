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
                        <div class="ui form"> 
        <s:form action="accionEditarCategoria">
            <s:textfield name="nombre" label="Nombre " value="%{categoria.getNombre()}"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion" value="%{categoria.getDescripcion()}"></s:textfield>   
            <s:hidden name="id" value="%{categoria.getId()}"></s:hidden>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
                        </div>

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
</div>
</div>

<%@include file="/vistas/footer.html" %>
</body>
</html>