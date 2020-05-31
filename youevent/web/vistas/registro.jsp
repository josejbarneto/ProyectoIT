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
                <a class="ui image header" href="/youevent/vistas/inicio.jsp">
                    <img src="/youevent/img/YOUEVENT.png" class="image">
                </a>
                <s:form action="registrar" method="post" cssClass="ui form" theme="simple">
                    <div class="ui field">
                        <s:textfield name="nombre" placeholder="Nombre">
                        </s:textfield>
                    </div>
                    <div class="ui field">
                        <s:textfield name="usuario" placeholder="Nombre de usuario">
                        </s:textfield>
                    </div>
                    <div class="ui field">
                        <s:password name="password" placeholder="Contraseña">
                        </s:password>
                    </div>
                    <div class="ui field">
                        <s:textfield name="email" placeholder="Email">
                        </s:textfield>
                    </div>
                    <a class="ui red left floated button" href="/youevent/vistas/login.jsp">
                        Cancelar
                    </a>
                    <s:submit name="btnEnviar" cssClass="ui green right floated button" value="Enviar"></s:submit>
                </s:form>
            </div>
        </div>
    </body>
</html>
