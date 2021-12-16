<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestionReportes" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <body>
        <br> <br> <br> <br> <br> <br> 
        <center>
            <h1 class="display-6"> Reporte estadístico de los productos por marca y rubro</h1>
        </center>
    
        <br> <br>
        
        <div class="container">
            <table class="table"> 
                <thead class="thead-dark">
                    <tr class="tr">
                        <th scope="col">NOMBRE</th>
                        <th scope="col">MARCA</th>
                        <th scope="col">RUBRO</th>
                        <th scope="col">CANTIDAD</th>
                        <th scope="col">COSTO</th>
                        <th scope="col">UTILIDAD</th>
                        <th scope="col">PRECIO VENTA</th>
                    </tr> 
                </thead>

                <tbody>
                    <c:forEach items="${ reporteUno}" var="item">
                        <tr>
                            <td> ${ item.descripcionProducto }</td>
                            <td> ${ item.marcaProducto }</td>
                            <td> ${ item.rubroProducto }</td>
                            <td> ${ item.cantidadProducto }</td>
                            <td> $${ item.costoProducto }</td>
                            <td> ${ item.utilidadProducto } %</td>
                            <td> $${ Math.round(( item.utilidadProducto * item.costoProducto) / 100 + item.costoProducto) }</td>
                            
                        </tr>
                    </c:forEach>
                <tbody>

            </table>
        </div>
        
        
        <br> <br> <br> <br> <br> <br> 
        <center>
            <h1 class="display-6"> Reporte estadístico de los productos más vendidos</h1>
        </center>
    
        <br> <br>
        <div class="container">
            <table class="table"> 
                <thead class="thead-dark">
                    <tr class="tr">
                        <th scope="col">PRODUCTO</th>
                        <th scope="col">CANTIDAD</th>
                    </tr> 
                </thead>

                <tbody>
                    <c:forEach items="${ reporteDos }" var="item">
                        <tr>
                            <td> ${ item.producto }</td>
                            <td> ${ item.cantidad}</td>
                           
                            
                        </tr>
                    </c:forEach>
                <tbody>

            </table>
        </div>
        
        <br><br><br>
    </body>
</html>
