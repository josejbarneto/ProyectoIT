/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.anuncianteDAO;

/**
 *
 * @author Carlos
 */
public class accionEliminarAnunciante extends ActionSupport {
    
    private int idAnunciante;

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }
    
    public accionEliminarAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        anuncianteDAO.eliminar(idAnunciante);
        return SUCCESS;
    }
    
}
