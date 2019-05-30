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
public class Comprador extends Usuario implements Serializable {
    
    @OneToMany
    private List<Cotizacion> cotizaciones;

    public Comprador() {
    }

    public Comprador(List<Cotizacion> cotizaciones, Long id, String idTipo, String idNum, String nombre, String email, String clave, String tipoUsuario) {
        super(id, idTipo, idNum, nombre, email, clave, tipoUsuario);
        this.cotizaciones = cotizaciones;
    }

    /**
     * @return the cotizaciones
     */
    public List<Cotizacion> getCotizaciones() {
        return cotizaciones;
    }

    /**
     * @param cotizaciones the cotizaciones to set
     */
    public void setCotizaciones(List<Cotizacion> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }


}
