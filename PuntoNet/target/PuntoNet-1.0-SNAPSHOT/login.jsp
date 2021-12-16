<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <body>
        <br> <br> <br> <br> <br>

        <div class="container align-middle center">
            <center> 

                <h1 class="display-4">INICIAR SESION</h1>
            </center>
        </div>
        
        <br>
       <div class="container">

            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
            <div class="alert alert-danger text-center" role="alert" >
                <h6>${ mensajeError }</h6>
            </div>
            <% }%>
        </div> 
    </div>

        <div class="container">
            <center>
                <form class="logueo" method="POST" action="Login">
                    <center> 
                        <div class="row">

                            <div class="col-md-12">

                                <div class="row mb-3">
                                    <label label for="txtUsuario" class="col-sm-2 col-form-label lead">USUARIO </label>
                                    <div class="form-group col-sm-8">
                                        <input class="form-control" type="text" name="txtUsuario"/>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <label for="txtPass" class="col-sm-2 col-form-label lead ">CONTRASEÑA </label>
                                    <div class="form-group col-sm-8">
                                        <input class="form-control" type="password" name="txtPass"/> 
                                    </div>
                                </div>

                                <input type="submit" value="Ingresar"name="accion" class="btn btn-primary btn-lg " />
                            </div>
                    </center>
                </form>
            </center>
        </div>

        <center>
            <form action="AltaUsuarioServlets" method="get">
                <div class="col-lg-6">
                    <br><br>                                 
                    <p class="lead">¿Todavía no tenés cuenta?</p>  
                    <small  class="form-text text-muted">Es necesario tener una cuenta para realizar compras</small>  
                    <br>
                    <button type="submit" class="btn btn-dark">Crear cuenta</button>         

                </div>
            </form>
        </center>

    </body>
</html>
