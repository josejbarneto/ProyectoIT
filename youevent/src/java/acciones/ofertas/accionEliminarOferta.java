/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.ofertaDAO;

/**
 *
 * @author Fran
 */
public class accionEliminarOferta extends ActionSupport {
    
    private int idOferta;

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public accionEliminarOferta() {
    }

    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        ofertaDAO.eliminar(idOferta);
        return SUCCESS;
    }
    
}
