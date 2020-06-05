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
                <s:textfield name="nombre" label="Nombre del anunciante" value="%{anunciante.getNombre()}" readonly="true"></s:textfield>
                <s:textfield name="direccion" label="Direccion" value="%{anunciante.getDireccion()}" readonly="true"></s:textfield>
                <s:textfield name="email" label="Email" value="%{anunciante.getEmail()}" readonly="true"></s:textfield>
                <br/>

                <s:iterator value="listaAnuncios">
                    <tr>
                        <td>Anuncio: <s:property value="contenido" /></td>
                        <td>Precio:  <s:property value="precio" /></td>
                    </tr>
                    <br/>
                </s:iterator>

                <s:if test="%{#session.usuario!=null && #session.usuario.rol!=2}">
                <s:form action="redirigirAEditarAnunciante">
                    <s:hidden name="idAnunciante" value="%{anunciante.getId()}" ></s:hidden>
                    <s:submit name="btnEditar" value="Editar"></s:submit>
                </s:form>
                <s:form action="accionEliminarAnunciante">
                    <s:hidden name="idAnunciante" value="%{anunciante.getId()}"></s:hidden>
                    <s:submit name="btnEliminar" value="Eliminar"></s:submit>
                </s:form>
                </s:if>
            </div>
        </div>

        <%@include file="/vistas/footer.html" %>
    </body>
</html>