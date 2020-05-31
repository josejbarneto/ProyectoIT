/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.dao.eventoDAO;
import modelo.dao.ofertaDAO;
import modelo.entidades.Evento;
import modelo.entidades.Oferta;

/**
 *
 * @author Fran
 */
public class accionEditarOferta extends ActionSupport {
    
    private float descuento;
    private String fechainicio;
    private String fechafin;
    private int idOferta;
    private Oferta oferta;

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

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
    
    public accionEditarOferta() {
    }
    
    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        eventoDAO eventoDAO = new eventoDAO();
        Oferta o = ofertaDAO.get(idOferta);
        Evento evento = eventoDAO.get(o.getEvento().getId());
        Date fechaInicioDate =new SimpleDateFormat("dd/MM/yyyy").parse(fechainicio);
        Date fechaFinDate =new SimpleDateFormat("dd/MM/yyyy").parse(fechafin);
        Oferta oferta = new Oferta(evento, descuento, fechaInicioDate, fechaFinDate);
        oferta.setId(idOferta);
        ofertaDAO.editar(oferta);
        return SUCCESS;
    }
    
}
