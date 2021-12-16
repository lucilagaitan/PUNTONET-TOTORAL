<%@include file="menu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!DOCTYPE html>

<html>   
    <body>
        <br> <br> <br> <br> <br> 
        
        
        <div class="container">
            <% if (request.getAttribute("registroExitoso") != null && !request.getAttribute("registroExitoso").equals("")) { %> 
            <div class="alert alert-danger text-center" role="alert" >
                <h6>${ registroExitoso }</h6>
            </div>
            <%}%>
        </div>
        
        
        


        <div class="container-fluid">
            <center>
                <div class="container align-middle center">
                    <h1 class="display-4">REGISTRAR USUARIO</h1>
                </div>
            </center>

            

            <div class="container">   
                <br> <br>  
                <form class="row g-3" action="AltaUsuarioServlets" method="post">

                    <div class="col-md-6">
                        <label for="txtNombre" class="form-label h5">NOMBRE/s *</label>
                        <input required type="text" class="form-control"  aria-label="First name" name="txtNombre">
                    </div>

                    <div class="col-md-6">
                        <label for="txtApellido" class="form-label h5">APELLIDO/s *</label>
                        <input required type="text" class="form-control"  aria-label="Last name" name="txtApellido">
                    </div>

                    <div class="col-md-6">
                        <br> 
                        <label for="txtUsuario" class="form-label h5">NOMBRE DE USUARIO *</label>
                        <input required type="text" class="form-control" name="txtUsuario">
                    </div>

                    <div class="col-md-6">
                        <br> 
                        <label for="txtContraseña" class="form-label h5">CONTRASEÑA *</label>
                        <input required type="password" class="form-control" name="txtContra">
                    </div>

                    <div class="col-6">
                        <br> 
                        <label for="txtDireccion" class="form-label h5">DIRECCION *</label>
                        <input required type="text" class="form-control" name="txtDireccion" >
                    </div>

                    <div class="col-md-6">
                        <br> 
                        <label for="txtLocalidad" class="form-label h5">LOCALIDAD *</label>
                        <input required type="text" class="form-control" name="txtLocalidad">
                    </div>

                    <div class="col-md-6">
                        <br> 
                        <label for="txtTelefono" class="form-label h5">TELEFONO *</label>
                        <input required type="text" class="form-control" name="txtTelefono">
                    </div>

                    <div class="form-group col-md-6"> <br> 
                        <label for="cboSexo" class="h5">SEXO *</label>
                        <select class="form-control" name="cboSexo">
                            <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                            <c:forEach var="sexo" items="${listaSexo}">
                                <option value="${sexo.idSexo}">${sexo.getDescripcion()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-md-6"> <br>
                        <label for="cboDoc" class="h5">TIPO DE DOCUMENTO *</label>
                        <select class="form-control" name="cboDoc">
                            <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                            <c:forEach var="doc" items="${listaDoc}">
                                <option value="${doc.idTipoDoc}">${doc.getDescripcion()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-md-6">
                        <br> 
                        <label for="txtDocumento" class="form-label h5">DOCUMENTO *</label>
                        <input required type="text" class="form-control" name="txtDocumento">
                    </div>
                   
                    <div>
                        <br>
                        <small  class="form-text text-muted">Datos obligatorios*</small>     
                    </div>
                    
                    <div class="col-md-8">
                        <br> <br> <br>
                        <label>
                            <input type='checkbox' value='SI' name="acepto"/>
                            Al crear tu cuenta estas aceptando nuestros
                        </label>
                        <a href="terminosCondiciones.jsp">Términos y Condiciones</a>
                    </div>

                    <center>
                        <div class="col-6 center">
                            <br> <br> <br> <br>  <br> <br> <br> <br> <br>  <br>
                            <button type="submit" class="btn btn-primary btn-lg">REGISTRARSE</button>
                        </div>
                        <br> <br> <br> <br> <br> <br> 
                    </center>   

                    <br> <br> <br> <br> <br> <br> 
                </form>
            </div> </div>
    </body>
    
    <script type='text/javascript'>
/*
    function validar(){
var todo_correcto = true;

/*nombre*/
/*
    if(document.getElementById('txtNombre').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar un Nombre con mas de 2 letras");
}
*/

/*apellido*/
/*
    if(document.getElementById('txtApellido').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar un Apellido con mas de 2 letras");
}
*/

/*usuario*/
/*
    if(document.getElementById('txtUsuario').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar un Usuario con mas de 2 letras");
}
*/

/*contraseña*/
/*
    if(document.getElementById('txtContraseña').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar una Contraseña con mas de 2 caracteres");
}
*/

/*direccion*/
/*
if(document.getElementById('txtDireccion').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar una Direccion con mas de 2 letras");
}
*/

/*localidad*/
/*
if(document.getElementById('txtLocalidad').value.length < 2 ){
    todo_correcto = false;
     alert("Ingresar una Localidad con mas de 2 letras");
}
*/

/*telefono*/
/*
if(isNaN(document.getElementById('txtTelefono').value)){
    todo_correcto = false;
    alert("Ingresar solo Numeros");
}
*/

/*documento*/
/*
if(isNaN(document.getElementById('txtDocumento').value)){
    todo_correcto = false;
    alert("Ingresar solo Numeros");
}
*/

/*Para comprobar el email haremos uso de una expresión regular. Esto es una secuencia
de caracteres que nos dirá si el valor ingresado por el usuario tiene estructura de
correo electrónico. Lo que hacemos es obtener el value del campo de texto destinado
al email, y le aplicamos el método test() del objeto global RegExp(que nos permite
trabajar con expresiones regulares).*/
    /*
var expresion = /^[a-z][\w.-]+@\w[\w.-]+\.[\w.-]*[a-z][a-z]$/i;
var email = document.form1.email.value;
if (!expresion.test(email)){
    todo_correcto = false;
}
*/

/*sexo*/
/*
if(document.getElementById('cboSexo').value == ''){
    todo_correcto = false;
    alert("Seleccionar Sexo");
}
*/

/*tipodoc*/
/*
if(document.getElementById('cboDoc').value == ''){
    todo_correcto = false;
    alert("Seleccionar Tipo de Documento");
}
*/
/*
if(!document.getElementById('acepto').checked){
    todo_correcto = false;
}
*/
/*
return todo_correcto;
}
*/
</script>  
</html>
