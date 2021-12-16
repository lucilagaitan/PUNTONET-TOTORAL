<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <body>
        <br> <br> <br> <br> <br> <br> 
    <center>
        <h1 class="display-4">PRODUCTOS DISPONIBLES</h1>
    </center>

    <br> <br>

    <div class="container">
        <table class="table"> 
            <thead class="thead-dark">
                <tr class="tr">
                    <th scope="col">NOMBRE</th>
                    <th scope="col">FOTO</th>
                    <th scope="col">MARCA</th>
                    <th scope="col">RUBRO</th>
                    <th scope="col">CANTIDAD</th>
                    <th scope="col">COSTO</th>
                    <th scope="col">UTILIDAD</th>
                    <th scope="col">PRECIO VENTA</th>
                    <th scope="col">ELIMINAR</th>
                    <th scope="col">MODIFICAR DATOS</th>
                    <th scope="col">MODIFICAR FOTO</th>
                </tr> 
            </thead>

            <tbody>
                <c:forEach items="${ gestor.obtenerProductosParaTienda }" var="item">
                    <tr>
                        <td> ${ item.descripcionProducto }</td>
                        <td>
                            <img src="ControladorIMG?idA=${item.idProducto}" width="80" height="90"/>
                        </td>
                        <td> ${ item.marcaProducto }</td>
                        <td> ${ item.rubroProducto }</td>
                        <td> ${ item.cantidadProducto }</td>
                        <td> $${ item.costoProducto }</td>
                        <td> ${ item.utilidadProducto } %</td>
                        <td> AR $${ Math.round(( item.utilidadProducto * item.costoProducto) / 100 + item.costoProducto) }</td>
                        <td><a  class="btn btn-danger" href="EliminarProductoServlets?id_Producto=${item.idProducto}">ELIMINAR</a></td>
                        <td><a  class="btn btn-warning" href="ModificarProductoServlets?accion=editar&id_Producto=${item.idProducto}">MODIFICAR</a></td>
                        <td>

                            <form action="ModificarProductoServlets?accion=foto&id_Producto=${item.idProducto}" method="post">
                                <input class=" btn btn-secondary" type="submit" value="CAMBIAR">
                            </form></td>
                    </tr>
                </c:forEach>
            <tbody>

        </table>
    </div>
</body>
</html>
