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
                            <s:textfield name="nombre" label="Nombre de evento" value="%{evento.getNombre()}" readonly="true"></s:textfield>
                            <s:textfield name="descripcion" label="Descripcion" value="%{evento.getDescripcion()}" readonly="true"></s:textfield>
                            <s:textfield name="lugar" label="Lugar" value="%{evento.getLugar()}" readonly="true"></s:textfield>
                            <s:textfield name="aforo" label="Aforo" value="%{evento.getAforo()}" readonly="true"></s:textfield>
                            <s:textfield name="precio" label="Precio" value="%{evento.getPrecio()}" readonly="true"></s:textfield>
                            <s:textfield name="fecha" label="Fecha" value="%{evento.getFecha()}" readonly="true">
                            </s:textfield>
                        </div>
                        <br/>

                        <div class="ui tag labels">
                            <s:iterator value="listaCategorias" var="categoria">
                                <div class="ui label"><s:property value="nombre" /></div>
                            </s:iterator>
                        </div>
                        <br/>

                        <%-- Si eres el organizador o admin puedes editar-eliminar --%>
                        <s:if test="%{#session.usuario!=null && #session.usuario.rol!=2}">
                            <s:form action="redirigirAEditarEvento" theme="simple">
                                <s:hidden name="idEvento" value="%{evento.getId()}" ></s:hidden>
                                <s:submit cssClass="ui basic blue right floated button" name="btnEditar" value="Editar"></s:submit>
                            </s:form>

                            <s:form action="redirigirACrearOferta" theme="simple">
                                <s:hidden name="idEvento" value="%{evento.getId()}"></s:hidden>
                                <s:submit cssClass="ui basic yellow button" name="btnCrearOferta" value="Crear oferta"></s:submit>
                            </s:form>

                            <s:form action="accionEliminarEvento" theme="simple">
                                <s:hidden name="idEvento" value="%{evento.getId()}"></s:hidden>
                                <s:submit cssClass="ui basic red button" name="btnEliminar" value="Eliminar"></s:submit>
                            </s:form>
                        </s:if>
                        <s:else>
                            <%-- Si eres comprador compras o admin puedes editar-eliminar --%>
                            <s:form action="redirigirACrearEntrada" cssClass="ui form">
                                <s:textfield name="numEntradas" label="Numero de entradas"></s:textfield>
                                <s:hidden name="idEvento" value="%{evento.getId()}"></s:hidden>
                                <s:submit cssClass="ui basic green button" name="btnComprarEntradas" value="Comprar entradas"></s:submit>
                            </s:form> 
                        </s:else>
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