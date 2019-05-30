/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Naren
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Responsable extends Usuario implements Serializable {
    
    private String campR;
    @OneToMany(mappedBy = "responsable")
    private List<ServicioSolicitado> servicioSolicitados;

    public Responsable() {
    }

    public Responsable(String campR, List<ServicioSolicitado> servicioSolicitados, Long id, String idTipo, String idNum, String nombre, String email, String clave, String tipoUsuario) {
        super(id, idTipo, idNum, nombre, email, clave, tipoUsuario);
        this.campR = campR;
        this.servicioSolicitados = servicioSolicitados;
    }


    /**
     * @return the campR
     */
    public String getCampR() {
        return campR;
    }

    /**
     * @param campR the campR to set
     */
    public void setCampR(String campR) {
        this.campR = campR;
    }

    /**
     * @return the servicioSolicitados
     */
    public List<ServicioSolicitado> getServicioSolicitados() {
        return servicioSolicitados;
    }

    /**
     * @param servicioSolicitados the servicioSolicitados to set
     */
    public void setServicioSolicitados(List<ServicioSolicitado> servicioSolicitados) {
        this.servicioSolicitados = servicioSolicitados;
    }

}
