<%@include file="menuCliente.jsp" %>
<%@include file="gestionAlertasInfo.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="gestor" scope="request" class="Controlador.GestorProductos" />
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/Funciones.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>

    <body>
        <br> <br> <br> <br> <br> 
    <center>
        <div class="container align-middle center">
            <h1 class="display-4">DATOS PERSONALES</h1>
        </div>
    </center>

    <div class="container">   
        <br> <br>  
        <form class="row g-3" action="modificarDatosUsuario" method="post">

            <input type="hidden" name="txtIdUsuario" value="<jsp:getProperty name="modeloCliente" property="idUsuario"></jsp:getProperty>"/>


                <div class="col-md-6">
                    <label for="txtNombre" class="form-label h5">NOMBRE/s *</label>
                    <input required type="text" name="txtNombre" class="form-control" value="<jsp:getProperty name="modeloCliente" property="nombreUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-md-6">
                    <label for="txtApellido" class="form-label h5">APELLIDO/s *</label>
                    <input required type="text"  name="txtApellido" class="form-control"  aria-label="Last name" value="<jsp:getProperty name="modeloCliente" property="apellidoUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-md-6">
                    <br> 
                    <label for="txtUsuario" class="form-label h5">NOMBRE DE USUARIO *</label>
                    <input type="text"  name="txtUsuario" class="form-control" value="<jsp:getProperty name="modeloCliente" property="loginUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-md-6">
                    <br> 
                    <label for="txtContraseña" class="form-label h5">CONTRASEÑA *</label>
                    <input type="password" name="txtContra" class="form-control"value="<jsp:getProperty name="modeloCliente" property="contraseñaUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-6">
                    <br> 
                    <label for="txtDireccion" class="form-label h5">DIRECCION *</label>
                    <input required type="text" name="txtDireccion" class="form-control" value="<jsp:getProperty name="modeloCliente" property="direccionUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-md-6">
                    <br> 
                    <label for="txtLocalidad" class="form-label h5">LOCALIDAD *</label>
                    <input required type="text" name="txtLocalidad" class="form-control" value="<jsp:getProperty name="modeloCliente" property="locaidadUsuario"></jsp:getProperty>"/>
                </div>

                <div class="col-md-6">
                    <br> 
                    <label for="txtTelefono" class="form-label h5">TELEFONO *</label>
                    <input required type="text" name="txtTelefono" class="form-control" value="<jsp:getProperty name="modeloCliente" property="telefonoUsuario"></jsp:getProperty>"/>
                </div>

                <div class="form-group col-md-6"> <br> 
                    <label for="cboSexo" class="h5">SEXO *</label>
                    <select class="form-control" name="cboSexo">
                        <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                    <c:forEach var="sexo" items="${sexo}">
                        <option value="${sexo.idSexo}" <c:if test="${sexo.idSexo == modeloCliente.sexoUsuario.idSexo}">selected</c:if> >${sexo.getDescripcion()}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group col-md-6"> <br>
                <label for="cboDoc" class="h5">TIPO DE DOCUMENTO *</label>
                <select class="form-control" name="cboDoc">
                    <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                    <c:forEach var="doc" items="${documento}">
                        <option value="${doc.idTipoDoc}" <c:if test="${doc.idTipoDoc == modeloCliente.tipoDocumentoUsuario.idTipoDoc}">selected</c:if>>${doc.getDescripcion()}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6">
                <br> 
                <label for="txtDocumento" class="form-label h5">DOCUMENTO *</label>
                <input required type="text" name="txtDocumento" class="form-control" value="<jsp:getProperty name="modeloCliente" property="documentUsuario"></jsp:getProperty>"/>
            </div>
            <div>
                <br>
                <small  class="form-text text-muted">Datos obligatorios*</small>     
            </div>
            <center>
                <div class="col-6 center">
                    <br> <br> <br> <br>  
                    <button type="submit" class="btn btn-primary btn-lg">ACTUALIZAR</button>
                </div>
            </center>   

            <br> <br> <br> <br> <br> <br> 
        </form>
    </div>
</body>
</html>
