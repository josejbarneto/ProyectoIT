<%@taglib prefix="s" uri="/struts-tags" %>
<nav class="ui fixed menu">
    <a href="/youevent/vistas/inicio.jsp" class="item">
        <img src="/youevent/img/YOUEVENT.png" style="width: 70px;">
    </a>
    <a href="youevent/vistas/redirigirAListarEvento.action" class="item"><i class="glass cheers icon"></i>Eventos</a>
    <a href="" class="item"><i class="tags icon"></i>Categorias</a>
    <div class="right menu">
        <%-- SI ESTA LOGADO Y ES ADMIN --%>
        <s:if test="%{#session.usuario!=null && #session.usuario.rol==0}">
            <a href='' class="item"><i class="tools icon"></i>Administrar</a>
        </s:if>
        <%-- FIN SI ESTA LOGADO Y ES ADMIN--%>

        <%-- SI ESTA LOGADO Y ES ORGANIZADOR --%>
        <s:if test="%{#session.usuario!=null && #session.usuario.rol==1}">
            <a id="crearEvento" class="item" href="/youevent/vistas/redirigirACrearEvento.action"><i class="plus circle icon"></i>Nuevo Evento</a>
        </s:if>
        <%-- FIN SI ESTA LOGADO Y ES ORGANIZADOR --%>


        <%-- SI ESTA LOGADO Y ES USUARIO NORMAL --%>
        <s:if test="%{#session.usuario!=null && #session.usuario.rol==2}">
            <a class="item" href=""><i class="ticket icon"></i>Mis Entradas</a>
        </s:if>
        <%-- FIN SI ESTA LOGADO Y ES USUARIO NORMAL --%>

        <a class="item" href=""><i class="user circle icon"></i>Ver perfil</a>
        <a class="ui item" href="/youevent/vistas/login.jsp"><i class="sign in alternate icon"></i>Login</a>
        <s:if test="%{#session.usuario==null">
            <a class="ui item" href="/youevent/vistas/login.jsp"><i class="sign in alternate icon"></i>Login</a>
        </s:if>
        <s:else>
            <a class="ui item" href=""><i class="sign out alternate icon"></i>Logout</a>
        </s:else>
    </div>
</nav>


