/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Cotizacion;
import com.entity.Empresa;
import com.entity.Servicio;
import com.entity.ServicioSolicitado;
import com.services.ServicioServices;
import com.services.ServicioSolicitadoServices;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Naren
 */
@ManagedBean
@SessionScoped
public class EmpresaController {

    private String paginaActual;
    /*OBJETOS*/
    private Empresa empresa = new Empresa();
    private Servicio servicio = new Servicio();
    
    /*SERVICIOS*/
    ServicioServices servicioServices = new ServicioServices();
    ServicioSolicitadoServices servicioSolicitadoServices = new ServicioSolicitadoServices();
    
    /*LISTAS*/
    private List<Servicio> servicios = new LinkedList<>();
    private List<Cotizacion> cotizaciones = new LinkedList<>();
    private List<ServicioSolicitado> serviciosSolicitadosP = new LinkedList<>();

    /**
     * Creates a new instance of EmpresaController
     */
    public EmpresaController() {
        empresa = new Empresa();
        paginaActual = "/empresa/inicioEmpresa.xhtml";
    }

    /*RUTAS*/
    
    public void irACotRec(){
        System.out.println(empresa);
        paginaActual = "/empresa/cotizaciones.xhtml";
        setServiciosSolicitadosP(servicioSolicitadoServices.misServiciosSolicitados(empresa));
        System.out.println("Mis cotizaciones "+getServiciosSolicitadosP());
    }
    
    public void irAMisServicios() {
        paginaActual = "/empresa/misServicios.xhtml";
        servicios = servicioServices.misEmpresas(empresa);
        System.out.println(servicios);
    }

    public void irAPubServ() {
        paginaActual = "/empresa/publicarServicios.xhtml";
    }

    public void irAInicio(Empresa emp) {
        paginaActual = "/empresa/inicioEmpresa.xhtml";
        empresa = emp;
        System.out.println("Hola" + empresa);
        setServiciosSolicitadosP(servicioSolicitadoServices.misServiciosSolicitados(empresa));
        System.out.println(getServiciosSolicitadosP());
        System.out.println(servicioServices.misEmpresas(empresa));
    }

    /*SERVICIOS*/
    public void pubSer() {
        servicio.setEmpresa(empresa);
        servicioServices.crear(servicio);
        servicio = new Servicio();
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
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

    /**
     * @return the paginaActual
     */
    public String getPaginaActual() {
        return paginaActual;
    }

    /**
     * @param paginaActual the paginaActual to set
     */
    public void setPaginaActual(String paginaActual) {
        this.paginaActual = paginaActual;
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

    /**
     * @return the serviciosSolicitadosP
     */
    public List<ServicioSolicitado> getServiciosSolicitadosP() {
        return serviciosSolicitadosP;
    }

    /**
     * @param serviciosSolicitadosP the serviciosSolicitadosP to set
     */
    public void setServiciosSolicitadosP(List<ServicioSolicitado> serviciosSolicitadosP) {
        this.serviciosSolicitadosP = serviciosSolicitadosP;
    }

  

}
