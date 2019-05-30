/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import com.entity.Usuario;
import com.implDao.IUsuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class UsuarioServices extends ImplDao<Usuario, Long> implements IUsuario, Serializable {

    public Usuario ingresar(String e, String c) {
        Usuario usu = new Usuario();
        EntityManager em = ImplDao.getEntityManagger();
        em.getTransaction().begin();
        try {
            String q = "SELECT u FROM Usuario u WHERE u.email = ?1 and u.clave = ?2";
            Query qu = em.createQuery(q)
                    .setParameter(1, e)
                    .setParameter(2, c);
            usu = (Usuario) qu.getSingleResult();
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("Error al iniciar sesion", ex.getMessage());
        } finally {
            em.close();
        }
        return usu;
    }

}
