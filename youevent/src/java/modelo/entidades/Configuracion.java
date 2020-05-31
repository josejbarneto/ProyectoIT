package modelo.entidades;
// Generated 31-may-2020 19:26:09 by Hibernate Tools 4.3.1



/**
 * Configuracion generated by hbm2java
 */
public class Configuracion  implements java.io.Serializable {


     private Integer id;
     private Usuario usuario;
     private boolean modoNocturno;
     private boolean openNewTab;
     private int idCategoriaInicial;

    public Configuracion() {
    }

    public Configuracion(Usuario usuario, boolean modoNocturno, boolean openNewTab, int idCategoriaInicial) {
       this.usuario = usuario;
       this.modoNocturno = modoNocturno;
       this.openNewTab = openNewTab;
       this.idCategoriaInicial = idCategoriaInicial;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isModoNocturno() {
        return this.modoNocturno;
    }
    
    public void setModoNocturno(boolean modoNocturno) {
        this.modoNocturno = modoNocturno;
    }
    public boolean isOpenNewTab() {
        return this.openNewTab;
    }
    
    public void setOpenNewTab(boolean openNewTab) {
        this.openNewTab = openNewTab;
    }
    public int getIdCategoriaInicial() {
        return this.idCategoriaInicial;
    }
    
    public void setIdCategoriaInicial(int idCategoriaInicial) {
        this.idCategoriaInicial = idCategoriaInicial;
    }




}


