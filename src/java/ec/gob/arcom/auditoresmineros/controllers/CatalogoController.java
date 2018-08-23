/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.catalogos.TipoCatalogo;
import ec.gob.arcom.auditoresmineros.persistencia.daos.CatalogoSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.daos.TipoCatalogoSBLocal;
import java.util.List;

/**
 *
 * @author mejiaw
 */
public class CatalogoController {
    public static List<Catalogo> getInstituciones(TipoCatalogoSBLocal tipoCatalogoDao, CatalogoSBLocal catalogoDao) {
        TipoCatalogo tipoCatalogo= obtenerTipoCatalogoPorNemonico(tipoCatalogoDao, "INSEDU");
        List<Catalogo> instituciones= listarCatalogoPorTipo(catalogoDao, tipoCatalogo);
        return instituciones;
    }
    
    public static List<Catalogo> getTiposUsuario(TipoCatalogoSBLocal tipoCatalogoDao, CatalogoSBLocal catalogoDao) {
        TipoCatalogo tipoCatalogo= obtenerTipoCatalogoPorNemonico(tipoCatalogoDao, "TIPFUN");
        List<Catalogo> tiposUsuario= listarCatalogoPorTipo(catalogoDao, tipoCatalogo);
        return tiposUsuario;
    }
    
    public static List<Catalogo> getTiposAuditor(TipoCatalogoSBLocal tipoCatalogoDao, CatalogoSBLocal catalogoDao) {
        TipoCatalogo tipoCatalogo= obtenerTipoCatalogoPorNemonico(tipoCatalogoDao, "TIPAUD");
        List<Catalogo> tiposAuditor= listarCatalogoPorTipo(catalogoDao, tipoCatalogo);
        return tiposAuditor;
    }
    
    public static List<Catalogo> getEstadosAuditor(TipoCatalogoSBLocal tipoCatalogoDao, CatalogoSBLocal catalogoDao) {
        TipoCatalogo tipoCatalogo= obtenerTipoCatalogoPorNemonico(tipoCatalogoDao, "ESTAUD");
        List<Catalogo> estadosAuditor= listarCatalogoPorTipo(catalogoDao, tipoCatalogo);
        return estadosAuditor;
    }
    
    public static Catalogo getCatalogoById(Long id, CatalogoSBLocal catalogoDao) {
        return catalogoDao.find(id);
    }
    
    public static TipoCatalogo obtenerTipoCatalogoPorNemonico(TipoCatalogoSBLocal tipoCatalogoDao, String nemonico) {
        return tipoCatalogoDao.findByNemonico(nemonico);
    }
    
    public static List<Catalogo> listarCatalogoPorTipo(CatalogoSBLocal catalogoDao, TipoCatalogo tipoCatalogo) {
        return catalogoDao.listByTipoCatalogo(tipoCatalogo.getId());
    }
}
