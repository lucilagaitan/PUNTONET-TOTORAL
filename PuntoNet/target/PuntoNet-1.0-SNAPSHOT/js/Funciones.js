$(document).ready(function () 
{
//ALERTA ELIMINAR PRODUCTO DEL CARRITO
    $('.formulario-EliminarDelCarrito').on("click", function (e) {
        e.preventDefault();

        
        swal({
            title: "¡Atencion!",
            text: "¡Esta por eliminar el producto seleccionado del carrito! ¿Desea continuar?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    if (willDelete) {
                        this.submit();
                    } else {
                        swal("¡Perfecto! Continuemos con la compra...");
                    }
                });
    });
    
     //ACTUALIZAR CANTIDAD CARRITO COMPRAS
  $('.formulario-ActualizarCantidad').on("click", function (e) {
     this.submit();  
   });
    

//    //ALERTA ELIMINAR PRODUCTO 
//    $('.formulario-EliminarProducto').on("click", function (e) {
//        e.preventDefault();
//        swal({
//            title: "¡Atencion!",
//            text: "¡Esta por eliminar el producto seleccionado! ¿Desea continuar?",
//            icon: "warning",
//            buttons: true,
//            dangerMode: true,
//        })
//                .then((willDelete) => {
//                    if (willDelete) {
//                        this.submit();
//                    } else {
//                        swal("Operacion cancelada");
//                    }
//                });
//    });
    

//    
//    //ALERTA CONFIRMACION DE COMPRA ACEPTAR
//    $('#btn-ConfirmarCompra').on("click", function (e) {
//        e.preventDefault();
//        swal({
//            title: "¡Atencion!",
//            text: "¡Esta por confirmar su pedido y compra! ¿Esta seguro que desea continuar?",
//            icon: "warning",
//            buttons: true,
//            dangerMode: true,
//        })
//                .then((willDelete) => {
//                    if (willDelete) {
//                         $('.form-ConfirmarCompra').submit();
//                    } else {
//                        swal("Operacion cancelada");
//                    }
//                });
//    });
//

//    //ALERTA CONFIRMAR EDICION DE PRODUCTO
//    $('#btn-ModificarEnvio').on("click", function (e) {
//        e.preventDefault();
//        swal({
//            title: "¡Atencion!",
//            text: "¡Esta por modificar los datos del envio! ¿Seguro que desea continuar?",
//            icon: "warning",
//            buttons: true,
//            dangerMode: true,
//        })
//                .then((willDelete) => {
//                    if (willDelete) {
//                        $('.formulario-EditarEnvio').submit();
//                    } else {
//                        swal("¡Ok! Cambios sin registrar");
//                    }
//                });
//    });
//    




});