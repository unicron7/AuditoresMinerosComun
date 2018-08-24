/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import ec.gob.arcom.auditoresmineros.catalogos.Catalogo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Auditor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //Constantes de los nemonicos del estado del auditor
    public static final String TRAMITE= "ESTTRA";
    public static final String REGISTRADO= "ESTREG";
    public static final String INSCRITO_CALIFICADO= "ESTINSCAL";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private String razonSocial;
    private String cedulaRepresentanteLegal;
    private String nombreRepresentanteLegal;
    private String apellidoRepresentanteLegal;
    private Integer aniosExperiencia;
    
    @Column(length = 2000)
    private String resumenExperiencia;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    @OneToOne(cascade={CascadeType.ALL})
    private Direccion direccion;
    
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne
    private Catalogo estado;
    
    private String codigo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDeRegistro;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaDeRegistro;
    private String passwd;
    @Column(nullable = true)
    private boolean activo;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(schema = "audmin")
    private List<Pago> pagos;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(schema = "audmin")
    private List<TipoAuditor> tiposAuditor;
    
    /*
    * Constructor
    */
    public Auditor() {
        this.aniosExperiencia= 0;
    }
}
