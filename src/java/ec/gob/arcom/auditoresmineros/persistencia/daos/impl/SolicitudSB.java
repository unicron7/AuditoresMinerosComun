/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.SolicitudSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Solicitud;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mejiaw
 */
@Stateless
public class SolicitudSB implements SolicitudSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(Object obj) {
        em.persist(obj);
    }

    @Override
    public Object read(Long pk) {
        return em.find(Solicitud.class, pk);
    }

    @Override
    public void update(Object obj) {
        em.merge(obj);
    }

    @Override
    public void delete(Object obj) {
        em.merge(obj);
    }

    @Override
    public List list() {
        try {
            Query query= em.createQuery("Select s from Solicitud s where s.activo= :activo");
            query.setParameter("activo", true);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public List list(String documento) {
        try {
            Query query= em.createQuery("Select s from Solicitud s where s.activo= :activo and s.documentoTitular= :documento order by s.fechaSolicitud DESC");
            query.setParameter("activo", true);
            query.setParameter("documento", documento);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
}
