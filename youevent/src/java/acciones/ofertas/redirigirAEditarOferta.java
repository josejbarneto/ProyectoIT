/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.ofertaDAO;
import modelo.entidades.Oferta;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Fran
 */
public class redirigirAEditarOferta extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private int idOferta;
    private Oferta oferta;

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
    
    public redirigirAEditarOferta() {
    }
    
    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        oferta = ofertaDAO.get(idOferta);
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
}
