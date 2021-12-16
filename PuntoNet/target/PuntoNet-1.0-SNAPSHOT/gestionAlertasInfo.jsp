<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%--ALERTA DE USUARIO EXISTENTE EN REGISTRO DE USUARIO --%>
<% if (request.getAttribute("errorUsuarioExistente") != null && !request.getAttribute("errorUsuarioExistente").equals("")) { %> 
<script>
    swal("¡Error!", "Este correo ya se encuentra registrado con un usuario, ¡prueba con otro!", "error");
</script>
<%}%>

<%--ALERTA DE DATOS INCORRECTOS/ CAMPOS VACIOS EN REGISTRO DE USUARIO --%>
<% if (request.getAttribute("errorCargaDatos") != null && !request.getAttribute("errorCargaDatos").equals("")) { %> 
<script>
    swal("¡Atención!", "No se pudo realizar el registro, ¡revise los datos e intente nuevamente!", "info");
</script>
<%}%>

<%--ALERTA DE CORREO/CONTRASEÑA INCORRECTA O CAMPOS VACIOS --%>
<% if (request.getAttribute("infoErrorIniciarSesion") != null && !request.getAttribute("infoErrorIniciarSesion").equals("")) { %> 
<script>
    swal("¡Error al tratar de iniciar sesion!", "Revise los datos ingresados e intente nuevamente", "error");
</script>
<%}%>

<%--ALERTA DE USUARIO CREADO EXITOSAMENTE (EN REGISTRO DE USUARIO) --%>
<% if (request.getAttribute("registroExitoso") != null && !request.getAttribute("registroExitoso").equals("")) { %> 
<script>
    swal("¡Registro Exitoso!", "Por favor, Inicie Sesión", "success");
</script>
<%}%>

<%--ALERTA DE SESION CERRADA CORRECTAMENTE USUARIO --%>
<% if (request.getAttribute("infoSesionCerradaCorrecto") != null && !request.getAttribute("infoSesionCerradaCorrecto").equals("")) { %> 
<script>
    swal("¡Sesión cerrada correctamente!", "¡Nos vemos luego!", "success");
</script>
<%}%>
<%--ALERTA DE CATEGORIA CREADA EXITOSAMENTE --%>
<% if (request.getAttribute("infoCategoriaRegistradaExitosamente") != null && !request.getAttribute("infoCategoriaRegistradaExitosamente").equals("")) { %> 
<div class="col-lg-8">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>¡Categoria creada correctamente!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<%}%>

<%--ALERTA DE CATEGORIA EXISTENTE --%>
<% if (request.getAttribute("infoCategoriaExistente") != null && !request.getAttribute("infoCategoriaExistente").equals("")) { %> 
<div class="col-lg-8">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>¡No se pudo registrar la categoria!</strong> Error al ingresar los datos o ya se encuentra registrada
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<%}%>

<%--ALERTA PRODUCTO REGISTRADO CORRECTAMENTE --%>
<% if (request.getAttribute("infoProductoRegistrado") != null && !request.getAttribute("infoProductoRegistrado").equals("")) { %> 
<div class="col-lg-8">
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>¡Producto registrado!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<%}%>

<%--ALERTA DE ERROR AL REGISTRAR EL PRODUCTO --%>
<% if (request.getAttribute("infoErrorProducto") != null && !request.getAttribute("infoErrorProducto").equals("")) { %> 
<div class="col-lg-8">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>¡Error al registrar un Producto!</strong> Revise los datos e intente nuevamente
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<%}%>

<%--ALERTA DE ERROR BUSCAR EL PRODUCTO EN GESTION PRODUCTOS--%>
<% if (request.getAttribute("infoErrorBusquedaProducto") != null && !request.getAttribute("infoErrorBusquedaProducto").equals("")) { %> 
<div class="col-md-12 text-center">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>¡Error al buscar el Producto!</strong> Revise los datos e intente nuevamente
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
</div>
<%}%>


<%--ALERTA PRODUCTO ELIMINADO CARRITO --%>
<% if (request.getAttribute("Eliminado") != null && !request.getAttribute("Eliminado").equals("")) { %> 
<script>
    swal({
        title: "¡Producto eliminado del carrito!",
        text: "Presione aceptar para continuar comprando",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA PRODUCTO AGREGADO COMPRAR DIRECTO CARRITO --%>
<% if (request.getAttribute("AgregadoParaComprar") != null && !request.getAttribute("AgregadoParaComprar").equals("")) { %> 
<script>
    swal({
        title: "¡Producto agregado al carrito!",
        text: "Presione aceptar para continuar con la compra",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA PRODUCTO EDITADO CORRECTAMENTE --%>
<% if (request.getAttribute("ProductoEditadoCorrectamente") != null && !request.getAttribute("ProductoEditadoCorrectamente").equals("")) { %> 
<script>
    swal({
        title: "¡Producto editado correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA PRODUCTO ELIMINADO --%>
<% if (request.getAttribute("productoEliminadoExitosamente") != null && !request.getAttribute("productoEliminadoExitosamente").equals("")) { %> 
<script>
    swal({
        title: "¡Producto eliminado correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA ENVIO ELIMINADO --%>
<% if (request.getAttribute("envioEliminadoExitosamente") != null && !request.getAttribute("envioEliminadoExitosamente").equals("")) { %> 
<script>
    swal({
        title: "¡Tipo de envio eliminado correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA ENVIO INSERTADO CORRECTAMENTE --%>
<% if (request.getAttribute("envioInsertadoCorrectamente") != null && !request.getAttribute("envioInsertadoCorrectamente").equals("")) { %> 
<script>
    swal({
        title: "¡Tipo de envio registrado correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA DATOS CLIENTE MODIFICADOS --%>
<% if (request.getAttribute("datosClienteModificadosCorrectamente") != null && !request.getAttribute("datosClienteModificadosCorrectamente").equals("")) { %> 
<script>
    swal({
        title: "¡Datos editados correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>

<%--ALERTA ESTADO DEL PEDIDO MODIFICADO --%>
<% if (request.getAttribute("pedidoActualizadoCorrectamente") != null && !request.getAttribute("pedidoActualizadoCorrectamente").equals("")) { %> 
<script>
    swal({
        title: "¡Pedido actualizado correctamente!",
        text: "Presione Aceptar",
        icon: "success",
        button: "Aceptar",
    });
</script>
<%}%>



<%--ALERTA NO HAY IMAGEN PARA HACER UPDATE --%>
<% if (request.getAttribute("imagenNullUp") != null && !request.getAttribute("imagenNullUp").equals("")) { %> 
<script>
    swal("¡No hay una imagen cargada!");
</script>
<%}%>

