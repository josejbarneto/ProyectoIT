/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.anunciante;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.dao.anuncianteDAO;
import modelo.entidades.Anunciante;

/**
 *
 * @author Carlos
 */
public class accionEditarAnunciante extends ActionSupport {
    
    private String nombre;
    private String direccion;
    private String email;
    private int idAnunciante;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(int idAnunciante) {
        this.idAnunciante = idAnunciante;
    }
    
    public accionEditarAnunciante() {
    }
    
    public String execute() throws Exception {
        anuncianteDAO anuncianteDAO = new anuncianteDAO();
        Anunciante anunciante = anuncianteDAO.get(idAnunciante);
        anunciante.setNombre(nombre);
        anunciante.setDireccion(direccion);
        anunciante.setEmail(email);
        anuncianteDAO.editar(anunciante);
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        if (this.nombre.equals("")) {
            addFieldError("nombre", "Introduzca un nombre");
        }
        
        if(!Pattern.matches("^[a-zA-Z ]*$", this.nombre)){
            addFieldError("nombre", "El nombre debe contener caracteres alfabéticos");
        }
        
        if(this.nombre.length() > 20){
            addFieldError("nombre", "El nombre no puede contener más de 20 caracteres");
        }

        if (this.direccion.equals("")) {
            addFieldError("direccion", "Introduzca una direccion");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_, ]*$", this.direccion)){
            addFieldError("direccion", "El usuario debe contener caracteres alfanuméricos");
        }
        
        if(this.direccion.length() > 50){
            addFieldError("direccion", "La direccion no puede contener más de 50 caracteres");
        }
        
        if (this.email.equals("")) {
            addFieldError("email", "Introduzca un correo");
        }
        else{
            Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(this.email);
            if(!matcher.find()){
                addFieldError("email", "Introduzca un correo válido");
            }
        }
        
        if(this.email.length() > 30){
            addFieldError("email", "El correo no puede contener más de 30 caracteres.");
        }
    }
    
}
