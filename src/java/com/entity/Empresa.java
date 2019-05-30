/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.LinkedList;
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
public class Empresa extends Usuario implements Serializable {

    private String campE;
    @OneToMany
    private List<Servicio> servicios = new LinkedList<>();

    public Empresa() {
    }

    public Empresa(String campE, Long id, String idTipo, String idNum, String nombre, String email, String clave, String tipoUsuario) {
        super(id, idTipo, idNum, nombre, email, clave, tipoUsuario);
        this.campE = campE;
    }

    /**
     * @return the campE
     */
    public String getCampE() {
        return campE;
    }

    /**
     * @param campE the campE to set
     */
    public void setCampE(String campE) {
        this.campE = campE;
    }

    /**
     * @return the servicios
     */
    public List<Servicio> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

}
