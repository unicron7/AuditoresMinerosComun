/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.beans;

import ec.gob.arcom.auditoresmineros.properties.PropertiesReader;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Will
 */
@Named(value = "idleMonitorView")
@RequestScoped
public class IdleMonitorView implements Serializable {
    private static final String DEFAULT= "600000";
    private String timeout= "";
    
    public IdleMonitorView() {
        timeout= PropertiesReader.leer("timeout");
        if(timeout== null || timeout.length()==0) {
            timeout= DEFAULT;
            System.out.println(DEFAULT);
        }
    }
    
    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
    
    public void onIdle() {
        RequestContext.getCurrentInstance().execute("PF('sessionTimeOutDialog').show();");
    }
}
