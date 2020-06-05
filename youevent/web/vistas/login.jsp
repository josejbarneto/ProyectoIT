<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>YOUEVENT</title>
        <s:head/>
        <%@include file="/vistas/includes.jsp" %>
        <link href="/youevent/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="main-grid" class="ui middle aligned center aligned grid">
            <div id="main-column" class="column">
                <a class="ui image header" href="/youevent">
                    <img src="/youevent/img/YOUEVENT.png" class="image">
                </a>
                <s:form action="comprobarLogin" cssClass="ui form" theme="simple">
                    <div class="ui field">
                        <s:textfield name="usuario" placeholder="Nombre de usuario">
                        </s:textfield>
                    </div>
                    <div class="ui field">
                        <s:password name="password" placeholder="Contraseña">
                        </s:password>
                    </div>
                    <s:submit cssClass="ui green right floated button" name="btnEnviar" value="Enviar"></s:submit>
                </s:form>
                <s:form action="redirigirARegistrar" theme="simple">
                    <s:submit cssClass="ui right floated blue button" name="btnRegistrar" value="Registrar"></s:submit>
                </s:form>
                <s:form action="redirigirARecuperarClave" theme="simple">
                    <s:submit cssClass="ui left floated orange button" name="btnRecuperarClave" value="Recuperar contraseña"></s:submit>
                </s:form>
            </div>
        </div>
    </body>
</html>
