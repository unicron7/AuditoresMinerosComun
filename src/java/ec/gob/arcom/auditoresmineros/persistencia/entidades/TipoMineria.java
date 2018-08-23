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
import javax.persistence.Table;

/**
 *
 * @author mejiaw
 */
@Entity
@Table(name="tipo_mineria",schema = "catmin")
public class TipoMineria implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_tipo_mineria;
    private String nemonico_tipo_mineria;
    private String nombre_tipo_mineria;

    public Long getCodigo_tipo_mineria() {
        return codigo_tipo_mineria;
    }

    public void setCodigo_tipo_mineria(Long codigo_tipo_mineria) {
        this.codigo_tipo_mineria = codigo_tipo_mineria;
    }

    public String getNemonico_tipo_mineria() {
        return nemonico_tipo_mineria;
    }

    public void setNemonico_tipo_mineria(String nemonico_tipo_mineria) {
        this.nemonico_tipo_mineria = nemonico_tipo_mineria;
    }

    public String getNombre_tipo_mineria() {
        return nombre_tipo_mineria;
    }

    public void setNombre_tipo_mineria(String nombre_tipo_mineria) {
        this.nombre_tipo_mineria = nombre_tipo_mineria;
    }
    
}
