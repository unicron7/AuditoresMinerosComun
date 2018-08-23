/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author Will
 */
@Entity
@Table(schema = "audmin")
@Data
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeInicio;
    @OneToOne
    private Catalogo institucion;
    private String lugar;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeRegistro;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaDeRegistro;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaActualizacion;
    private boolean activo;
    //Solicitados para agregar
    private String facultad;
    private String personaContacto;
    private String correoElectronico;
    private String telefonoFijo;
    private String telefonoMovil;
    private String link;
}
