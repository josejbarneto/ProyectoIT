/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.ofertas;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import modelo.dao.eventoDAO;
import modelo.dao.ofertaDAO;
import modelo.entidades.Evento;
import modelo.entidades.Oferta;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Fran
 */
public class accionCrearOferta extends ActionSupport implements SessionAware {

    private Evento evento;
    private float descuento;
    private String fechainicio;
    private String fechafin;
    private Integer idEvento;
    private Map<String, Object> session;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
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

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String execute() throws Exception {
        ofertaDAO ofertaDAO = new ofertaDAO();
        eventoDAO eventoDAO = new eventoDAO();
        Evento evento = eventoDAO.get(idEvento);
        Date fechaInicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechainicio);
        Date fechaFinDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechafin);
        Oferta oferta = new Oferta(evento, descuento, fechaInicioDate, fechaFinDate);
        ofertaDAO.crear(oferta);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
