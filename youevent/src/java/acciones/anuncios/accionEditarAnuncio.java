/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
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
public class accionEditarAnuncio extends ActionSupport implements SessionAware {

    private Integer id;
    private String contenido;
    private float precio;
    private List<String> anunciantes;
    private List<Anunciante> anunciantesLista;
    private Map<String, Object> session;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<String> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(List<String> anunciantes) {
        this.anunciantes = anunciantes;
    }

    public List<Anunciante> getAnunciantesLista() {
        return anunciantesLista;
    }

    public void setAnunciantesLista(List<Anunciante> anunciantesLista) {
        this.anunciantesLista = anunciantesLista;
    }


    

    public accionEditarAnuncio() {
        anuncianteDAO aDAO = new anuncianteDAO();
        this.anunciantesLista = aDAO.getAll();
        
    }

    public String execute() throws Exception {
        int ida = Integer.valueOf(anunciantes.get(0));
        Anunciante ains = new anuncianteDAO().getById(anunciantesLista, ida);
        Anuncio edit = new Anuncio(ains, contenido, precio);
        edit.setId(id);
        new anuncioDAO().editar(edit);

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
