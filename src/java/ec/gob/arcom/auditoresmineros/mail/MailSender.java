/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.mail;

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
 * @author mejiaw
 */
public class MailSender {
    
    private Properties getProperties(FromTo datos) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", datos.getHost());
        props.put("mail.smtp.port", datos.getPort());
        return props;
    }
    
    private Session getSession(final FromTo datos) {
        Session session = Session.getInstance(getProperties(datos),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(datos.getUserName(), datos.getPassword());
                    }
                });
        return session;
    }
    
    public String getCuentaCreadaMsg(String usr, String pwd) {
        String textHTML= "<h1>SU CUENTA HA SIDO CREADA EXITOSAMENTE</h1>"
                    + "<p>Puede ingresar al sistema con los siguientes datos:</p>"
                    + "<p><strong>Usuario:</strong> <em>"+usr+"</em><br/>"
                    + "<strong>Clave:</strong> <em>"+pwd+"</em></p>"
                + "<p style=\"text-align: justify;\"><strong>Recuerde:</strong> "
                + "enviar toda la documentaci&oacute;n en sobre cerrado dirigido "
                + "al Coordinador General de Regulaci&oacute;n y Control Minero, "
                + "como asunto indique \"Registro e inscripci&oacute;n de Auditor "
                + "T&eacute;cnico Minero\", puede acercarse a la Reginal de ARCOM "
                + "m&aacute;s cercana a Usted para entregar su documentaci&oacute;n.</p>";      
        return textHTML;
    }
    
    public String getPasswordResetMsg(String usr, String ruc, String pwd) {
        String textHTML= "<h2>Estimad@ " +usr+ ", su clave ha sido restablecida</h2>"
                    + "<p>Puede ingresar al sistema con los siguientes datos:</p>"
                    + "<p><strong>Usuario: </strong> <em>"+ruc+"</em><br/>"
                    + "<strong>Clave: </strong> <em>"+pwd+"</em></p>";      
        return textHTML;
    }
    
    public String getInscripcionMsg(String userName) {
        String textHTML= "<h1 style=\"text-align: center;\">INFORMACI&Oacute;N AUDITORES T&Eacute;CNICOS MINEROS</h1>\n"
                + "<p style=\"text-align: justify;\">Estimad@ " + userName + ", <strong>ha sido actualizado su estado</strong>, "
                + "puede consultarlo ingresando a <a href=\"http://www.controlminero.gob.ec:8080/registroaudtecmin\">www.controlminero.gob.ec</a></p>";
        return textHTML;
    }
    
    public String getCalificacionMsg(String userName) {
        String textHTML= "<h1 style=\"text-align: center;\">INFORMACI&Oacute;N AUDITORES T&Eacute;CNICOS MINEROS</h1>\n"
                + "<p style=\"text-align: justify;\">Estimad@ " + userName + ", <strong>ha sido actualizado su estado</strong>, "
                + "puede consultarlo ingresando a <a href=\"http://www.controlminero.gob.ec:8080/registroaudtecmin\">www.controlminero.gob.ec</a></p>";
        return textHTML;
    }
    
    public String getResolucionMsg(String userName) {
        String textHTML= "<h1 style=\"text-align: center;\">INFORMACI&Oacute;N AUDITORES T&Eacute;CNICOS MINEROS</h1>\n" 
                + "<p style=\"text-align: justify;\">Estimad@ " + userName + ", <strong>ha sido cargada la resoluci&oacute;n de "
                + "calificaci&oacute;n como Auditor T&eacute;cnico Minero</strong>, puede acercarse a retirar la misma "
                + "en la Coordinaci&oacute;n Regional de ARCOM mas cercana, con la finalidad de que proceda a la "
                + "inscripci&oacute;n en el registro minero.</p>";
        return textHTML;
    }
    
    
    
    public void sendMailHTML(FromTo datos) {
        try {
            Message message = new MimeMessage(getSession(datos));
            message.setFrom(new InternetAddress(datos.getFrom()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(datos.getTo()));
            message.setSubject(datos.getSubject());
            message.setContent(datos.getMsg(), "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
}