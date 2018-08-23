/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.ConcesionMineraSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.ConcesionMinera;
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
public class ConcesionMineraSB implements ConcesionMineraSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List listConcesionMinera() {
        try {
            Query query= em.createQuery("Select cm from ConcesionMinera cm where cm.estado_registro= :estado");
            query.setParameter("estado", true);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public List listConcesionMinera(String cr) {
        try {
            Query query= em.createQuery("Select cm from ConcesionMinera cm where cm.estado_registro= :estado and cm.documento_concesionario_principal= :cr");
            query.setParameter("estado", true);
            query.setParameter("cr", cr);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public ConcesionMinera findById(Long id) {
        return em.find(ConcesionMinera.class, id);
    }

    @Override
    public List<ConcesionMinera> listConcesionMinera(String cr, Long tipo1, Long tipo2, Long tipo3) {
        try {
            Query query= em.createQuery("Select cm from ConcesionMinera cm where cm.estado_registro= :estadoreg and cm.documento_concesionario_principal=:cr and cm.estado_concesion= :estadocm and"
                    + "(cm.tipoMineria.codigo_tipo_mineria=:tipo1 or cm.tipoMineria.codigo_tipo_mineria=:tipo2 or cm.tipoMineria.codigo_tipo_mineria=:tipo3)");
            query.setParameter("estadoreg", true);
            query.setParameter("estadocm", (long) 243);
            query.setParameter("cr", cr);
            query.setParameter("tipo1", tipo1);
            query.setParameter("tipo2", tipo2);
            query.setParameter("tipo3", tipo3);
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
