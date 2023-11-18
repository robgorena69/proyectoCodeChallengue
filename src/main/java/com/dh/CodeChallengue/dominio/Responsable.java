package com.dh.CodeChallengue.dominio;

import org.springframework.beans.factory.annotation.Autowired;

public class Responsable {

    @Autowired
    Pto pto;
    private Empleado encargado;

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    public void aprobarPto(Long idPto) {
        Pto ptoSolicitado = this.pto.findPto(idPto);
        ptoSolicitado.setEstado("AP"); // se rechaza el PTO
        this.pto.actualizarPto(ptoSolicitado);
    }

    public void rechazarPto(Long idPto) {
        Pto ptoSolicitado = this.pto.findPto(idPto);
        ptoSolicitado.setEstado("RE"); // se rechaza el PTO
        this.pto.actualizarPto(ptoSolicitado);
    }

}
