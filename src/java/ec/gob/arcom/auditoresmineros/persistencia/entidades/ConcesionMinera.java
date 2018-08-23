/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mejiaw
 */
@Entity
@Table(name="concesion_minera", schema="catmin")
public class ConcesionMinera implements Serializable {
    /*
    * Propiedades 
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_concesion;
    private String codigo_arcom;
    private String nombre_concesion;
    private String documento_concesionario_principal;
    @JoinColumn(name = "codigo_tipo_mineria", referencedColumnName = "codigo_tipo_mineria")
    @ManyToOne(optional = false)
    private TipoMineria tipoMineria;
    private boolean estado_registro;
    private Long estado_concesion;
    
    /*
    * Getters and Setters
    */
    public Long getCodigo_concesion() {
        return codigo_concesion;
    }

    public void setCodigo_concesion(Long codigo_concesion) {
        this.codigo_concesion = codigo_concesion;
    }

    public String getCodigo_arcom() {
        return codigo_arcom;
    }

    public void setCodigo_arcom(String codigo_arcom) {
        this.codigo_arcom = codigo_arcom;
    }

    public String getNombre_concesion() {
        return nombre_concesion;
    }

    public void setNombre_concesion(String nombre_concesion) {
        this.nombre_concesion = nombre_concesion;
    }

    public String getDocumento_concesionario_principal() {
        return documento_concesionario_principal;
    }

    public void setDocumento_concesionario_principal(String documento_concesionario_principal) {
        this.documento_concesionario_principal = documento_concesionario_principal;
    }

    public TipoMineria getTipoMineria() {
        return tipoMineria;
    }

    public void setTipoMineria(TipoMineria tipoMineria) {
        this.tipoMineria = tipoMineria;
    }

    public boolean isEstado_registro() {
        return estado_registro;
    }

    public void setEstado_registro(boolean estado_registro) {
        this.estado_registro = estado_registro;
    }

    public Long getEstado_concesion() {
        return estado_concesion;
    }

    public void setEstado_concesion(Long estado_concesion) {
        this.estado_concesion = estado_concesion;
    }
}
