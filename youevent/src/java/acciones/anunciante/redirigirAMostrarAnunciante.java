/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.anuncianteDAO;
import modelo.dao.anuncioDAO;
import modelo.entidades.Anunciante;
import modelo.entidades.Anuncio;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarAnunciante extends ActionSupport {
    
    private Anunciante anunciante;
    private List<Anuncio> listaAnuncios;
    private int idAnunciante;

    public Anunciante getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Anunciante anunciante) {
        this.anunciante = anunciante;
    }

    public List<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }
    
    public redirigirAMostrarAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        anunciante = anuncianteDAO.get(idAnunciante);
        anuncioDAO anuncioDAO = new anuncioDAO();
        listaAnuncios = anuncioDAO.getByIdAnunciante(idAnunciante);
        return SUCCESS;
    }
    
}
