/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.dao.configuracionDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Configuracion;
import modelo.entidades.Usuario;
import org.mindrot.jbcrypt.BCrypt;



/**
 *
 * @author Carlos
 */
public class accionRegistrar extends ActionSupport {

    private String nombre;
    private String usuario;
    private String password;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public accionRegistrar() {
    }

    @Override
    public String execute() throws Exception {
        usuarioDAO usuarioDAO = new usuarioDAO();
        configuracionDAO configuracionDAO = new configuracionDAO();
        Usuario us = new Usuario(usuario, 2, nombre, email, hashPassword(password));
        System.out.println(usuario+ nombre+email+password);

        Configuracion conf = new Configuracion();

        if (usuarioDAO.existeUsuario(us.getUsuario())) {
            return ERROR;
        } else {
            
            us.setId(usuarioDAO.insertUsuario(us));
            conf.setUsuario(us);
            configuracionDAO.insertConfiguracion(conf);
            
            return SUCCESS;
        }
    }
    
    
    public String hashPassword(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt(10));
    }
    
    @Override
    public void validate() {
        if (this.nombre.equals("")) {
            addFieldError("nombre", "Introduzca un nombre");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_ ]*$", this.nombre)){
            addFieldError("nombre", "El nombre debe contener caracteres alfanuméricos");
        }
        
        if(this.nombre.length() > 20){
            addFieldError("nombre", "El nombre no puede contener más de 20 caracteres");
        }

        if (this.usuario.equals("")) {
            addFieldError("usuario", "Introduzca un usuario");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_]*$", this.usuario)){
            addFieldError("usuario", "El usuario debe contener caracteres alfanuméricos");
        }
        
        if(this.usuario.length() > 30){
            addFieldError("usuario", "El usuario no puede contener más de 30 caracteres");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_]*$", this.password)){
            addFieldError("password", "La contraseña debe contener caracteres alfanuméricos");
        }
        
        if(this.password.length() > 30 || this.password.length() < 6){
            addFieldError("password", "La contraseña debe de ser entre 6 y 30 caracteres");
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
