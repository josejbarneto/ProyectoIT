/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import com.opensymphony.xwork2.ActionSupport;
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

    }
    
}
