/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import acciones.eventos.*;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.dao.anuncianteDAO;
import modelo.dao.anuncioDAO;
import modelo.dao.categoriaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Anunciante;
import modelo.entidades.Anuncio;
import modelo.entidades.Categoria;
import modelo.entidades.Evento;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirAEditarAnuncio extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private Anuncio anuncio;
    private int idAnuncio;
    private List<Anunciante> anunciantesLista;

    public List<Anunciante> getAnunciantesLista() {
        return anunciantesLista;
    }

    public void setAnunciantesLista(List<Anunciante> anunciantesLista) {
        this.anunciantesLista = anunciantesLista;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }


    
    public String execute() throws Exception {
        anunciantesLista = new anuncianteDAO().getAll();
        anuncio = new anuncioDAO().get(idAnuncio); 
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
