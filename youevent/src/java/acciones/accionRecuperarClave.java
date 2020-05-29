/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaMail.Mail;
import modelo.dao.claveTemporalDAO;
import modelo.dao.usuarioDAO;
import modelo.entidades.Usuario;

/**
 *
 * @author eugen
 */
public class accionRecuperarClave extends ActionSupport {
    
    private String correo;
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public accionRecuperarClave() {
    }
    
    public String execute() throws Exception {
        usuarioDAO usuarioDAO = new usuarioDAO();
        Usuario usuario = usuarioDAO.comprobarCorreo(this.correo);
        
        
        if (usuario != null) {
            claveTemporalDAO ctDAO = new claveTemporalDAO();
            String nuevaPass = generateRandomString(12);
            ctDAO.insertaClaveTemporal(usuario, nuevaPass);
            
            String destinatario = usuario.getEmail();
            String asunto = "Recuperación de contraseña - YouEvent";
            String mensaje = "Su nueva contraseña es: " + nuevaPass;
            
            Mail envia = new Mail();
            
            if(!envia.sendMail(asunto, mensaje, destinatario)){
                addFieldError("correo", "El correo no se ha podido enviar");
                return ERROR;
            }
            
            return SUCCESS;
        } else {
            addFieldError("correo", "El correo solicitado no existe");
            return ERROR;
        }
    }
    
    public String generateRandomString(int count){
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        
        return builder.toString();
    }
    
    @Override
    public void validate(){
        if (this.correo.equals("")) {
            addFieldError("correo", "Introduzca un correo");
        }
        else{
            Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(this.correo);
            if(!matcher.find()){
                addFieldError("correo", "Introduzca un correo válido");
            }
        }
        
        if(this.correo.length() > 30){
            addFieldError("correo", "El correo no puede contener más de 30 caracteres.");
        }
    
    }
}
