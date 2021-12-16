<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestionReportes" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <body>
        <br> <br> <br> <br> <br> <br> 
    <center>
        <h1 class="display-6"> Formas de pago mas utilizadas</h1>
    </center>

    <br> <br>
    <center>
        <div class="col-lg-12">
            <div class="container">
                <div class="text-center">

                    <div class="container">
                        <div class="text-center">


                            <div class="">
                                <div class="container">
                                    <div class="text-center">
                                        <br>
                                        <br>
                                        <form action="ReporteCuatroServlets?accion=FormasPago" method="post">
                                            <div class="form-row">
                                                <div class="form-group col-md-4">
                                                    <input formtarget="_blank"  type="submit" class="btn btn-dark form-control" value="Grafico Torta" name="btnGenerarGrafico">
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <input type="text" class="form-control" name="" hidden>
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <input formtarget="_blank"  type="submit" class="btn btn-dark form-control"  value="Grafico Barra" name="btnGenerarGrafico">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <br>

            </div>
        </div>
    </div>
</center>
</body>
</html>


