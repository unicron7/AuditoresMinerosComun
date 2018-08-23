/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author mejiaw
 */
@Entity
//@Table(name="audmin.funcionario")
@Table(schema = "audmin")
@Data
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final long ADMINISTRADOR= 9;
    public static final long CALIFICADOR= 8;
    public static final long TALENTO_HUMANO= 7;
    public static final long JURIDICO= 6;
    public static final long DIRECTIVO= 18;
    
    /*
    * Propiedades
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userPassword;
    private String nombre;
    private String apellido;
    private String cargo;
    private String email;
    private Long tipoFuncionario;
    private boolean administrador;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaRegistro;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaActualizacion;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date horaActualizacion;
    
}
