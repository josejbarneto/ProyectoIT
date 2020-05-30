/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import modelo.dao.anuncianteDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.entidades.Anunciante;

/**
 *
 * @author Carlos
 */
public class redirigirAListarAnunciante extends ActionSupport {
    
    private List<Anunciante> listaAnunciantes;

    public List<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(List<Anunciante> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }
    
    public redirigirAListarAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        listaAnunciantes = anuncianteDAO.getAll();
        return SUCCESS;
    }
    
}
