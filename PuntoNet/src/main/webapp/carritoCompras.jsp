<%@include file="menuCliente.jsp" %>
<%@include file="gestionAlertasInfo.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/Funciones.js" type="text/javascript"></script>
<!DOCTYPE html>

<html>

    <body>
        <br> <br> <br> <br> <br> 

    <center>
        <div class="container align-middle center">
            <h1 class="display-4">CARRITO DE COMPRAS</h1>
        </div>
    </center>

    <br> 

    <div class="container mt-4">
        <div class="row">
            <div class="col-sm-12">

                <table class="table"> 
                    <thead class="thead-dark">
                        <tr class="tr">
                            <th scope="col">ITEM</th>
                            <th scope="col">NOMBRE</th>
                            <th scope="col">FOTO</th>
                            <th scope="col">MARCA</th>
                            <th scope="col">RUBRO</th>
                            <th scope="col">PRECIO</th>
                            <th scope="col">CANTIDAD</th>
                            <th scope="col">SUBTOTAL</th>
                            <th scope="col">ACCION</th>
                        </tr> 
                    </thead>

                    <tbody>
                        <c:forEach items="${carrito }" var="item">
                            <tr>
                                <td> ${ item.getItem() }</td>
                                <td> ${ item.getDescripcionProducto()}</td>
                                <td>
                                    <img src="ControladorIMG?idA=${item.getIdProducto()}" width="80" height="90"/>
                                </td>
                                <td> ${ item.getMarcaProducto().getDescripcionMarca() }</td>
                                <td> ${ item.getRubroProducto().getDescripcionRubro() }</td>
                                <td>  $ ${Math.round (item.getPrecioVenta() )}</td>
                                <td>
                                    <form class="formulario-ActualizarCantidad" action="carritoServlets?accion=ActualizarCantidad" method="post">
                                        <input type="hidden" name="idProducto" value="${item.getIdProducto()}"/>
                                        <input min="1" max="100" type="number" name="txtCantidad" class="form-control text-center" value="${item.getCantidadProducto()}"/>
                                    </form> 
                                </td>
                                <td>  
                                    $ ${Math.round (item.getSubTotal())}
                                </td>
                                <td>
                                    <form class="formulario-EliminarDelCarrito" action="carritoServlets?accion=Eliminar" method="post">     
                                        <input name="idProducto" type="hidden" value="${item.getIdProducto()}"/>
                                        <input type="submit" id="btnEliminar" class="btn btn-danger btn-sm" value="Eliminar del carrito"/>                                            
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>

                <br><br>
            </div>
        </div>
    </div>


    <form action="carritoServlets?accion=ProseguirCompra" method="post">
        <center>
            <div class="col-sm-8">
                <div class="card"> 

                    <div class="card-header">
                        <h3>FORMA DE ENTREGA</h3>
                    </div>
                    <br>
                    <center>
                        <div class="form-group col-md-8">                        
                            <select id="formaEnvios" name="cboFormasDeEnvio" class="form-control"> 
                                <option value="0">SELECCIONE...</option>
                                <c:forEach items="${listaFormasDeEnvio}" var="fe"> 
                                    <option value="${fe.id_TipoEntrega}">${fe.descripcion}</option>
                                </c:forEach>    
                            </select>
                        </div>
                    </center>

                </div> 
            </div>
        </center>


        <br> <br>
        <br><br>

        <center>
            <div class="col-sm-8">
                <div class="card">

                    <div class="card-header">
                        <h3>GENERAR COMPRA</h3>
                    </div>

                    <div class="card-body">
                        <label>TOTAL A PAGAR</label>
                        <input type="text" value="$ ${Math.round (total)}"readonly="" class="from-control">
                    </div>

                    <div class="card-footer">
                        <input type="submit" value="Confirmar Compra" class="btn btn-primary btn-lg btn-block">
                    </div>

                </div>
        </center>
    </form>
</body>

</html>
