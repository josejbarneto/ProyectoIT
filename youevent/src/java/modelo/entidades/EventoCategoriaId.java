package modelo.entidades;
// Generated 31-may-2020 13:38:34 by Hibernate Tools 4.3.1



/**
 * EventoCategoriaId generated by hbm2java
 */
public class EventoCategoriaId  implements java.io.Serializable {


     private int idEvento;
     private int idCategoria;

    public EventoCategoriaId() {
    }

    public EventoCategoriaId(int idEvento, int idCategoria) {
       this.idEvento = idEvento;
       this.idCategoria = idCategoria;
    }
   
    public int getIdEvento() {
        return this.idEvento;
    }
    
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public int getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EventoCategoriaId) ) return false;
		 EventoCategoriaId castOther = ( EventoCategoriaId ) other; 
         
		 return (this.getIdEvento()==castOther.getIdEvento())
 && (this.getIdCategoria()==castOther.getIdCategoria());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdEvento();
         result = 37 * result + this.getIdCategoria();
         return result;
   }   


}


