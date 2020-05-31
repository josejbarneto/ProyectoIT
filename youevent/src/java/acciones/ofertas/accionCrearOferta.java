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

    private Integer id;
    private Evento evento;
    private float descuento;
    private String TInicio;
    private String TFin;
    private Integer idEvento;
    private Map<String, Object> session;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getTInicio() {
        return TInicio;
    }

    public void setTInicio(String TInicio) {
        this.TInicio = TInicio;
    }

    public String getTFin() {
        return TFin;
    }

    public void setTFin(String TFin) {
        this.TFin = TFin;
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
        Oferta oferta = new Oferta(evento, descuento, stringToDate(TInicio), stringToDate(TFin));
        ofertaDAO.crear(oferta);
        return SUCCESS;
    }

    public Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.parse(dateString);
        
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
