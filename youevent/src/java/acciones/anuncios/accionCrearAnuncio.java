/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import modelo.dao.anuncianteDAO;
import modelo.dao.anuncioDAO;
import modelo.entidades.Anunciante;
import modelo.entidades.Anuncio;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionCrearAnuncio extends ActionSupport implements SessionAware {

    private String contenido;
    private float precio;
    private String anunciante;
    private List<String> anunciantes  = new ArrayList();
    private List<Anunciante> anunciantesLista = new ArrayList();
    private Map<String, Object> session;


    public float getPrecio() {
        return precio;
    }

    public List<Anunciante> getAnunciantesLista() {
        return anunciantesLista;
    }

    public void setAnunciantesLista(List<Anunciante> anunciantesLista) {
        this.anunciantesLista = anunciantesLista;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(String anunciante) {
        this.anunciante = anunciante;
    }

    public List<String> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(List<String> anunciantes) {
        this.anunciantes = anunciantes;
    }

    public accionCrearAnuncio() {
        anuncianteDAO aDAO = new anuncianteDAO();
        this.anunciantesLista = aDAO.getAll();
    }




    @Override
    public String execute() throws Exception {
        int id = Integer.valueOf(anunciantes.get(0));
        Anunciante ains = new anuncianteDAO().getById(anunciantesLista, id);
        Anuncio ins = new Anuncio(ains, contenido, precio);
        new anuncioDAO().crear(ins);
        return SUCCESS;

    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void validate() {
        if(this.contenido.length() == 0){
            addFieldError("contenido", "El contenido no puede estar vacío");
        }
        
        if(this.contenido.length() > 255){
            addFieldError("contenido", "El contenido no puede contener más de 255 caracteres");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_ ]*$", this.contenido)){
            addFieldError("contenido", "El contenido debe contener caracteres alfanuméricos");
        }
        
        if(!Pattern.matches("^([+]?\\d*\\.?\\d*)$", Float.toString(precio))){
            addFieldError("precio", "El precio es incorrecto");
        }
        
        
        
    }

}
