/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.controller.FacesUtil;
import com.dao.ImplDao;
import com.entity.Comprador;
import com.entity.Cotizacion;
import com.entity.Empresa;
import com.entity.Servicio;
import java.io.Serializable;
import com.implDao.IComprador;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Jcmm
 */
public class CompradorServices extends ImplDao<Comprador, Long> implements IComprador,Serializable{
    
    public List<Cotizacion> misCotizaciones(Cotizacion cot) {
        List<Cotizacion> misCot = new LinkedList<>();
        EntityManager em = ImplDao.getEntityManagger();
        em.getTransaction().begin();
        try {
            String q = "SELECT s FROM Cotizacion c WHERE c.comprador = ?1";
            Query qu = em.createQuery(q)
                    .setParameter(1, cot);
            misCot = qu.getResultList();
        } catch (Exception ex) {
            FacesUtil.addErrorMessage("No se encontraron servicios", ex.getMessage());
        } finally {
            em.close();
        }
        return misCot;
    }
   
}
