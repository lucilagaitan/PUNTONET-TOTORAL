<%@include file="menuCliente.jsp" %>
<%@include file="gestionAlertasInfo.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/Funciones.js" type="text/javascript"></script>
<html>

    <body >
        
        
        <head>            
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">       
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="Estilos/styles.css" rel="stylesheet">
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            if (window.history.replaceState) {
                window.history.replaceState(null, null, window.location.href);
            }
        </script>
        <title>Pack 6 Online - Factura N° ${modeloFactura.nFactura}</title>
    </head>
    
    
    
        <br> <br> <br>
        <div class=" row">
            <div class=" col-lg-4">
                <center>
                    <img src="imagenes/pp.jpg" class="img-fluid max-width: 100% height: auto;" width="200" heigth="180" alt="Responsive image"/>
                </center>

            </div>

            <div class="container  col-lg-8">
                <div class="text-center">
                    <br>                            
                    <h3>¡PAGO EXITOSO! <br><br> ¡MUCHAS GRACIAS POR SU COMPRA!</h3>               
                </div>
            </div>
        </div> 
        <div class=" col-lg-12">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4"> <br> <br>
                        <h3>MI FACTURA</h3>                  
                    </div>   
                </div>                        
                <br>
                <br>
                <br>
                <div>
                    <h5>Factura N° </h5>
                    <input disabled type="text" class="form-control" value="<jsp:getProperty name="modeloFactura" property="nFactura"></jsp:getProperty>"/>
                </div>                        
                <br>     
                <div class="form-row">                            
                    <div class="form-group col-md-6">
                        <label>Cliente</label>
                         <input disabled type="text" class="form-control" value="<jsp:getProperty name="modeloFactura" property="cliente"></jsp:getProperty>"/>

                    </div>
                    <div class="form-group col-md-4">
                        <label>Monto Total </label>
                         <input disabled type="text" class="form-control" value="<jsp:getProperty name="modeloFactura" property="total"></jsp:getProperty>"/>
                                
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Tipo de Pago:</label>
                         <input disabled type="text" class="form-control" value="<jsp:getProperty name="modeloFactura" property="tipoPago"></jsp:getProperty>"/>

                    </div>

                    <div class="form-group col-md-5">
                        <label>Tipo Entrega:</label>
                         <input disabled type="text" class="form-control" value="<jsp:getProperty name="modeloFactura" property="tipoEntrega"></jsp:getProperty>"/>

                    </div>
                </div>
                <br>
                <br>

                <br>
                <br>
                <div>
                    <h5>Productos</h5>                  
                </div>                        
                <br>                        
                <br>

                <br>

                <div class="tableScroll">
                    <table role="table" class="table table-hover">
                        <thead role="rowgroup">
                            <tr class="text-center">      
                                <th role="columnheader">PRODUCTO</th>
                                <th role="columnheader">FOTO</th>
                                <th role="columnheader">CANTIDAD</th>
                                <th role="columnheader">PRECIO UNITARIO</th>
                                <th role="columnheader">SUBTOTAL</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${listaDetalleFactura}">
                                <tr class="text-center">                                    
                                    <td>${item.getProducto()}</td>
                                    <td>
                                        <img src="ControladorIMG?idA=${item.getIdProd()}" width="80" height="90"/>
                                    </td>
                                    <td>  ${item.getCantidad()}</td>   
                                    <td>  $ ${Math.round (item.getMonto() )}</td>   
                                    <td> $ ${Math.round (item.getMonto() * item.getCantidad())}</td>
                                </tr>                                    
                            </c:forEach>
                        </tbody>
                    </table>
                </div>  

                <br>
                <div class="quitarSeccion">
                    <a type="button" href="listadoProductos.jsp" class="btn btn-dark btn-lg btn-block">Volver a Tienda</a>
                    <br>
                    <input type="button" value="Descargar Factura"  class="btn btn-primary btn-lg btn-block" onclick="print()">
                </div>
            </div>
        </div> 

    </body>
</html>

