/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.dao.ofertaDAO;
import modelo.entidades.Oferta;

/**
 *
 * @author Fran
 */
public class redirigirAListarOferta extends ActionSupport {
    
    private List<Oferta> listaOfertas;

    public List<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(List<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }
    
    public redirigirAListarOferta() {
    }
    
    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        listaOfertas = ofertaDAO.getOfertas();
        return SUCCESS;
    }
    
}
