/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.categorias;

import com.opensymphony.xwork2.ActionSupport;
import modelo.dao.categoriaDAO;

/**
 *
 * @author Carlos
 */
public class accionEliminarCategoria extends ActionSupport {
    
    private Integer idCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }


    
    public accionEliminarCategoria() {
    }
    
    public String execute() throws Exception {
        categoriaDAO catDAO = new categoriaDAO();
        catDAO.eliminar(idCategoria);
        return SUCCESS;
    }
    
}
