package Modelo;

public class TiposDoc 
{
   
    private int idTipoDoc;
    private String descripcion;

    public TiposDoc() {
    }

    public TiposDoc(int idTipoDoc, String descripcion) {
        this.idTipoDoc = idTipoDoc;
        this.descripcion = descripcion;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    
}
