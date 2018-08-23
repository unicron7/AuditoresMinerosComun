/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.beans;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import ec.gob.arcom.auditoresmineros.catalogos.TipoCatalogo;
import ec.gob.arcom.auditoresmineros.controllers.CatalogoController;
import ec.gob.arcom.auditoresmineros.persistencia.daos.CatalogoSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.daos.TipoCatalogoSBLocal;
import ec.gob.arcom.auditoresmineros.util.FacesUtilComun;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author mejiaw
 */
@Named(value = "catalogMB")
@SessionScoped
public class CatalogMB implements Serializable {
    @EJB
    private TipoCatalogoSBLocal tipoCatalogoSB;
    @EJB
    private CatalogoSBLocal catalogoSB;
    
    private List<TipoCatalogo> tiposCatalogo;
    private List<Catalogo> catalogos;
    private TipoCatalogo tipoCatalogo;
    private Catalogo catalogo;
    private List<Catalogo> tiposAuditor;


    /**
     * Creates a new instance of CatalogMB
     */
    @PostConstruct
    private void cargarTiposCatalogo() {
        this.tiposCatalogo= tipoCatalogoSB.list();
        this.tipoCatalogo= new TipoCatalogo();
        this.catalogo= new Catalogo();
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }

    public List<TipoCatalogo> getTiposCatalogo() {
        return tiposCatalogo;
    }

    public void setTiposCatalogo(List<TipoCatalogo> tiposCatalogo) {
        this.tiposCatalogo = tiposCatalogo;
    }
    
    
    public void editCatalogoAction(Integer row) {
        this.tipoCatalogo= this.tiposCatalogo.get(row);
        //this.catalogos= this.catalogoSB.listByTipo(this.tipoCatalogo.getId());
        this.catalogos= CatalogoController.listarCatalogoPorTipo(catalogoSB, tipoCatalogo);
        for (Catalogo catalogo1 : catalogos) {
            System.out.println(catalogo1.getNombre());
        }
    }

    public TipoCatalogo getTipoCatalogo() {
        return tipoCatalogo;
    }

    public void setTipoCatalogo(TipoCatalogo tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Catalogo> getTiposAuditor() {
        tiposAuditor= CatalogoController.getTiposAuditor(tipoCatalogoSB, catalogoSB);
        return tiposAuditor;
    }

    public void setTiposAuditor(List<Catalogo> tiposAuditor) {
        this.tiposAuditor = tiposAuditor;
    }
    
    public void saveTipoCatalogo() {
        tipoCatalogo.setDescripcion(tipoCatalogo.getDescripcion().toUpperCase());
        tipoCatalogoSB.save(tipoCatalogo);
        this.tipoCatalogo= new TipoCatalogo();
        this.tiposCatalogo= tipoCatalogoSB.list();
        FacesUtilComun.showInfoMessage("Aviso", "¡Ha sido creado un nuevo tipo de catalogo!");
    }
    
    public void saveCatalogo() {
        catalogo.setActivo(true);
        catalogo.setNombre(catalogo.getNombre().toUpperCase());
        catalogo.setDescripcion(catalogo.getDescripcion().toUpperCase());
        catalogo.setTipoCatalogo(tipoCatalogo);
        catalogoSB.save(catalogo);
        this.catalogo= new Catalogo();
        //this.catalogos= this.catalogoSB.listByTipo(this.tipoCatalogo.getId());
        this.catalogos= CatalogoController.listarCatalogoPorTipo(catalogoSB, tipoCatalogo);
        FacesUtilComun.showInfoMessage("Aviso", "¡Ha sido creado un nuevo catalogo!");
    }
}
