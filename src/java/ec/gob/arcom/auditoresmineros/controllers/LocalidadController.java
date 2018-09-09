/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import ec.gob.arcom.auditoresmineros.persistencia.daos.LocalidadSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Localidad;
import java.util.List;

/**
 *
 * @author mejiaw
 */
public class LocalidadController {
    
    public static List<Localidad> getProvincias(LocalidadSBLocal localidadSB) {
        return localidadSB.listProvincia();
    }
    
    public static Localidad getProvinciaByCodigoInec(String codigoInec, LocalidadSBLocal localidadDao) {
        return localidadDao.findByCodigoInec(codigoInec);
    }
}
