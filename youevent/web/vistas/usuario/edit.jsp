<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Usuario</h1>
        <s:form action="accionEditarUsuario">
            <s:textfield name="nombre" label="Nombre" value="%{usuario.getNombre()}"></s:textfield>
            <s:textfield name="rol" label="Rol" value="%{usuario.getRol()}"></s:textfield>
            <s:textfield name="us" label="Usuario" value="%{usuario.getUsuario()}"></s:textfield>
            <s:textfield name="contrasenya" label="Contraseña" value="%{usuario.getContrasenya()}"></s:textfield>
            <s:textfield name="email" label="Correo" value="%{usuario.getEmail()}"></s:textfield>
            <s:hidden name="id" value="%{usuario.getId()}"></s:hidden>
            <s:submit name="btnEnviar" value="Enviar"></s:submit>
        </s:form>
    </body>
</html>