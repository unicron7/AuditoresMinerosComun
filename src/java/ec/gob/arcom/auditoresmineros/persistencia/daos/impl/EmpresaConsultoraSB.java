/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.EmpresaConsultoraSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.EmpresaConsultoraAuditoria;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Pago;
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
public class EmpresaConsultoraSB implements EmpresaConsultoraSBLocal {
    @PersistenceContext
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void saveECA(EmpresaConsultoraAuditoria empresaConsultoraAuditoria) {
        this.em.persist(empresaConsultoraAuditoria);
    }

    @Override
    public EmpresaConsultoraAuditoria findByRuc(String ruc) {
        try {
            Query query= em.createQuery("Select a from EmpresaConsultoraAuditoria a where a.ruc= :ruc");
            query.setParameter("ruc", ruc);
            return (EmpresaConsultoraAuditoria) query.getSingleResult();
        } catch(Exception ex) {
            return null;
        }
    }
    
    @Override
    public List<EmpresaConsultoraAuditoria> findByRuc(String ruc, String criterio) {
        try {
            Query query= em.createQuery("Select a from EmpresaConsultoraAuditoria a where a.ruc= :ruc");
            query.setParameter("ruc", ruc);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<EmpresaConsultoraAuditoria> listarECA() {
        try {
           Query query = em.createNamedQuery("EmpresaConsultoraAuditoria.listAll");
           return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List<EmpresaConsultoraAuditoria> listarECAActivo() {
        try {
            Query query= em.createQuery("Select a from EmpresaConsultoraAuditoria a where a.activo= :activo");
            query.setParameter("activo", true);
           return query.getResultList();
        } catch(Exception ex) {
           System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public void updateECA(EmpresaConsultoraAuditoria empresaConsultoraAuditoria) {
        this.em.merge(empresaConsultoraAuditoria);
    }

    @Override
    public EmpresaConsultoraAuditoria findById(Long id) {
        return this.em.find(EmpresaConsultoraAuditoria.class, id);
    }
    
    @Override
    public EmpresaConsultoraAuditoria getECAJoinFetchPago(Long id) {
        try {
            Query query= em.createQuery("Select a from EmpresaConsultoraAuditoria a join fetch a.pagos where a.id= :id");
            query.setParameter("id", id);
            return (EmpresaConsultoraAuditoria) query.getSingleResult();
        } catch(Exception ex) {
            System.out.println(ex.toString());
            if(ex instanceof NoResultException) {
                EmpresaConsultoraAuditoria pj= findById(id);
                pj.setPagos(new ArrayList<Pago>());
                return pj;
            }
        }
        return null;
    }
}
