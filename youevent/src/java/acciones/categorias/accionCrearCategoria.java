/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import com.opensymphony.xwork2.ActionSupport;

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
        return null;
    }
    
}
