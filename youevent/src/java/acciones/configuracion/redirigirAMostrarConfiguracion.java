/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.configuracion;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import modelo.dao.categoriaDAO;
import modelo.dao.configuracionDAO;
import modelo.entidades.Categoria;
import modelo.entidades.Configuracion;
import modelo.entidades.Usuario;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirAMostrarConfiguracion extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    private Configuracion configuracion;
    private Categoria categoria;

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    public redirigirAMostrarConfiguracion() {
        
    }
    
    public String execute() throws Exception {
        Usuario usuario = (Usuario) session.get("usuario");
        configuracionDAO configuracionDAO = new configuracionDAO();
        configuracion = configuracionDAO.get(usuario.getId());
        categoriaDAO categoriaDAO = new categoriaDAO();
        categoria = categoriaDAO.get(configuracion.getIdCategoriaInicial());
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
