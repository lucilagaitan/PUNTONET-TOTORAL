<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

    <body>
        <br> <br> <br> <br> <br> 

    <center>
        <div class="container align-middle center">
            <h1 class="display-4">EDITAR FOTO</h1>
        </div>
    </center>

    <div class="container">   
        <br> <br>  
        <center>
            <form action="ModificarProductoServlets?accion=fotoEditada" enctype="multipart/form-data" method="post">


                <input type="hidden" name="txtId" value="${p.idProducto}">
                <center>
                    <div class="row">

                        <div class="col-md-12">

                            <div class="row">

                                <br><br>
                                <div class="form-group col-md-6">
                                    <label for="txtDescripcion" class="h5">NOMBRE DE PRODUCTO</label>
                                    <input class="form-control" type="text" name="txtDescripcion" id="txtDescripcion" value="${p.descripcionProducto}" />
                                </div>
                                <div>
                                    <img src="ControladorIMG?idA=${p.idProducto}" width="160" height="160"/>     
                                </div>

                            </div>
                            <br><br>
                            <div class="col-md-4">                                                    
                                <div class="form-group"> 
                                    <label class="h5">IMAGEN DEL PRODUCTO</label>
                                    <input onchange="validateSize(this)" type="file" accept="image/png, image/jpeg" class="btn-dark" name="fileImagen">                                                        
                                </div>
                            </div>
                            <br><br>
                            <input type="submit" value="GUARDAR" class="btn btn-primary"/>
                        </div>
                    </div>
                </center>
            </form>
        </center>
    </div>

</body>
</html>
