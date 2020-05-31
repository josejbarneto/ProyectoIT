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
                            <s:textfield name="evento" label="Evento" value="%{oferta.getEvento().getNombre()}" readonly="true"></s:textfield>
                            <s:textfield name="descuento" label="descuento" value="%{oferta.getDescuento()}%" readonly="true"></s:textfield>
                            <s:textfield name="fechainicio" label="Fecha inicio de la oferta" value="%{oferta.getTInicio()}" readonly="true"></s:textfield>
                            <s:textfield name="fechafin" label="Fecha fin de la oferta" value="%{oferta.getTFin()}" readonly="true"></s:textfield>
                        </div>
                        <br/>

                        
                <aside class="ui four wide column">
                    <%-- OFERTAS/ANUNCIOS --%>
                </aside>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>