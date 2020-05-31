/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anuncios;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.dao.anuncianteDAO;
import modelo.entidades.Anunciante;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Carlos
 */
public class redirigirACrearAnuncio extends ActionSupport implements SessionAware{

    private Map<String, Object> session;
    private List<Anunciante> anunciantes;

    public List<Anunciante> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(List<Anunciante> anunciantes) {
        this.anunciantes = anunciantes;
    }
    

    public redirigirACrearAnuncio() {
    }

    public String execute() throws Exception {
        anuncianteDAO anDAO = new anuncianteDAO();
        this.anunciantes = anDAO.getAll();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

}
