/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.anuncianteDAO;
import modelo.dao.anuncioDAO;
import modelo.entidades.Anunciante;
import modelo.entidades.Anuncio;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarAnuncio extends ActionSupport {
    
    private Integer idAnuncio;
    private Anuncio anuncio;
    private Anunciante anunciante;

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }


    public redirigirAMostrarAnuncio() {
        
    }
    
    public String execute() throws Exception {
        anuncio = new anuncioDAO().get(idAnuncio); 
        anunciante = anuncio.getAnunciante();
        return SUCCESS;
    }
    
}
