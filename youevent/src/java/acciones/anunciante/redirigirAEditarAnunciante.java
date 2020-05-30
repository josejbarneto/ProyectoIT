/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.anuncianteDAO;
import modelo.entidades.Anunciante;

/**
 *
 * @author Carlos
 */
public class redirigirAEditarAnunciante extends ActionSupport {
    
    private Anunciante anunciante;
    private int idAnunciante;

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }
    
    public redirigirAEditarAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        anunciante = anuncianteDAO.get(idAnunciante);
        return SUCCESS;
    }
    
}
