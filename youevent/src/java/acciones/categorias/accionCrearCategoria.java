/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Pattern;
import modelo.dao.categoriaDAO;
import modelo.entidades.Categoria;

/**
 *
 * @author eugen
 */
public class accionCrearCategoria extends ActionSupport {
    
    private String nombre;
    private String descripcion;
    
    public accionCrearCategoria() {
    }

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
    
    
    public String execute() throws Exception {
        categoriaDAO cDAO = new categoriaDAO();
        if (!cDAO.existeCategoria(this.nombre)) {
            Categoria cat = new Categoria(this.nombre, this.descripcion);
            cDAO.insertaCategoria(cat);
            return SUCCESS;
        }
        else{
            return ERROR;
        }
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
