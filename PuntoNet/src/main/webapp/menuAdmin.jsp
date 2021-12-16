<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">       
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="Estilos/styles.css" rel="stylesheet">
        <script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>PuntoNet</title>     
    </head>

    <style>
        .img1{
            padding: 100;
        }
        .M2{
            background-color:cornflowerblue
        }
        .M3{

            font-style: inherit;
            font-family: sans-serif;
        }
    </style>



    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

            <div class="container">

                <div>
                    <a class="navbar-brand nombreAcademia" href="homeAdmin.jsp"> ~ P U N T O N E T</a>
                </div>
                <br> <br>
                
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <ion-icon name="menu-sharp"></ion-icon>
                </button>
                <a href="https://www.facebook.com/PuntoNet-Totoral-120683374674390/?ref=aymt_homepage_panel" target="_blank" class="icon" title="Share on Facebook">
                    <ion-icon style="width: 100px"  name="logo-facebook"></ion-icon>                      
                </a>
                <a href="https://www.instagram.com/puntonet_totoral/" target="_" class="icon" title="Share on Instagram">
                    <ion-icon style="width: 50px; color: #3f729b" name="logo-instagram"></ion-icon>
                </a> 
                
                
                <div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="navbarResponsive">

                    <ul class="navbar-nav ml-auto">
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                PRODUCTO
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="AltaProductoServlets">Nuevo Producto</a>
                                <a class="dropdown-item" href="productos.jsp">Ver/Editar/Eliminar Productos</a>                                    
                            </div>
                        </li>
                        
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                MARCA & RUBRO
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="AltaMarcaServlets">Nueva Marca</a>
                                <a class="dropdown-item" href="AltaRubroServlets">Nuevo Rubro</a>
                                <a class="dropdown-item" href="ListadoMarcaRubroServlets">Ver/Editar/Eliminar Productos</a>                                    
                            </div>
                        </li>
                        
                        
                        <li class="nav-item">
                            <a class="nav-link" href="tiendaAdmin.jsp">TIENDA</a>
                        </li>
                        
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                REPORTES
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="ReportesServlets">REPORTE 1/2</a>
                                <a class="dropdown-item" href="ReporteTresServlets">REPORTE 3</a>
                                <a class="dropdown-item" href="ReporteCuatroServlets">REPORTE 4</a>                                    
                            </div>
                        </li>
                        
                        
                        
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                MI CUENTA
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <div class="dropdown-divider"></div>
                                    <form action="Login" method="get">
                                        <input class="dropdown-item" type="submit" name="accion" value="Cerrar Sesion"/>
                                    </form>
                            </div>
                        </li>

                    </ul>

                </div>

            </div>

        </nav>

    </html> 