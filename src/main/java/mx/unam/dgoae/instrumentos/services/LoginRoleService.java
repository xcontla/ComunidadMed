/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services;

import mx.unam.dgoae.instrumentos.entity.Login;

/**
 *
 * @author UNAM
 */
public interface LoginRoleService {
    Login loginWithCurp(String cCurp);
}
