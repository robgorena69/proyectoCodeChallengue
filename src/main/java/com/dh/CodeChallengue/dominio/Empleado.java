package com.dh.CodeChallengue.dominio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class Empleado {

    private String nombre;
    private String apellido;
    private String email;
    private String estado;
    private Equipo equipoEmpleado;

    @Autowired
    Actividad actividad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Equipo getEquipoEmpleado() {
        return equipoEmpleado;
    }

    public void setEquipoEmpleado(Equipo equipoEmpleado) {
        this.equipoEmpleado = equipoEmpleado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido + " ";
    }

    public void crearActividad() {
        Actividad act = new Actividad(this, "Registra solicitud Tracker");

    }

    public void eliminaActividad(int idActividad) {
        actividad.findActividadById(idActividad);
        actividad.eliminarActividad();
    }

    public void finalizaActividad(int idActividad) {
        Actividad actModificar = this.actividad.findActividadById(idActividad);
        actModificar.setFechaFin(LocalDateTime.now());
        actModificar.setEstado("TE"); // FINALIZADO
        this.actividad.actualizaActividad(actModificar);
    }

    public void verActividades() {
        this.actividad.verActividadByEmpleado(this);

    }

}
