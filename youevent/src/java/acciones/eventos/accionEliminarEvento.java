/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.eventos;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.eventoDAO;

/**
 *
 * @author Carlos
 */
public class accionEliminarEvento extends ActionSupport {
    
    private Integer idEvento;

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    
    public accionEliminarEvento() {
    }
    
    public String execute() throws Exception {
        eventoDAO eventoDAO = new eventoDAO();
        eventoDAO.eliminar(idEvento);
        return SUCCESS;
    }
    
}
