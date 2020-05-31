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
                        <h1>Mostrar Evento</h1>

                        <s:textfield name="contenido" label="Contenido" value="%{anuncio.getContenido()}" readonly="true"></s:textfield>
                        <s:textfield name="precio" label="Precio" value="%{anuncio.getPrecio()}" readonly="true"></s:textfield>
                        <s:textfield name="nombre_anunciante" label="Nombre anunciante" value="%{anunciante.getNombre()}" readonly="true"></s:textfield>
                        <s:textfield name="id_anunciante" label="Id del anunciante" value="%{anunciante.getId()}" readonly="true"></s:textfield>

                            <br/>

                        <s:form action="redirigirAEditarAnuncio">
                            <s:hidden name="idAnuncio" value="%{anuncio.getId()}" ></s:hidden>
                            <s:submit name="btnEditar" value="Editar"></s:submit>
                        </s:form>

                        <s:form action="accionEliminarAnuncio">
                            <s:hidden name="idAnuncio" value="%{anuncio.getId()}"></s:hidden>
                            <s:submit name="btnEliminar" value="Eliminar"></s:submit>
                        </s:form>
                    </div>
                </div>
                <aside class="ui four wide column">

                </aside>
            </div>
        </div>
        <%@include file="/vistas/footer.html" %>
    </body>
</html>