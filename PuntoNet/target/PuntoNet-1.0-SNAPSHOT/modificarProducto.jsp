<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <body>

        <div class="container">

            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
            <div class="alert alert-danger text-center" role="alert" >
                <h6>${ mensajeError }</h6>
            </div>
            <% }%>
        </div>  
        <br> <br> <br> <br>

    <center>
        <div class="container align-middle center">
            <h1 class="display-4">MODIFICAR PRODUCTO</h1>
        </div>
    </center>


    <br> <br> 

    <form action="ModificarProductoServlets?accion=editar" method="post">
        <div class="container center">   
            <input type="hidden" name="txtId" value="${p.idProducto}">

            <div class="row">

                <div class="col-md-12">

                    <div class="form-group">
                        <label for="txtDescripcion" class="h5">NOMBRE DE PRODUCTO</label>
                        <input class="form-control" type="text" name="txtDescripcion" id="txtDescripcion" value="${p.descripcionProducto}" />
                    </div>

                    <div class = "row g-3">

                        <div class="form-group col">
                            <label for="cboMarca" class="h5">MARCA</label>
                            <select class="form-control" name="cboMarca">
                                <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                                <c:forEach var="m" items="${marca}">
                                    <option value="${m.idMarca}" <c:if test="${m.idMarca==p.marcaProducto.idMarca}"> selected</c:if>>${m.descripcionMarca}</option>
                                </c:forEach>
                            </select> 
                        </div>

                        <div class="form-group col">
                            <label for="cboRubro" class="h5">RUBRO</label>
                            <select class="form-control" name="cboRubro">
                                <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                                <c:forEach var="r" items="${rubro}">
                                    <option value="${r.idRubro}" <c:if test="${r.idRubro==p.rubroProducto.idRubro}"> selected</c:if>>${r.descripcionRubro}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>

                    <div class = "row g-3">
                        <div class="form-group col">
                            <label for="txtCantidad" class="h5">CANTIDAD</label>
                            <input class="form-control" type="text" name="txtCantidad" id="txtCantidad" value="${p.cantidadProducto}"/>
                        </div>

                        <div class="form-group col">
                            <label for="txtCosto" class="h5">COSTO</label>
                            <input class="form-control" type="text" name="txtCosto" id="txtCosto" value="${p.costoProducto}"/>
                        </div>


                        <div class="form-group col">
                            <label for="txtUtilidad" class="h5">UTILIDAD</label>
                            <input class="form-control" type="text" name="txtUtilidad" id="txtUtilidad" value="${p.utilidadProducto}"/>
                        </div>



                    </div>

                </div>


                <br><br> 

                <input type="submit" value="GUARDAR" class="btn btn-primary"/>

            </div>
        </div>

    </div>
</form>

</body>
</html>
