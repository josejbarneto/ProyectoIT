/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.anuncioDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Anuncio;

/**
 *
 * @author Carlos
 */
public class redirigirAListarAnuncio extends ActionSupport {
    
    private List<Anuncio> listaAnuncios;

    public List<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }


    
    public redirigirAListarAnuncio() {
    }
    
    public String execute() throws Exception {
        listaAnuncios = new anuncioDAO().getAll();
        return SUCCESS;
    }
    
}
