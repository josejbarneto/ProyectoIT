/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaMail;

import static com.opensymphony.xwork2.Action.ERROR;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author eugen
 */
public class Mail {

    public boolean sendMail(String asunto, String mensaje, String destinatario) {
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

        Session sesion = Session.getInstance(propiedad,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoDeEnvio, pass);
            }
        });

        try {
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(correoDeEnvio));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));

            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);

        } catch (MessagingException ex) {
            return false;
        }

        return true;
    }
}
