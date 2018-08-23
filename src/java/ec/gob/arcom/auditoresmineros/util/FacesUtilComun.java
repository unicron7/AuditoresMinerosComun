/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.util;

import ec.gob.arcom.auditoresmineros.beans.CatalogMB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Will
 */
public class FacesUtilComun {
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }
    
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("username").toString();
    }
    
    public static boolean isLogged() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  Boolean.parseBoolean(session.getAttribute("logged").toString());
    }
    
    public static boolean isAdmin() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  Boolean.parseBoolean(session.getAttribute("admin").toString());
    }
    
    public static String getRgl() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("regional").toString();
    }
    
    public static void showInfoMessage(String msg, String msg2) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg2));
    }
    
    public static void showErrorMessage(String msg, String msg2) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg2));
    }
    
    public static void updateComponent(String componente) {
        RequestContext.getCurrentInstance().update(componente);
    }
    
    public static CatalogMB getCatalogMB() {
        return (CatalogMB) FacesUtilComun.getSession().getAttribute("catalogMB");
    }
}
