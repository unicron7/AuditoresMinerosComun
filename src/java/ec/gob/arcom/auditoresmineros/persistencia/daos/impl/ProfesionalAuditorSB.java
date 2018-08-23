/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.ProfesionalAuditorSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Pago;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.ProfesionalAuditorExterno;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mejiaw
 */
@Stateless
public class ProfesionalAuditorSB implements ProfesionalAuditorSBLocal {
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void savePAE(ProfesionalAuditorExterno profesionalAuditorExterno) {
         this.em.persist(profesionalAuditorExterno);
    }

    @Override
    public ProfesionalAuditorExterno findByRuc(String ruc) {
        try {
            Query query= em.createQuery("Select a from ProfesionalAuditorExterno a where a.ruc= :ruc");
            query.setParameter("ruc", ruc);
            return (ProfesionalAuditorExterno) query.getSingleResult();
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public List<ProfesionalAuditorExterno> listarPAE() {
        try {
           Query query = em.createNamedQuery("ProfesionalAuditorExterno.listAll");
           return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<ProfesionalAuditorExterno> listarPAEActivo() {
        try {
            Query query= em.createQuery("Select a from ProfesionalAuditorExterno a where a.activo= :activo");
            query.setParameter("activo", true);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public void updatePAE(ProfesionalAuditorExterno profesionalAuditorExterno) {
        this.em.merge(profesionalAuditorExterno);
    }

    @Override
    public ProfesionalAuditorExterno findById(Long id) {
        return this.em.find(ProfesionalAuditorExterno.class, id);
    }
    
    @Override
    public ProfesionalAuditorExterno getPAEJoinFetchPago(Long id) {
        try {
            Query query= em.createQuery("Select a from ProfesionalAuditorExterno a join fetch a.pagos where a.id= :id");
            query.setParameter("id", id);
            return (ProfesionalAuditorExterno) query.getSingleResult();
        } catch(Exception ex) {
            System.out.println(ex.toString());
            if(ex instanceof NoResultException) {
                ProfesionalAuditorExterno pn= findById(id);
                pn.setPagos(new ArrayList<Pago>());
                return pn;
            }
        }
        return null;
    }
    
    @Override
    public List<ProfesionalAuditorExterno> findByRuc(String ruc, String criterio) {
        try {
            Query query= em.createQuery("Select a from ProfesionalAuditorExterno a where a.ruc= :ruc");
            query.setParameter("ruc", ruc);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
