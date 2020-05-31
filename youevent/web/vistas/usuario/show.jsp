<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<s:if test="#session.usuario == null">
    <s:action name="redireccionaInicio" executeResult="true">
    </s:action>
</s:if>

<s:if test="#session.usuario != 0">
    <s:action name="redireccionaInicio" executeResult="true">
    </s:action>
</s:if>


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
                            <h1>Mostrar Usuario</h1>

                            Id: <s:property value="%{usuario.getId()}"/><br/>
                            Nombre: <s:property value="%{usuario.getNombre()}"/><br/>
                            Rol: <s:property value="%{usuario.getRol()}"/><br/>
                            Usuario: <s:property value="%{usuario.getUsuario()}"/><br/>
                            Contraseña: <s:property value="%{usuario.getContrasenya()}"/><br/>
                            Email: <s:property value="%{usuario.getEmail()}"/>
                            <br/>

                            <s:form action="redirigirAEditarUsuario">
                                <s:hidden name="idUsuario" value="%{usuario.getId()}" ></s:hidden>
                                <s:submit name="btnEditar" value="Editar"></s:submit>
                            </s:form>

                            <s:form action="accionEliminarUsuario">
                                <s:hidden name="idUsuario" value="%{usuario.getId()}"></s:hidden>
                                <s:submit name="btnBorrar" value="Eliminar"></s:submit>
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