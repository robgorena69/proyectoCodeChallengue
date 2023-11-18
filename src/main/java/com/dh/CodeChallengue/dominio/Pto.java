package com.dh.CodeChallengue.dominio;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.dh.CodeChallengue.repository.ActividadRepository;
import com.dh.CodeChallengue.repository.PtoRepository;

public class Pto {

    @Autowired
    PtoRepository ptoRepository;

    private Long id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private String estado;
    private Empleado solicitante;
    private Responsable responsableEquipo;

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

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public Responsable getResponsableEquipo() {
        return responsableEquipo;
    }

    public void setResponsableEquipo(Responsable responsableEquipo) {
        this.responsableEquipo = responsableEquipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void creaPto(Empleado empleado) {
        this.setEstado("AC");
        this.setFechaInicio(LocalDateTime.now());
        this.setSolicitante(empleado);
        this.setResponsableEquipo(empleado.getEquipoEmpleado().getResponsableEquipo());
        this.ptoRepository.crearPto(this);
    };

    public void actualizarPto(Pto pto) {
        Pto ptoActualizar = this.ptoRepository.findPtoById(pto.getId());
        ptoActualizar.setEstado(pto.getEstado());
        ptoActualizar.setFechaFin(pto.fechaFin);
        this.ptoRepository.actualizaPto(ptoActualizar);
    };

    public void cancelarPTO() {
        this.setEstado("CA");
        this.setFechaFin(LocalDateTime.now());
        this.actualizarPto(this);
    }

    public Pto findPto(Long idPto) {
        return this.ptoRepository.findPtoById(idPto);
    }

}
