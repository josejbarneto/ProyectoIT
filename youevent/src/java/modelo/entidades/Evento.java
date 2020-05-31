package modelo.entidades;
// Generated 31-may-2020 19:26:09 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Evento generated by hbm2java
 */
public class Evento  implements java.io.Serializable {


     private Integer id;
     private int idUsuario;
     private String nombre;
     private String descripcion;
     private String lugar;
     private int aforo;
     private float precio;
     private Date fecha;
     private Set ofertas = new HashSet(0);
     private Set eventoCategorias = new HashSet(0);
     private Set entradas = new HashSet(0);

    public Evento() {
    }

	
    public Evento(int idUsuario, String nombre, String descripcion, String lugar, int aforo, float precio, Date fecha) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.aforo = aforo;
        this.precio = precio;
        this.fecha = fecha;
    }
    public Evento(int idUsuario, String nombre, String descripcion, String lugar, int aforo, float precio, Date fecha, Set ofertas, Set eventoCategorias, Set entradas) {
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.lugar = lugar;
       this.aforo = aforo;
       this.precio = precio;
       this.fecha = fecha;
       this.ofertas = ofertas;
       this.eventoCategorias = eventoCategorias;
       this.entradas = entradas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    public String getLugar() {
        return this.lugar;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public int getAforo() {
        return this.aforo;
    }
    
    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(Set ofertas) {
        this.ofertas = ofertas;
    }
    public Set getEventoCategorias() {
        return this.eventoCategorias;
    }
    
    public void setEventoCategorias(Set eventoCategorias) {
        this.eventoCategorias = eventoCategorias;
    }
    public Set getEntradas() {
        return this.entradas;
    }
    
    public void setEntradas(Set entradas) {
        this.entradas = entradas;
    }




}


