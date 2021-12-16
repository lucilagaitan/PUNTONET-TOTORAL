<%@include file="menuCliente.jsp" %>
<%@include file="gestionAlertasInfo.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/Funciones.js" type="text/javascript"></script>
<html>

    <body>
        <br><br> <br><br> 

        <form action="ContinuarCompra?accion=ConfirmarPedido" method="post">
            <div class="container">     
                <br>
                <center>
                    <h1 class="display-4">DETALLE FACTURA</h1>
                </center>

                <br>
                <div class="tableScroll">
                    <table role="table" class="table table-hover">
                        <thead role="rowgroup">
                            <tr class="text-center">      
                                <th role="columnheader">ITEM</th>
                                <th role="columnheader">PRODUCTO</th>
                                <th role="columnheader">FOTO</th>
                                <th role="columnheader">MARCA</th>
                                <th role="columnheader">RUBRO</th>
                                <th role="columnheader">CANTIDAD</th>
                                <th role="columnheader">PRECIO</th>
                                <th role="columnheader">NUMERO VENTA</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${carrito}">
                                <tr class="text-center">
                                    <td> ${ item.getItem() }</td>
                                    <td>${item.descripcionProducto}</td>
                                    <td>
                                        <img src="ControladorIMG?idA=${item.getIdProducto()}" width="80" height="90"/>
                                    </td>
                                    <td> ${ item.marcaProducto.descripcionMarca }</td>
                                    <td> ${ item.rubroProducto.descripcionRubro }</td>
                                    <td>  $ ${Math.round (item.precioVenta )}</td>   
                                    <td> ${(item.cantidadProducto)}</td>
                                    <td> $ ${Math.round (item.getSubTotal())}</td>
                                </tr>                                    
                            </c:forEach>
                        </tbody>
                    </table>
                </div>                               
                <br>
                <br>  
                <br>

                <h3 class="text-center">Total a pagar: <c:out value="$${Math.round (total)}"></c:out></h3> 

                    <center>
                        <div class="col-sm-8">
                            <div class="card"> 
                                <div class="card-header">
                                    <h3>FORMA DE PAGO</h3>
                                </div>
                                <br>
                                <center>
                                    <div class="form-group col-md-8">
                                        <select name="cboFormasDePago" class="form-control">    
                                            <option value="0">SELECCIONE...</option>
                                        <c:forEach items="${listaFormasDePago}" var="fp">                                               
                                            <option value="${fp.id_TipoPago}">${fp.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </center>
                            <br>
                        </div>
                    </div>
                </center>     

                <br><br><br><br>
                <input type="submit" value="Confirmar Pedido y Pagar"  id="btn-ConfirmarCompra" class="btn btn-primary btn-lg btn-block">
                <br>
            </div>
        </form>

        <br><br><br><br>  
    </body>
</html>
