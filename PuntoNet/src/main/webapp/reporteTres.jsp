<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestionReportes" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <body>
        <br> <br> <br> <br> <br> <br> 
    <center>
        <h1 class="display-6"> Reporte estadístico de las ventas realizadas en un mes determinado </h1>
    </center>

    <br> <br>
    <center>
        <div class="col-lg-12">
            <div class="container">
                <div class="text-center">

                    <br>
                    <br>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>Buscar monto recaudado por mes</label>
                            <center><form action="ReporteTresServlets?accion=reporte1" method="post">      
                                    <div class="input-group">                                
                                        <select class="custom-select" name="cboMeses">
                                            <option value="0">Total</option>                                                    
                                            <option value="1">Enero</option>                                                    
                                            <option value="2">Febrero</option>                                                    
                                            <option value="3">Marzo</option>                                                    
                                            <option value="4">Abril</option>                                                    
                                            <option value="5">Mayo</option>                                                    
                                            <option value="6">Junio</option>                                                    
                                            <option value="7">Julio</option>                                                    
                                            <option value="8">Agosto</option>                                                    
                                            <option value="9">Septiembre</option>                                                    
                                            <option value="10">Octubre</option>                                                    
                                            <option value="11">Noviembre</option>                                                    
                                            <option value="12">Diciembre</option>     
                                        </select>
                                        <div class="input-group-append">
                                            <button class="btn btn-dark" type="submit">Buscar</button>
                                        </div>
                                    </div>
                                </form> 
                            </center> 
                        </div>

                        <div class="form-group col-md-4">                                        
                            <input type="text" class="form-control" name="" hidden>
                        </div>
                        <div class="form-group col-md-4">
                            <label>Monto</label>
                            <input type="text" class="form-control" value="$${montoTotal}" readonly="">
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </center>
    <center>
        <div class="col-lg-12">
            <div class="container">
                <div class="text-center">

                    <br>
                    <br>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>Buscar monto recaudado en periodo de tiempo</label>
                            <center><form action="ReporteTresServlets?accion=reporte2" method="post">      
                                    <div class="input-group">                                
                                        <select class="custom-select" name="cboMeses1">
                                            <option value="0">Total</option>                                                    
                                            <option value="1">Enero</option>                                                    
                                            <option value="2">Febrero</option>                                                    
                                            <option value="3">Marzo</option>                                                    
                                            <option value="4">Abril</option>                                                    
                                            <option value="5">Mayo</option>                                                    
                                            <option value="6">Junio</option>                                                    
                                            <option value="7">Julio</option>                                                    
                                            <option value="8">Agosto</option>                                                    
                                            <option value="9">Septiembre</option>                                                    
                                            <option value="10">Octubre</option>                                                    
                                            <option value="11">Noviembre</option>                                                    
                                            <option value="12">Diciembre</option>     
                                        </select>
                                        </center>          
                                        <br>
                                        <center>
                                            <div class="input-group">                                
                                                <select class="custom-select" name="cboMeses2">
                                                    <option value="0">Total</option>                                                    
                                                    <option value="1">Enero</option>                                                    
                                                    <option value="2">Febrero</option>                                                    
                                                    <option value="3">Marzo</option>                                                    
                                                    <option value="4">Abril</option>                                                    
                                                    <option value="5">Mayo</option>                                                    
                                                    <option value="6">Junio</option>                                                    
                                                    <option value="7">Julio</option>                                                    
                                                    <option value="8">Agosto</option>                                                    
                                                    <option value="9">Septiembre</option>                                                    
                                                    <option value="10">Octubre</option>                                                    
                                                    <option value="11">Noviembre</option>                                                    
                                                    <option value="12">Diciembre</option>     
                                                </select>
                                                <div class="input-group-append">
                                                    <button class="btn btn-dark" type="submit">Buscar</button>
                                                </div>
                                            </div>
                                            </form> 
                                        </center> 
                                    </div>

                                    <div class="form-group col-md-4">                                        
                                        <input type="text" class="form-control" name="" hidden>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label>Monto</label>
                                        <input type="text" class="form-control" value="$${montoTotalPeriodo}" readonly="">
                                    </div>
                                    </div>


                                    </div>
                                    </div>
                                    </div>
                            </center>
                            </body>
                            </html>


