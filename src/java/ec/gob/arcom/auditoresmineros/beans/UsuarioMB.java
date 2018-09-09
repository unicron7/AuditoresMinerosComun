/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.beans;

import ec.gob.arcom.auditoresmineros.controllers.UsuarioController;
import ec.gob.arcom.auditoresmineros.persistencia.daos.UsuarioSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Will
 */
@Named(value = "usuarioMB")
@RequestScoped
public class UsuarioMB {
    @EJB
    private UsuarioSBLocal usuarioDao;
    

    /**
     * Creates a new instance of UsuarioMB
     */
    public UsuarioMB() {
    }
    
    public String obtenerNombreTitular(String documento) {
        Usuario usr= UsuarioController.buscarPorDocumento(usuarioDao, documento);
        return usr.getNombre() + " " + usr.getApellido();
    }
}
