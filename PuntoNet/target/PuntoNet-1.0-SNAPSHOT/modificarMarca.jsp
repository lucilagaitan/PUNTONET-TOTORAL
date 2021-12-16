<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>   
    <body>
        <br> <br> <br> <br>

        <center>
            <div class="container align-middle center">
                <h1 class="display-4">MODIFICAR MARCA</h1>
            </div>
        </center>

        <div class="container">   

            <br> <br>  

            <center>

                <form action="ModificarMarcaServlets" method="post">

                    <input type="hidden" name="txtId" value="${m.idMarca}">

                    <center>

                        <div class="row g-3">

                            <div class="col">
                                <input class="form-control" type="text" name="txtDescripcionMarca" id="txtDescripcionMarca" placeholder="Nombre Marca" value="${m.descripcionMarca}"/>
                            </div> 

                            <div class="col">
                                <input type="submit" value="GUARDAR" class="btn btn-primary"/>
                            </div>

                        </div>

                    </center>

                </form>

            </center>
        </div>
    </body>

</html>
