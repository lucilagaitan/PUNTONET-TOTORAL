<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>   
    <body>
        <br> <br> <br> <br>

        <center>
            <div class="container align-middle center">
                <h1 class="display-4">MODIFICAR RUBRO</h1>
            </div>
        </center>

        <div class="container">   

            <br> <br>  
            <center>

                <form action="ModificarRubroServlet" method="post">

                    <input type="hidden" name="txtId" value="${r.idRubro}">

                    <div class="row row g-3">

                        <div class="col">
                            <input class="form-control" type="text" name="txtDescripcionRubro" id="txtDescripcionRubro" placeholder="Nombre Rubro" value="${r.descripcionRubro}"/>
                        </div>

                        <div class="col">
                            <input type="submit" value="GUARDAR" class="btn btn-primary"/>
                        </div>

                    </div>

                </form>

            </center>

        </div>

    </body>

</html>
