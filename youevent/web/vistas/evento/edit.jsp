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
        <s:form action="accionEditarEvento">
            <s:textfield name="nombre" label="Nombre de evento" value="%{evento.getNombre()}"></s:textfield>
            <s:textfield name="descripcion" label="Descripcion" value="%{evento.getDescripcion()}"></s:textfield>
            <s:textfield name="lugar" label="Lugar" value="%{evento.getLugar()}"></s:textfield>   
            <s:textfield name="aforo" label="Aforo" value="%{evento.getAforo()}"></s:textfield>    
            <s:textfield name="precio" label="Precio" value="%{evento.getPrecio()}"></s:textfield>  
            <s:textfield name="fecha" label="Fecha" value="%{evento.getFecha()}"></s:textfield> 
            <s:hidden name="id" value="%{evento.getId()}"></s:hidden>
            <s:submit cssClass="ui green button" name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
                        </div>

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
</div>
</div>

<%@include file="/vistas/footer.html" %>
</body>
</html>