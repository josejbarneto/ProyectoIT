package modelo.entidades;
// Generated 28-may-2020 22:53:01 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String descripcion;
     private Set eventoCategorias = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Categoria(String nombre, String descripcion, Set eventoCategorias) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.eventoCategorias = eventoCategorias;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getEventoCategorias() {
        return this.eventoCategorias;
    }
    
    public void setEventoCategorias(Set eventoCategorias) {
        this.eventoCategorias = eventoCategorias;
    }




}


