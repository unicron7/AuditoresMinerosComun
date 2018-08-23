/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.converters;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.LocalidadSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Localidad;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Will
 */
@Named(value = "localidadConverter")
@RequestScoped
public class LocalidadConverter implements Serializable, Converter {
    @EJB
    private LocalidadSBLocal localidadSB;
    

    /**
     * Creates a new instance of Test
     */
    public LocalidadConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null) {
            try {
                return localidadSB.find(Long.parseLong(value));
            } catch(Exception ex) {
                System.out.println("Ocurrio un error al convertir Localidad a Objeto");
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            return String.valueOf(((Localidad) value).getId());
        }
        return null;
    }
    
}
