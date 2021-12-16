<%@include file="menuAdmin.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

    <body>

        <br> <br> <br> <br>  <br> 

        <center>
            <div class="container align-middle center">
                <h1 class="display-4">REGISTRAR PRODUCTO</h1>
            </div>
        </center>

        <div class="container center">   
            <br> <br> 
            <center>
                <form action="AltaProductoServlets" method="post" onsubmit='return validar()'enctype="multipart/form-data">
                    <center>
                        <div class="row">
                            
                            <div class="col-md-12">

                                <div class="form-group">
                                    <label for="txtDescripcion" class="h5">NOMBRE DE PRODUCTO *</label>
                                    <input required class="form-control" type="text" name="txtDescripcion" id="txtDescripcion"/>
                                </div>

                                <div class = "row g-3">
                                    <div class="form-group col">
                                        <label for="cboMarca" class="h5">MARCA *</label>
                                        <select class="form-control" name="cboMarca">
                                            <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                                            <c:forEach var="marca" items="${listaMarcas}">
                                                <option value="${marca.idMarca}">${marca.getDescripcionMarca()}</option>
                                            </c:forEach>
                                        </select> 
                                    </div>

                                    <div class="form-group col">
                                        <label for="cboRubro" class="h5">RUBRO *</label>
                                        <select class="form-control" name="cboRubro">
                                            <option value= "" selected = "true" disabled> SELECCIONAR... </option>
                                            <c:forEach var="rubro" items="${listaRubros}">
                                                <option value="${rubro.idRubro}">${rubro.getDescripcionRubro()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class = "row g-3">
                                    <div class="form-group col">
                                        <label for="txtCantidad" class="h5">CANTIDAD *</label>
                                        <input required class="form-control" type="text" name="txtCantidad" id="txtCantidad"/>
                                    </div>

                                    <div class="form-group col">
                                        <label for="txtCosto" class="h5">COSTO *</label>
                                        <input required class="form-control" type="text" name="txtCosto" id="txtCosto"/>
                                    </div>


                                    <div class="form-group col">
                                        <label for="txtUtilidad" class="h5">UTILIDAD *</label>
                                        <input required class="form-control" type="text" name="txtUtilidad" id="txtUtilidad"/>
                                    </div>
                                </div>

                                <div class="col-md-4">                                                    
                                    <div class="form-group"> 
                                        <label class="h5">IMAGEN DEL PRODUCTO</label>
                                        <input onchange="validateSize(this)" type="file" accept="image/png, image/jpeg" class="btn-dark" name="fileImagen">                                                        
                                    </div>
                                </div>
                               

                                <br><br> 

                                <input type="submit" value="REGISTRAR" class="btn btn-primary btn-lg"/>

                            </div>
                        </div>
                    </center>
                </form>
            </center>
        </div>  
    </body>
    
    
<script type='text/javascript'>
/*
function validar(){
var todo_correcto = true;
    */

/*nombre*/
/*
    if(document.getElementById('txtDescripcion').value.length < 5 ){
    todo_correcto = false;
    alert("Ingresar un Nombre de Producto con mas de 5 letras");
}


/*cantidad*/
   /* 
if(isNaN(document.getElementById('txtCantidad').value)){
    todo_correcto = false;
    alert("Ingresar solo Numeros");
}



/*utilidad*/
   /* 
if(isNaN(document.getElementById('txtUtilidad').value)){
    todo_correcto = false;
    alert("Ingresar solo Numeros");
}


/*costo*/
/*
        if(isNaN(document.getElementById('txtCosto').value)){
    todo_correcto = false;
    alert("Ingresar solo Numeros");
}
*/



/*rubro*/
/*
 if(document.getElementById('cboRubro').value == ''){
    todo_correcto = false;
    alert("Seleccionar Rubro");
}
        */


/*marca*/
/*
        if(document.getElementById('cboMarca').value == ''){
    todo_correcto = false;
    alert("Seleccionar Marca");
}


/*return todo_correcto;*/
}

</script> 
</html>
