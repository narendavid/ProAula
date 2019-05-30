/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Comprador;
import com.entity.Cotizacion;
import com.entity.Servicio;
import com.entity.ServicioSolicitado;
import com.services.CompradorServices;
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
public class CompradorController {

    private String paginaActual;
    /*OBJETOS*/
    private Comprador comprador = new Comprador();
    private Cotizacion cotizacion = new Cotizacion();
    private Servicio servicio = new Servicio();
    private ServicioSolicitado servicioSolicitado = new ServicioSolicitado();

    /*SERVICIOS*/
    ServicioServices servicioServices = new ServicioServices();
    CompradorServices compradorServices = new CompradorServices();
    ServicioSolicitadoServices servicioSolicitadoServices = new ServicioSolicitadoServices(); 

    /*LISTAS*/
    private List<Servicio> servicios = new LinkedList<>();
    private List<Cotizacion> cotizaciones = new LinkedList<>();

    /**
     * Creates a new instance of CompradorController
     */
    public CompradorController() {
        listar();
    }

    public void irAlInicio(Comprador comp) {
        paginaActual = "/comprador/inicioComprador.xhtml";
        setComprador(comp);
        System.out.println(getComprador());
    }

    public void listar() {
        servicios = servicioServices.consultarTodo(Servicio.class);
    }

    /*RUTAS*/
    public void irAInicio() {
        paginaActual = "/comprador/inicioComprador.xhtml";
    }

    public void irAServicios() {
        listar();
        paginaActual = "/comprador/servicios.xhtml";
    }

    public void irACotizaciones() {
        paginaActual = "/comprador/misCotizaciones.xhtml";
        cotizaciones = compradorServices.misCotizaciones(cotizacion);
        System.out.println(cotizaciones);
    }

    /*crud servicios*/
    public void pubSer() {
        servicioServices.crear(servicio);
    }

    /*SOLICITAR SERVICIO*/
    public void agregarCotSer(Servicio s) {
        cotizacion.getServicios().add(s);
    }
    
    public void quitarCotSer(Servicio s) {
        cotizacion.getServicios().remove(s);
    }

    public void cotizar() {
        cotizacion.setComprador(comprador);
        for (Servicio mSer : cotizacion.getServicios()) {
            System.out.println("Hdsd "+mSer);
            servicioSolicitado.setEstado("Pendiente");
            servicioSolicitado.setServicio(mSer);
            servicioSolicitadoServices.crear(servicioSolicitado);
        }
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
     * @return the comprador
     */
    public Comprador getComprador() {
        return comprador;
    }

    /**
     * @param comprador the comprador to set
     */
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    /**
     * @return the cotizacion
     */
    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    /**
     * @param cotizacion the cotizacion to set
     */
    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
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
     * @return the servicioSolicitado
     */
    public ServicioSolicitado getServicioSolicitado() {
        return servicioSolicitado;
    }

    /**
     * @param servicioSolicitado the servicioSolicitado to set
     */
    public void setServicioSolicitado(ServicioSolicitado servicioSolicitado) {
        this.servicioSolicitado = servicioSolicitado;
    }

}
