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
                <h1 class="display-4">PEDIDOS</h1>
            </div>
        </center>
    
     <div class="container mt-4">
        <div class="row">
            <div class="col-sm-12">

                <table class="table"> 
                    <thead class="thead-dark">
                        <tr class="tr">
                            <th scope="col">NUMERO</th>
                            <th scope="col">FECHA</th>
                            <th scope="col">MONTO</th>
                            <th scope="col">CANTIDAD DE PRODUCTOS</th>
                        </tr> 
                    </thead>

                    <tbody>
                        <c:forEach items="${listaPedidos}" var="item">
                            <tr>
                                <td> ${item.getNumVenta()}</td>
                                <td> ${item.getFecha()}</td>
                                <td> $${Math.round (item.getMonto())}</td>
                                <td> ${item.getCantidadProd()}</td>                                
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>

                <br><br>
            </div></div></div>      
    </body>
</html>
