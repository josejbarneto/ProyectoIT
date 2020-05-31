/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.ofertaDAO;
import modelo.entidades.Oferta;

/**
 *
 * @author Fran
 */
public class redirigirAMostrarOferta extends ActionSupport {

    private int idOferta;
    private Oferta oferta;
    private String fechainicio;
    private String fechafin;

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

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

    public redirigirAMostrarOferta() {
    }

    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        oferta = ofertaDAO.get(idOferta);
        return SUCCESS;
    }

}
