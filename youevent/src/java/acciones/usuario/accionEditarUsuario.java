/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.dao.usuarioDAO;
import modelo.entidades.Usuario;

/**
 *
 * @author Carlos
 */
public class accionEditarUsuario extends ActionSupport {

    private int id;
    private String us;
    private int rol;
    private String nombre;
    private String contrasenya;
    private String email;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    

    public accionEditarUsuario() {
        usuario = new usuarioDAO().get(id);
    }

    public String execute() throws Exception {
        
        Usuario edit = new Usuario(us, rol, nombre, email, contrasenya);
        edit.setId(id);
        new usuarioDAO().editar(edit);

        return SUCCESS;

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

        if (this.us.equals("")) {
            addFieldError("usuario", "Introduzca un usuario");
        }
        
        if(!Pattern.matches("^[a-zA-Z0-9_]*$", this.us)){
            addFieldError("usuario", "El usuario debe contener caracteres alfanuméricos");
        }
        
        if(this.us.length() > 30){
            addFieldError("usuario", "El usuario no puede contener más de 30 caracteres");
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
