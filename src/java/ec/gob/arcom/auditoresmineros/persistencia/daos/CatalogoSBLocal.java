/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.daos;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mejiaw
 */
@Local
public interface CatalogoSBLocal {
    void save(Catalogo catalogo);
    void update(Catalogo catalogo);
    void delete(Catalogo catalogo);
    Catalogo find(Long id);
    Catalogo findByName(String name);
    List<Catalogo> list();
    List listByTipoCatalogo(Long pk);
    public Catalogo findByNemonico(String nemonico);
}
