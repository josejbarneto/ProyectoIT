/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import java.util.regex.Pattern;
import modelo.dao.categoriaDAO;
import modelo.entidades.Categoria;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class accionEditarCategoria extends ActionSupport implements SessionAware {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Map<String, Object> session;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public accionEditarCategoria() {
    }

    @Override
    public String execute() throws Exception {

        categoriaDAO catDAO = new categoriaDAO();
        
        Categoria cat = new Categoria(nombre, descripcion);
        cat.setId(id);
        
        catDAO.editar(cat);

        return SUCCESS;

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public void validate() {
        if(this.nombre.length() == 0){
            addFieldError("nombre", "El nombre no puede estar vacío");
        }
        
        if(this.nombre.length() > 20){
            addFieldError("nombre", "El nombre no puede contener más de 20 caracteres");
        }
        
        if(this.descripcion.length() == 0){
            addFieldError("descripcion", "La descripción no puede estar vacía");
        }
        
        if(this.descripcion.length() > 255){
            addFieldError("descripcion", "La descripción no puede contener más de 255 caracteres");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_ ]*$", this.descripcion)){
            addFieldError("descripcion", "La descripción debe contener caracteres alfanuméricos");
        }
        
        if(!Pattern.matches("^[a-zA-Z]*$", this.nombre)){
            addFieldError("descripcion", "El nombre debe contener caracteres alfabéticos");
        }
        
        
    }

}
