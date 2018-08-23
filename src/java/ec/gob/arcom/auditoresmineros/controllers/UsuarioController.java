/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.auditoresmineros.controllers;

import ec.gob.arcom.auditoresmineros.persistencia.daos.UsuarioSBLocal;
import ec.gob.arcom.auditoresmineros.persistencia.entidades.Usuario;


/**
 *
 * @author mejiaw
 */
public class UsuarioController {

    public static Usuario buscarPorDocumento(UsuarioSBLocal usuarioDao, String documento) {
        return usuarioDao.findByLogin(documento);
    }
}
