/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mejiaw
 */
public class FromTo {
    private String userName;
    private String password;
    private String from;
    private String host;
    private String port;
    private String to;
    private String subject;
    private String msg;
    
    public FromTo() {
        Properties propertiesFile= new Properties();
        try {
            propertiesFile.load(new FileInputStream(System.getProperty("jboss.server.config.dir")+"/sram/config.properties"));
            userName= propertiesFile.getProperty("emusername");
            password= propertiesFile.getProperty("empassword");
            from= propertiesFile.getProperty("emfrom");
            host= propertiesFile.getProperty("emsmtphost");
            port= propertiesFile.getProperty("emsmtpport");
        } catch (IOException ex) {
            Logger.getLogger(FromTo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
