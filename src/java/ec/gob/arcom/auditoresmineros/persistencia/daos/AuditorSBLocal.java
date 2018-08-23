/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.Auditor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface AuditorSBLocal {
    Auditor findByRuc(String ruc);
    List<Auditor> listAuditores();
    List<Auditor> listAuditoresActivos();
    List<Auditor> listAuditoresActivosByEstado(long estado);
    List<Auditor> listAuditores(long estado);
    List<Auditor> listAuditores(long estado, Long tipo);
    Auditor findById(Long id);

    void update(Auditor auditor);
    void delete(Auditor auditor);
}
