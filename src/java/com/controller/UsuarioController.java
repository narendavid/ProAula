/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entity.Comprador;
import com.entity.Empresa;
import com.entity.Responsable;
import com.entity.Servicio;
import com.entity.Usuario;
import com.services.CompradorServices;
import com.services.EmpresaServices;
import com.services.ResponsableServices;
import com.services.UsuarioServices;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Naren
 */
@ManagedBean
@SessionScoped
public class UsuarioController {

    private String paginaActual;
    private boolean mostrarPL;
    /*Objetos*/
    private Usuario usuario = new Usuario();
    private Responsable responsable = new Responsable();
    private Comprador comprador = new Comprador();
    private Empresa empresa = new Empresa();
    private Servicio servicio = new Servicio();
    /*Servicios*/
    UsuarioServices usuarioServices = new UsuarioServices();
    ResponsableServices responsableServices = new ResponsableServices();
    CompradorServices compradorServices = new CompradorServices();
    EmpresaServices empresaServices = new EmpresaServices();

    /*CONTROLADORES*/
    @ManagedProperty(value = "#{empresaController}")
    private EmpresaController empresaController = new EmpresaController();
    @ManagedProperty(value = "#{compradorController}")
    private CompradorController compradorController = new CompradorController();

    /*Listas*/
    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
        mostrarPL = true;
        paginaActual = "paginaIni.xhtml";
    }

    /*Rutas para registrar*/
    public void irAREmpresa() {
        paginaActual = "registroEmpresa.xhtml";
    }

    public void irARComprador() {
        paginaActual = "registroComprador.xhtml";
    }

    /*Registro de usuarios*/
    public void registrarC() {
        comprador.setTipoUsuario("Comprador");
        compradorServices.crear(comprador);
        comprador = new Comprador();
    }

    public void registrarR() {
        responsable.setTipoUsuario("Responsable");
        responsableServices.crear(responsable);
        responsable = new Responsable();
    }

    public void registrarE() {
        getEmpresa().setTipoUsuario("Empresa");
        empresaServices.crear(getEmpresa());
        setEmpresa(new Empresa());
    }

    /*Login*/
    public void login() {
        usuario = usuarioServices.ingresar(usuario.getEmail(), usuario.getClave());
        System.out.println(usuario);
        if (usuario.getEmail() != null) {
            mostrarPL = false;
            if (usuario.getTipoUsuario().equals("Empresa")) {
                setEmpresa(empresaServices.consultar(Empresa.class, usuario.getId()));
                empresaController.irAInicio(getEmpresa());
                paginaActual = "/empresa/GUIEmpresa.xhtml";
            } else if (usuario.getTipoUsuario().equals("Comprador")) {
                setComprador(compradorServices.consultar(Comprador.class, usuario.getId()));
                compradorController.irAlInicio(comprador);
                paginaActual = "/comprador/GUIComprador.xhtml";
            } else if (usuario.getTipoUsuario().equals("Responsable")) {
                paginaActual = "/responsable/GUIResponsable.xhtml";
            }
        }
    }

    public void cerrar() {
        mostrarPL = true;
        paginaActual = "paginaIni.xhtml";
        usuario = new Usuario();
        empresa = new Empresa();
        comprador = new Comprador();
        responsable = new Responsable();
        servicio = new Servicio();
        empresaController = new EmpresaController();
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the mostrarPL
     */
    public boolean isMostrarPL() {
        return mostrarPL;
    }

    /**
     * @param mostrarPL the mostrarPL to set
     */
    public void setMostrarPL(boolean mostrarPL) {
        this.mostrarPL = mostrarPL;
    }

    /**
     * @return the responsable
     */
    public Responsable getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
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
     * @return the empresaController
     */
    public EmpresaController getEmpresaController() {
        return empresaController;
    }

    /**
     * @param empresaController the empresaController to set
     */
    public void setEmpresaController(EmpresaController empresaController) {
        this.empresaController = empresaController;
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
     * @return the compradorController
     */
    public CompradorController getCompradorController() {
        return compradorController;
    }

    /**
     * @param compradorController the compradorController to set
     */
    public void setCompradorController(CompradorController compradorController) {
        this.compradorController = compradorController;
    }

}
