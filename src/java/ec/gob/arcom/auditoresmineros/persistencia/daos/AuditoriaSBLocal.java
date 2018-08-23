/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Auditoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface AuditoriaSBLocal {

    List<Auditoria> listAuditoria();
    void save(Auditoria auditoria);
    void update(Auditoria auditoria);
    List<Auditoria> listAuditoria(String cr);
    List<Auditoria> listAuditoria(String cr, Catalogo estado);
    List<Auditoria> listAuditoriaByAuditor(Long id);
    List<Auditoria> listAuditoriaByAuditor(Long id, Catalogo estado);
    Long countByAuditor(Long id, Catalogo estado);
}
