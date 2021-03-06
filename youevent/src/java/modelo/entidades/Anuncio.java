package modelo.entidades;
// Generated 31-may-2020 19:26:09 by Hibernate Tools 4.3.1



/**
 * Anuncio generated by hbm2java
 */
public class Anuncio  implements java.io.Serializable {


     private Integer id;
     private Anunciante anunciante;
     private String contenido;
     private float precio;

    public Anuncio() {
    }

    public Anuncio(Anunciante anunciante, String contenido, float precio) {
       this.anunciante = anunciante;
       this.contenido = contenido;
       this.precio = precio;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Anunciante getAnunciante() {
        return this.anunciante;
    }
    
    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
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




}


