/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.AuditoriaSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Auditoria;
import java.util.List;

/**
 *
 * @author mejiaw
 */
public class AuditoriaController {
    public static List<Auditoria> listarAuditoriaPorAuditor(AuditoriaSBLocal auditoriaDao, Long id) {
        return auditoriaDao.listAuditoriaByAuditor(id);
    }
    
    public static List<Auditoria> listarAuditoriaPorAuditor(AuditoriaSBLocal auditoriaDao, Long id, Catalogo estado) {
        return auditoriaDao.listAuditoriaByAuditor(id, estado);
    }
    
    public static void actualizarAuditoria(AuditoriaSBLocal auditoriaDao, Auditoria auditoria) {
        auditoriaDao.update(auditoria);
    }
    
    public static List<Auditoria> listarAuditoriaPorDocumento(AuditoriaSBLocal auditoriaDao, String documento, Catalogo estado) {
        return auditoriaDao.listAuditoria(documento, estado);
    }
    
    public static Long contarAuditoriaPorAuditor(AuditoriaSBLocal auditoriaDao, Long id, Catalogo estado) {
        return auditoriaDao.countByAuditor(id, estado);
    }
    
    public static List<Auditoria> listarAuditorias(AuditoriaSBLocal auditoriaDao) {
        return auditoriaDao.listAuditoria();
    }
}
