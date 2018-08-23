/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.catalogos.TipoCatalogo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface TipoCatalogoSBLocal {
    void save(TipoCatalogo tipoCatalogo);
    void update(TipoCatalogo tipoCatalogo);
    void delete(TipoCatalogo tipoCatalogo);
    TipoCatalogo find(Long id);
    List<TipoCatalogo> list();
    TipoCatalogo findByDescripcion(String descripcion);
    TipoCatalogo findByNemonico(String nemonico);
}
