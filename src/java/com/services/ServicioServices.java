/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import com.entity.Empresa;
import com.entity.Servicio;
import com.implDao.IServicio;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Jcmm
 */
public class ServicioServices extends ImplDao<Servicio, Long> implements IServicio,Serializable{
    
    public List<Servicio> misEmpresas(Empresa emp) {
        List<Servicio> misSer = new LinkedList<>();
        EntityManager em = ImplDao.getEntityManagger();
        em.getTransaction().begin();
        try {
            String q = "SELECT s FROM Servicio s WHERE s.empresa = ?1";
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
