/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.entradas;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.dao.entradaDAO;
import modelo.dao.eventoDAO;
import modelo.entidades.Entrada;
import modelo.entidades.Usuario;

/**
 *
 * @author Carlos
 */
public class redirigirAListarEntradaPorCliente extends ActionSupport {
    
    private List<Entrada> listaEntradas;
    private Map<String, Object> session;

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }
       
    public redirigirAListarEntradaPorCliente() {
    }
    
    public String execute() throws Exception {
        entradaDAO entradaDAO = new entradaDAO();
        Usuario usuario = (Usuario) session.get("usuario");
        listaEntradas = entradaDAO.getEntradasUsuario(usuario);
        return SUCCESS;
    }
    
}