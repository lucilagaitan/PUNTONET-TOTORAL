<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>   
    <body>
        <div class="container">
            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
            <div class="alert alert-danger text-center" role="alert" >
                <h6>${ mensajeError }</h6>
            </div>
            <% }%>
        </div> 
    
        <br> <br> <br> <br> <br>
        
        <center>
            <div class="container align-middle center">
                <h1 class="display-4">REGISTRAR RUBRO</h1>
            </div>
        </center>

        <div class="container">   
            <br> <br>  
            <center>
                <form action="AltaRubroServlets" method="post">
                    <div class="row row g-3">

                        <div class="col">
                            <input class="form-control" type="text" name="txtDescripcionRubro" id="txtDescripcionRubro" placeholder="Nombre Rubro"/>
                        </div>

                        <div class="col">
                            <input type="submit" value="REGISTRAR" class="btn btn-primary"/>
                        </div>

                    </div>
                </form>
            </center>
        </div>
    </body>
</html>
