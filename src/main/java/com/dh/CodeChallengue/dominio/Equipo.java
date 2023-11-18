package com.dh.CodeChallengue.dominio;

public class Equipo {

    private String nombreEquipo;
    private Responsable responsableEquipo;

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Responsable getResponsableEquipo() {
        return responsableEquipo;
    }

    public void setResponsableEquipo(Responsable responsableEquipo) {
        this.responsableEquipo = responsableEquipo;
    }

    public void verActividadByEmpleado(Empleado empleado) {
        empleado.verActividades(); // Al pasar la instancia de Empleado, y este tiene el metodo para ver las
                                   // actividad, entonces se puede ver el reporte del empleado
    }

}
