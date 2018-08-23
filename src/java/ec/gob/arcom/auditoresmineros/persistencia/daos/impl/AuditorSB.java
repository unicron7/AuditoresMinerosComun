/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.AuditorSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Auditor;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.TipoAuditor;
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
public class AuditorSB implements AuditorSBLocal {
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Auditor findByRuc(String ruc) {
        try {
            Query query= em.createQuery("Select a from Auditor a where a.ruc= :ruc");
            query.setParameter("ruc", ruc);
            return (Auditor) query.getSingleResult();
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public List<Auditor> listAuditores() {
        try {
            Query query= em.createQuery("Select a from Auditor a");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<Auditor> listAuditoresActivos() {
        try {
            Query query= em.createQuery("Select a from Auditor a where a.activo= :activo");
            query.setParameter("activo", true);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<Auditor> listAuditoresActivosByEstado(long estado) {
        try {
            Query query= em.createQuery("Select a from Auditor a where a.activo= :activo and a.estado= :estado");
            query.setParameter("activo", true);
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public List<Auditor> listAuditores(long estado) {
        try {
            Query query= em.createQuery("Select a from Auditor a where a.estado= :estado");
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<Auditor> listAuditores(long estado, Long tipo) {
        try {
            Query query= em.createQuery("Select a from Auditor a where a.estado= :estado order by a.razonSocial");
            query.setParameter("estado", estado);
            return filtrarPorTipo(query.getResultList(), tipo);
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public Auditor findById(Long id) {
        return em.find(Auditor.class, id);
    }

    @Override
    public void update(Auditor auditor) {
        em.merge(auditor);
    }
    
    @Override
    public void delete(Auditor auditor) {
        auditor.setActivo(false);
        em.merge(auditor);
    }
    
    private List<Auditor> filtrarPorTipo(List<Auditor> auditores, Long tipo) {
        List<Auditor> filtrados= new ArrayList<Auditor>();
        if(auditores!=null && auditores.size()>0) {
            for (Auditor auditor : auditores) {
                for (Catalogo cat : auditor.getTiposAuditor()) {
                    if(cat.getId().compareTo(tipo)==0) {
                        filtrados.add(auditor);
                    }
                }
            }
        }
        return filtrados;
    }
}
