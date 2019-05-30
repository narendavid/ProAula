/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import com.entity.Empresa;
import com.entity.ServicioSolicitado;
import com.implDao.IServicioSolicitado;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jcmm
 */
public class ServicioSolicitadoServices extends ImplDao<ServicioSolicitado, Long> implements IServicioSolicitado, Serializable {

    public List<ServicioSolicitado> misServiciosSolicitados(Empresa emp) {
        List<ServicioSolicitado> misSer = new LinkedList<>();
        EntityManager em = ImplDao.getEntityManagger();
        em.getTransaction().begin();
        try {
            String q = "SELECT s FROM ServicioSolicitado s WHERE s.servicio.empresa=?1";
            Query qu = em.createQuery(q)
                    .setParameter(1, emp);
            misSer = qu.getResultList();
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("No se encontraron servicios", ex.getMessage());
        } finally {
            em.close();
        }
        return misSer;
    }

}
