/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.AuditoriaSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Auditoria;
import java.util.ArrayList;
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
public class AuditoriaSB implements AuditoriaSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Auditoria> listAuditoria() {
        try {
            Query query= em.createQuery("Select aud from Auditoria aud where aud.activo= :activo");
            query.setParameter("activo", true);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return new ArrayList();
    }
    
    @Override
    public void save(Auditoria ca) {
        em.persist(ca);
    }
    
    @Override
    public void update(Auditoria auditoria) {
        em.merge(auditoria);
    }

    @Override
    public List<Auditoria> listAuditoria(String cr) {
        try {
            Query query= em.createQuery("Select aud from Auditoria aud where aud.activo= :activo and aud.documentoTitular= :cr");
            query.setParameter("activo", true);
            query.setParameter("cr", cr);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return new ArrayList();
    }
    
    @Override
    public List<Auditoria> listAuditoria(String cr, Catalogo estado) {
        try {
            Query query= em.createQuery("Select aud from Auditoria aud where aud.activo= :activo and aud.documentoTitular= :cr and aud.estadoAuditoria= :estado order by aud.fechaDeAsignacion ASC");
            query.setParameter("activo", true);
            query.setParameter("cr", cr);
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return new ArrayList();
    }
    @Override
    public List<Auditoria> listAuditoriaByAuditor(Long id) {
        try {
            Query query= em.createQuery("Select aud from Auditoria aud where aud.activo= :activo and aud.auditor.id= :id");
            query.setParameter("activo", true);
            query.setParameter("id", id);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return new ArrayList();
    }

    @Override
    public List<Auditoria> listAuditoriaByAuditor(Long id, Catalogo estado) {
        try {
            Query query= em.createQuery("Select aud from Auditoria aud where aud.activo= :activo and aud.auditor.id= :id and aud.estadoAuditoria= :estado order by aud.horaDeAsignacion ASC");
            query.setParameter("activo", true);
            query.setParameter("id", id);
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return new ArrayList();
    }

    @Override
    public Long countByAuditor(Long id, Catalogo estado) {
        try {
            Query query= em.createQuery("Select count(aud) from Auditoria aud where aud.activo= :activo and aud.auditor.id= :id and aud.estadoAuditoria= :estado");
            query.setParameter("activo", true);
            query.setParameter("id", id);
            query.setParameter("estado", estado);
            return (Long) query.getSingleResult();
        } catch(Exception ex) {
            System.out.println("Error al contar las auditorias por auditor " + ex.toString());
        }
        return null;
    }
}
