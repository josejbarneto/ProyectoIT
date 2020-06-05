
<div class="ui twelve wide column">               
    <div class="ui segment">
        <table class="ui stripped table">
            <thead>
                <tr>
                    <th>Contenido</th>
                    <th>Anunciante</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="#session.listaAnuncios" var="anuncio">
                <tr>
                    <td><s:property value="contenido" /></td>
                    <td><s:property value="anunciante.getNombre()" /></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
</div>