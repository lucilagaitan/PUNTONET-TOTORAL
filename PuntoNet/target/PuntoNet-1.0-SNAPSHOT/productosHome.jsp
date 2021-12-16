<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <body>
        <br><br><br> <br><br>

    <center>
        <h1 class="display-4">PRODUCTOS DISPONIBLES</h1>
    </center>

    <br>




    <div class="container">

        <div class="conteiner mt-4">
            <div class="row">
                <c:forEach  items="${ gestor.getObtenerProductosParaTienda()}" var="item">
                    <div class="col-sm-4">
                        <div class="card">

                            <div class="card-header text-center">
                                <h4>${ item.descripcionProducto }</h4>
                                <label>${ item.marcaProducto }</label> <br>
                                <label>${ item.rubroProducto }</label>
                            </div>

                            <center>
                                <div class="card-body">        
                                    <img src="ControladorIMG?idA=${item.idProducto}" class="img-fluid" style="display: block;"  width="150" height="150" alt="Responsive image">  
                                </div> 
                            </center>

                            <div class="card-footer text-center">
                                <h4> AR $ ${ Math.round (( item.utilidadProducto * item.costoProducto) / 100 + item.costoProducto) }</h4>
                                <div>
                                    <a href="login.jsp" class="btn btn-outline-info">Agregar al Carrito</a>
                                </div>
                            </div>

                        </div>
                        <br> <br>
                    </div>

                </c:forEach>

            </div>
        </div>
    </div>
</body>

</html>

