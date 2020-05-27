package modelo.entidades;
// Generated 27-may-2020 21:22:55 by Hibernate Tools 4.3.1



/**
 * Entrada generated by hbm2java
 */
public class Entrada  implements java.io.Serializable {


     private int id;
     private Evento evento;
     private Usuario usuario;
     private float precio;

    public Entrada() {
    }

    public Entrada(int id, Evento evento, Usuario usuario, float precio) {
       this.id = id;
       this.evento = evento;
       this.usuario = usuario;
       this.precio = precio;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }




}


