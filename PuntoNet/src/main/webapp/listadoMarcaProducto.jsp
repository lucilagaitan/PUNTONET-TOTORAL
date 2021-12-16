<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>   
    <body>
        
        <br> <br> <br> <br> <br> 

        <div class="container">

            <div class="row">

                <div class="col">

                    <center> 
                        <div class="container align-middle center">
                            <h1 class="display-4">MARCAS</h1>
                        </div> 
                    </center>

                    <br> <br>

                    <center>

                        <table class="table">

                            <thead class="thead-dark">
                                <tr class="tr">
                                    <th scope="col">MARCA</th>
                                    <th scope="col">ELIMINAR</th>
                                    <th scope="col">MODIFICAR</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${ gestor.obtenerComboMarca }" var="item">
                                    <tr>
                                        <td>${ item.descripcionMarca }</td>
                                        <td><a  class="btn btn-danger" href="EliminarMarcaServlets?id_Marca=${item.idMarca}">ELIMINAR</a></td>
                                        <td><a  class="btn btn-warning" href="ModificarMarcaServlets?id_Marca=${item.idMarca}">MODIFICAR</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                    </center>

                </div>

                <div class="col">

                    <center> 
                        <div class="container align-middle center">
                            <h1 class="display-4">RUBROS</h1>
                        </div> 
                    </center>

                    <br> <br>

                    <center> 
                        <table class="table">
                            <thead class="thead-dark">
                                <tr class="tr">
                                    <th scope="col">RUBRO</th>
                                    <th scope="col">ELIMINAR</th>
                                    <th scope="col">MODIFICAR</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${ gestor.obtenerComboRubro }" var="item">
                                    <tr>
                                        <td>${ item.descripcionRubro }</td>
                                        <td><a  class="btn btn-danger" href="EliminarRubroServlet?id_Rubro=${item.idRubro}">ELIMINAR</a></td>
                                        <td><a  class="btn btn-warning" href="ModificarRubroServlet?id_Rubro=${item.idRubro}">MODIFICAR</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table> 

                    </center>

                </div>      

            </div>        
        </div>

    </body>

</html>
