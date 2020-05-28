/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
        claveTemporalDAO ctDAO = new claveTemporalDAO();
        Usuario usuario = usuarioDAO.comprobarCorreo(this.correo);
        
        
        if (usuario != null) {
            
            String nuevaPass = generateRandomString(12);
            ctDAO.insertaClaveTemporal(usuario, nuevaPass);
            
            /*Envio de correo con javamail*/
            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");          //HOST
            propiedad.setProperty("mail.smtp.starttls.enable", "true");         //TLS
            propiedad.setProperty("mail.smtp.port", "465");                     //PUERTO / Secure (TLS) = 587
            propiedad.setProperty("mail.smtp.auth", "true");                    //METODO DE AUTENTICACION
            propiedad.put("mail.smtp.socketFactory.port", "465");
            propiedad.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            propiedad.put("mail.smtp.socketFactory.fallback", "false");

            String correoDeEnvio = "youeventupo@gmail.com";
            String pass = "youevent1";
            
            String destinatario = usuario.getEmail();
            String asunto = "Recuperación de contraseña - YouEvent";
            

            String mensaje = "Su nueva contraseña es: " + nuevaPass;
            
            
            Session sesion = Session.getInstance(propiedad,
            new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(correoDeEnvio, pass);
              }
            });

            
            try{
                Message message = new MimeMessage(sesion);
                message.setFrom(new InternetAddress(correoDeEnvio));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
                
                message.setSubject(asunto);
                message.setText(mensaje);
                Transport.send(message);
                
            }catch(MessagingException ex){
                System.out.println("ERROR AL ENVIAR");
                return ERROR;
            }
            
            return SUCCESS;
        } else {
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
}
