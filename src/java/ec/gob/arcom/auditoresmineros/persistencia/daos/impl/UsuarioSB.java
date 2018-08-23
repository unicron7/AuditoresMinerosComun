/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.UsuarioSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mejiaw
 */
@Stateless
public class UsuarioSB implements UsuarioSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Usuario findByLogin(String login) {
        try {
            Query query= em.createQuery("Select usr from Usuario usr where usr.login= :login");
            query.setParameter("login", login);
            return (Usuario) query.getSingleResult();
        } catch(Exception ex) {
            return null;
        }
    }
    
}
