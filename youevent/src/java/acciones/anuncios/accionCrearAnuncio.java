/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.entidades.Anunciante;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionCrearAnuncio extends ActionSupport implements SessionAware {

    private String contenido;
    private float precio;
    private String anunciante;
    private List<String> anunciantes;
    private Map<String, Object> session;


    public float getPrecio() {
        return precio;
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






    public String execute() throws Exception {
        int id = Integer.valueOf(anunciantes.get(0));
        System.out.println("-----------------------------------\n\n\n\n\n\n" + id);
        return SUCCESS;

    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void validate() {

    }

}
