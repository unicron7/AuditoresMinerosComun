/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos.impl;

import ec.gob.arcom.auditoresmineros.persistencia.daos.FuncionarioSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Funcionario;
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
public class FuncionarioSB implements FuncionarioSBLocal {
    @PersistenceContext
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void save(Funcionario funcionario) {
        em.persist(funcionario);
    }

    @Override
    public void update(Funcionario funcionario) {
        em.merge(funcionario);
    }

    @Override
    public void delete(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> list() {
        try {
            Query query= em.createQuery("Select f from Funcionario f order by f.id");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
    @Override
    public Funcionario findByUserName(String userName) {
        try {
            Query query= em.createQuery("Select f from Funcionario f where f.userName= :userName");
            query.setParameter("userName", userName);
            return (Funcionario) query.getSingleResult();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    @Override
    public List<Funcionario> findByApellido(String apellido) {
        try {
            Query query= em.createQuery("Select f from Funcionario f where lower(f.apellido) like lower(:apellido)");
            query.setParameter("apellido", "%" + apellido + "%");
            return query.getResultList();
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
    
}
