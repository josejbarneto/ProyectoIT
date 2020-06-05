
<div class="ui twelve wide column">               
    <div class="ui segment">
        <table class="ui stripped table">
            <thead>
                <tr>
                    <th>Contenido</th>
                    <th>Precio</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="#session.listaAnuncios" var="anuncio">
                <tr>
                    <td><s:property value="contenido" /></td>
                <td><s:property value="precio" /></td>
                <td>
                <s:form action="redirigirAMostrarAnuncio">
                    <s:hidden name="idAnuncio" value="%{#anuncio.getId()}"></s:hidden>
                    <s:submit cssClass="ui yellow button" name="btnMostrar" value="Mostrar"></s:submit>
                </s:form>
                </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>