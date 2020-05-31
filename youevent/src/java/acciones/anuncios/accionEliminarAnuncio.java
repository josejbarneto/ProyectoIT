/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import acciones.eventos.*;
import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.anuncioDAO;
import modelo.dao.eventoDAO;

/**
 *
 * @author Carlos
 */
public class accionEliminarAnuncio extends ActionSupport {
    
    private Integer idAnuncio;

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    
    public String execute() throws Exception {
        new anuncioDAO().eliminar(idAnuncio);
        return SUCCESS;
    }
    
}
