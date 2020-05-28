package modelo.entidades;
// Generated 28-may-2020 22:53:01 by Hibernate Tools 4.3.1



/**
 * Anuncio generated by hbm2java
 */
public class Anuncio  implements java.io.Serializable {


     private Integer id;
     private int idAnunciante;
     private String contenido;
     private float precio;
     private Anunciante anuncianteById;
     private Anunciante anuncianteByIdAnunciante;

    public Anuncio() {
    }

	
    public Anuncio(int idAnunciante, String contenido, float precio) {
        this.idAnunciante = idAnunciante;
        this.contenido = contenido;
        this.precio = precio;
    }
    public Anuncio(int idAnunciante, String contenido, float precio, Anunciante anuncianteById, Anunciante anuncianteByIdAnunciante) {
       this.idAnunciante = idAnunciante;
       this.contenido = contenido;
       this.precio = precio;
       this.anuncianteById = anuncianteById;
       this.anuncianteByIdAnunciante = anuncianteByIdAnunciante;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getIdAnunciante() {
        return this.idAnunciante;
    }
    
    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }
    public String getContenido() {
        return this.contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Anunciante getAnuncianteById() {
        return this.anuncianteById;
    }
    
    public void setAnuncianteById(Anunciante anuncianteById) {
        this.anuncianteById = anuncianteById;
    }
    public Anunciante getAnuncianteByIdAnunciante() {
        return this.anuncianteByIdAnunciante;
    }
    
    public void setAnuncianteByIdAnunciante(Anunciante anuncianteByIdAnunciante) {
        this.anuncianteByIdAnunciante = anuncianteByIdAnunciante;
    }




}


