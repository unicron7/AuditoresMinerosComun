/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.persistencia.entidades.EmpresaConsultoraAuditoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface EmpresaConsultoraSBLocal {

    void saveECA(EmpresaConsultoraAuditoria empresaConsultoraAuditoria);

    EmpresaConsultoraAuditoria findByRuc(String ruc);
    
    List<EmpresaConsultoraAuditoria> findByRuc(String ruc, String criterio);
    
    List<EmpresaConsultoraAuditoria> listarECA();
    
    List<EmpresaConsultoraAuditoria> listarECAActivo();

    void updateECA(EmpresaConsultoraAuditoria profesionalAuditorExterno);

    EmpresaConsultoraAuditoria findById(Long id);
    
    EmpresaConsultoraAuditoria getECAJoinFetchPago(Long id);
}
