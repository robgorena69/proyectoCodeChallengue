package com.dh.CodeChallengue.dominio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dh.CodeChallengue.repository.ActividadRepository;

public class Actividad {

    @Autowired
    ActividadRepository actividadRepository;

    private int idActividad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String descripcion;
    private String estado;
    private Empleado empleado;

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad() {

    }

    public Actividad(Empleado empleado, String descripcion) {
        this.fechaInicio = LocalDateTime.now();
        this.estado = "IN"; // Inicializada
        this.descripcion = descripcion;
        System.out.println("Se creo la actividad paa el empleado" + empleado.getNombreCompleto());
        this.setIdActividad(actividadRepository.registraActividad(this));
    }

    public void eliminarActividad() {
        this.estado = "AN"; // actividad Eliminada
        System.out.println("Se elimino la actividad");
    }

    public void actualizaActividad(Actividad actividad) {
        this.fechaFin = actividad.fechaFin;
        this.descripcion = actividad.descripcion;
    }

    public Actividad findActividadById(int idActividad) {
        System.out.println("Se recupero la actividad");
        return this.actividadRepository.findActividad(idActividad);
    }

    public void verActividadByEmpleado(Empleado empleado) {
        List<Actividad> lstActividades = this.actividadRepository.lstActividadByEmpleado(empleado);
        lstActividades.forEach(act -> {
            System.out.println("Actividad: " + act.idActividad + ", fecha Inicio:" + act.getFechaInicio()
                    + ", fecha Fin:" + act.getFechaFin() + " descripcion:" + act.getDescripcion());
        });

    }
}
